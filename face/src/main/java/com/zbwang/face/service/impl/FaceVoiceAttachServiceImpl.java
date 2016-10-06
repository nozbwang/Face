package com.zbwang.face.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zbwang.face.constant.FaceConstants;
import com.zbwang.face.dao.FaceVoiceAttachDao;
import com.zbwang.face.domain.FaceVoiceAttach;
import com.zbwang.face.domain.FaceVoiceAttachLink;
import com.zbwang.face.service.FaceVoiceAttachLinkService;
import com.zbwang.face.service.FaceVoiceAttachService;
import com.zbwang.face.util.CommonUtil;

@Service
public class FaceVoiceAttachServiceImpl implements FaceVoiceAttachService {
	@Autowired
	private FaceVoiceAttachDao faceVoiceAttachDao;
	@Autowired
	private FaceVoiceAttachLinkService faceVoiceAttachLinkService;
	@Autowired
	private PictureCompressService pictureCompressService;
	@Autowired
	private PictureDownloadService pictureDownloadService;
	@Value("#{propertyConfigurer['compress.picture.maxsize']}")
	private Long compressPictureMaxSize;

	@Override
	public int insertVoiceAttach(FaceVoiceAttach faceVoiceAttach) {
		return faceVoiceAttachDao.insertVoiceAttach(faceVoiceAttach);
	}

	@Override
	public List<FaceVoiceAttach> getAttachNeedCompress() {
		return faceVoiceAttachDao.getAttachNeedCompress(compressPictureMaxSize);
	}

	@Override
	public Map<String, List<FaceVoiceAttach>> getAttachByVoiceIdGroup(List<Integer> voiceIds) {
		List<FaceVoiceAttach> faceVoiceAttachGroup = faceVoiceAttachDao.getAttachByVoiceIdGroup(voiceIds);
		Map<String, List<FaceVoiceAttach>> result = new HashMap<String, List<FaceVoiceAttach>>();
		for (FaceVoiceAttach faceVoiceAttach : faceVoiceAttachGroup) {
			String voiceId = String.valueOf(faceVoiceAttach.getBelongId());
			if (!result.containsKey(voiceId)) {
				result.put(voiceId, new ArrayList<FaceVoiceAttach>());
			}
			result.get(voiceId).add(faceVoiceAttach);
		}
		return result;
	}

	@Override
	public Map<String, List<FaceVoiceAttach>> getAttachByVoiceIdGroup(List<Integer> voiceIds, String belongType) {
		List<FaceVoiceAttach> faceVoiceAttachGroup = faceVoiceAttachDao.getAttachByBelongType(voiceIds, belongType);
		Map<String, List<FaceVoiceAttach>> result = new HashMap<String, List<FaceVoiceAttach>>();
		for (FaceVoiceAttach faceVoiceAttach : faceVoiceAttachGroup) {
			String voiceId = String.valueOf(faceVoiceAttach.getBelongId());
			if (!result.containsKey(voiceId)) {
				result.put(voiceId, new ArrayList<FaceVoiceAttach>());
			}
			result.get(voiceId).add(faceVoiceAttach);
		}
		return result;
	}

	@Override
	public FaceVoiceAttach getAttachByAttachId(Integer attachId) {
		return faceVoiceAttachDao.getAttachByAttachId(attachId);
	}

	@Override
	public List<Integer> insertLocalPicture(Integer userId, Map<String, Object> elements, int belongId) {
		List<FileItem> localPictures = (List<FileItem>) elements.get("file");
		String belongType = (String) elements.get("belongType");
		List<Integer> localPictureIds = new ArrayList<Integer>();
		if (CollectionUtils.isNotEmpty(localPictures)) {
			for (FileItem localPicture : localPictures) {
				FaceVoiceAttach faceVoiceAttach = new FaceVoiceAttach();
				faceVoiceAttach.setBelongId(belongId);
				faceVoiceAttach.setBelongType(belongType);
				faceVoiceAttach.setUserId(userId);
				faceVoiceAttach.setAttachmentName(getPhotoNameLimited(localPicture.getName()));
				faceVoiceAttach.setSize(localPicture.getSize());
				faceVoiceAttach.setType(localPicture.getContentType());
				faceVoiceAttach.setContent(localPicture.get());
				localPicture.delete();
				int localPictureId = insertVoiceAttach(faceVoiceAttach);
				localPictureIds.add(localPictureId);
			}
			return localPictureIds;
		}
		return Collections.emptyList();
	}

