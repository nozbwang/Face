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

import com.zbwang.face.constant.Constants;
import com.zbwang.face.dao.IAttachDao;
import com.zbwang.face.domain.Voice;
import com.zbwang.face.domain.Attach;
import com.zbwang.face.domain.AttachLink;
import com.zbwang.face.service.IAttachLinkService;
import com.zbwang.face.service.IAttachService;
import com.zbwang.face.util.CommonUtil;

@Service
public class AttachService implements IAttachService {
	@Autowired
	private IAttachDao faceVoiceAttachDao;
	@Autowired
	private IAttachLinkService faceVoiceAttachLinkService;
	@Autowired
	private CompressService pictureCompressService;
	@Autowired
	private DownloadService pictureDownloadService;
	@Value("#{propertyConfigurer['compress.picture.maxsize']}")
	private Long compressPictureMaxSize;

	@Override
	public int insertVoiceAttach(Attach faceVoiceAttach) {
		return faceVoiceAttachDao.insertVoiceAttach(faceVoiceAttach);
	}

	@Override
	public List<Attach> getAttachNeedCompress() {
		return faceVoiceAttachDao.getAttachNeedCompress(compressPictureMaxSize);
	}

	@Override
	public Map<String, List<Attach>> getAttachByVoiceIdGroup(List<Integer> voiceIds) {
		List<Attach> faceVoiceAttachGroup = faceVoiceAttachDao.getAttachByVoiceIdGroup(voiceIds);
		Map<String, List<Attach>> result = new HashMap<String, List<Attach>>();
		for (Attach faceVoiceAttach : faceVoiceAttachGroup) {
			String voiceId = String.valueOf(faceVoiceAttach.getBelongId());
			if (!result.containsKey(voiceId)) {
				result.put(voiceId, new ArrayList<Attach>());
			}
			result.get(voiceId).add(faceVoiceAttach);
		}
		return result;
	}

	@Override
	public Map<String, List<Attach>> getAttachByVoiceIdGroup(List<Integer> voiceIds, String belongType) {
		List<Attach> faceVoiceAttachGroup = faceVoiceAttachDao.getAttachByBelongType(voiceIds, belongType);
		Map<String, List<Attach>> result = new HashMap<String, List<Attach>>();
		for (Attach faceVoiceAttach : faceVoiceAttachGroup) {
			String voiceId = String.valueOf(faceVoiceAttach.getBelongId());
			if (!result.containsKey(voiceId)) {
				result.put(voiceId, new ArrayList<Attach>());
			}
			result.get(voiceId).add(faceVoiceAttach);
		}
		return result;
	}

	@Override
	public Attach getAttachByAttachId(Integer attachId) {
		return faceVoiceAttachDao.getAttachByAttachId(attachId);
	}

	@Override
	public List<Integer> insertLocalPicture(Integer userId, Map<String, Object> elements, int belongId) {
		List<FileItem> localPictures = (List<FileItem>) elements.get("file");
		String belongType = (String) elements.get("belongType");
		List<Integer> localPictureIds = new ArrayList<Integer>();
		if (CollectionUtils.isNotEmpty(localPictures)) {
			for (FileItem localPicture : localPictures) {
				Attach faceVoiceAttach = new Attach();
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
			Attach faceVoiceAttach = new Attach();
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
			AttachLink attachLink = new AttachLink();
			attachLink.setLink(pictureLink);
			attachLink.setBelongId(belongId);
			attachLink.setBelongType(belongType);
			attachLink.setUserId(userId);
			attachLink.setType(Constants.LINK_PICTURE);
			faceVoiceAttachLinkService.insertVoiceAttachLink(attachLink);
		}
		return Constants.ID_UNKOWN;
	}

	private String getPhotoNameLimited(String pictureName) {
		return CommonUtil.getPhotoNameLimited(pictureName);
	}

	@Override
	public Attach getOriginalAttachByAttachId(Integer attachId) {
		return faceVoiceAttachDao.getOrignalAttachByAttachId(attachId);
	}

	@Override
	public Attach getBigAttachByAttachId(Integer attachId) {
		return faceVoiceAttachDao.getBigAttachByAttachId(attachId);
	}

	@Override
	public void updateAttachContentByAttachId(Attach faceVoiceAttach) {
		faceVoiceAttachDao.updateAttachContentByAttachId(faceVoiceAttach);
	}

	@Override
	public void compressPicture() {
		// 压缩本地图片
		List<Attach> faceVoiceAttachNeedCompress = getAttachNeedCompress();
		for (Attach faceVoiceAttach : faceVoiceAttachNeedCompress) {
			Attach faceVoiceOriginalAttach = getOriginalAttachByAttachId(faceVoiceAttach.getAttachmentId());
			if (faceVoiceAttach != null && ArrayUtils.isNotEmpty(faceVoiceOriginalAttach.getContent())) {
				byte[] bigContent = pictureCompressService.compressPic(faceVoiceOriginalAttach.getContent(), 1000, 1000, true);
				byte[] smallContent = pictureCompressService.compressPic(faceVoiceOriginalAttach.getContent(), 200, 200, true);
				faceVoiceOriginalAttach.setSmallContent(smallContent);
				faceVoiceOriginalAttach.setBigContent(bigContent);
				updateAttachContentByAttachId(faceVoiceOriginalAttach);
			}
		}
	}

	@Override
	public void prepareVoiceAttach(List<Voice> latestVoiceGroup) {
		List<Integer> voiceIdGroup = new ArrayList<Integer>();
		for (Voice faceVoice : latestVoiceGroup) {
			voiceIdGroup.add(faceVoice.getVoiceId());
		}
		Map<String, List<Attach>> faceVoiceAttachMap = getAttachByVoiceIdGroup(voiceIdGroup);
		Map<String, List<AttachLink>> faceVoiceAttachLinkMap = faceVoiceAttachLinkService
				.getAttachLinkByVoiceIdGroup(voiceIdGroup);
		for (Voice faceVoice : latestVoiceGroup) {
			faceVoice.setFaceVoiceAttachs(faceVoiceAttachMap.get(String.valueOf(faceVoice.getVoiceId())));
			faceVoice.setFaceVoiceAttachLinks(faceVoiceAttachLinkMap.get(String.valueOf(faceVoice.getVoiceId())));
		}
	}

}