	@Override
	public int insertPictureFromRemote(Integer userId, Map<String, Object> elements, int belongId) {
		String pictureLink = (String) elements.get("pictureLink");
		String belongType = (String) elements.get("belongType");
		if (CommonUtil.isPictureLink(pictureLink)) {
			FaceVoiceAttach faceVoiceAttach = new FaceVoiceAttach();
			byte[] content = pictureDownloadService.getPictureFromRemoteUrl(pictureLink);
			if (ArrayUtils.isNotEmpty(content)) {
				faceVoiceAttach.setBelongId(belongId);
				faceVoiceAttach.setBelongType(belongType);
				faceVoiceAttach.setUserId(userId);
				faceVoiceAttach.setAttachmentName(getPhotoNameLimited(pictureLink.substring(pictureLink.lastIndexOf("/") + 1)));
				faceVoiceAttach.setSize((long) content.length);
				faceVoiceAttach.setType("image/jpeg");
				faceVoiceAttach.setContent(content);
				return insertVoiceAttach(faceVoiceAttach);
			}
			// 从远程地址获取不到图片 改用定时任务来获取
			FaceVoiceAttachLink attachLink = new FaceVoiceAttachLink();
			attachLink.setLink(pictureLink);
			attachLink.setBelongId(belongId);
			attachLink.setBelongType(belongType);
			attachLink.setUserId(userId);
			attachLink.setType(FaceConstants.LINK_PICTURE);
			faceVoiceAttachLinkService.insertVoiceAttachLink(attachLink);
		}
		return FaceConstants.ID_UNKOWN;
	}

	private String getPhotoNameLimited(String pictureName) {
		return CommonUtil.getPhotoNameLimited(pictureName);
	}

	@Override
	public FaceVoiceAttach getOriginalAttachByAttachId(Integer attachId) {
		return faceVoiceAttachDao.getOrignalAttachByAttachId(attachId);
	}

	@Override
	public FaceVoiceAttach getBigAttachByAttachId(Integer attachId) {
		return faceVoiceAttachDao.getBigAttachByAttachId(attachId);
	}

	@Override
	public void updateAttachContentByAttachId(FaceVoiceAttach faceVoiceAttach) {
		faceVoiceAttachDao.updateAttachContentByAttachId(faceVoiceAttach);
	}

	@Override
	public void compressPicture() {
		// 压缩本地图片
		List<FaceVoiceAttach> faceVoiceAttachNeedCompress = getAttachNeedCompress();
		for (FaceVoiceAttach faceVoiceAttach : faceVoiceAttachNeedCompress) {
			FaceVoiceAttach faceVoiceOriginalAttach = getOriginalAttachByAttachId(faceVoiceAttach.getAttachmentId());
			if (faceVoiceAttach != null && ArrayUtils.isNotEmpty(faceVoiceOriginalAttach.getContent())) {
				byte[] bigContent = pictureCompressService.compressPic(faceVoiceOriginalAttach.getContent(), 1000, 1000, true);
				byte[] smallContent = pictureCompressService.compressPic(faceVoiceOriginalAttach.getContent(), 200, 200, true);
				faceVoiceOriginalAttach.setSmallContent(smallContent);
				faceVoiceOriginalAttach.setBigContent(bigContent);
				updateAttachContentByAttachId(faceVoiceOriginalAttach);
			}
		}
	}

}
