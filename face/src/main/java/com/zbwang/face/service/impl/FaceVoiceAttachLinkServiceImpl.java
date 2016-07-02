package com.zbwang.face.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.constant.FaceConstants;
import com.zbwang.face.dao.FaceVoiceAttachLinkDao;
import com.zbwang.face.domain.FaceVoiceAttach;
import com.zbwang.face.domain.FaceVoiceAttachLink;
import com.zbwang.face.service.FaceVoiceAttachLinkService;
import com.zbwang.face.service.FaceVoiceAttachService;
import com.zbwang.face.util.CommonUtil;

@Service
public class FaceVoiceAttachLinkServiceImpl implements FaceVoiceAttachLinkService {
	@Autowired
	private FaceVoiceAttachLinkDao faceVoiceAttachLinkDao;
	@Autowired
	private PictureDownloadService pictureDownloadService;
	@Autowired
	private FaceVoiceAttachService faceVoiceAttachService;

	@Override
	public Map<String, List<FaceVoiceAttachLink>> getAttachLinkByVoiceIdGroup(List<Integer> voiceIds) {
		List<FaceVoiceAttachLink> faceVoiceAttachLinkGroup = faceVoiceAttachLinkDao.getAttachLinkByVoiceIdGroup(voiceIds);
		Map<String, List<FaceVoiceAttachLink>> result = new HashMap<String, List<FaceVoiceAttachLink>>();
		for (FaceVoiceAttachLink FaceVoiceAttachLink : faceVoiceAttachLinkGroup) {
			String voiceId = String.valueOf(FaceVoiceAttachLink.getBelongId());
			if (!result.containsKey(voiceId)) {
				result.put(voiceId, new ArrayList<FaceVoiceAttachLink>());
			}
			result.get(voiceId).add(FaceVoiceAttachLink);
		}
		return result;
	}

	@Override
	public void insertMusicFromRemote(Integer userId, Map<String, Object> elements, int voiceId) {
		String musicLink = (String) elements.get("musicLink");
		String belongType = (String) elements.get("belongType");
		if (StringUtils.isNotBlank(musicLink)) {
			String musicId = StringUtils.EMPTY;
			String type = FaceConstants.MUSIC_UNKNOWN;
			if (CommonUtil.is163Music(musicLink)) {
				musicId = CommonUtil.get163MusicId(musicLink);
				type = FaceConstants.MUSIC_163;
			} else if (CommonUtil.isXiamiMusic(musicLink)) {
				musicId = CommonUtil.getXiamiMusicId(musicLink);
				type = FaceConstants.MUSIC_XIAMI;
			}
			FaceVoiceAttachLink attachLink = new FaceVoiceAttachLink();
			attachLink.setLink(musicLink);
			attachLink.setBelongId(voiceId);
			attachLink.setBelongType(belongType);
			attachLink.setUserId(userId);
			attachLink.setType(FaceConstants.LINK_MUSIC);
			attachLink.setMusicType(type);
			if (StringUtils.isNotEmpty(musicId)) {
				attachLink.setMusicId(musicId);
			}
			insertVoiceAttachLink(attachLink);
		}
	}

	@Override
	public int insertVoiceAttachLink(FaceVoiceAttachLink faceVoiceAttachLink) {
		return faceVoiceAttachLinkDao.insertVoiceAttachLink(faceVoiceAttachLink);
	}

	@Override
	public List<FaceVoiceAttachLink> getAttachLinkNeedCompress() {
		return faceVoiceAttachLinkDao.getAttachLinkNeedCompress();
	}

	@Override
	public void deleteAttachPictureLink(Integer attachId) {
		faceVoiceAttachLinkDao.deleteAttachPictureLink(attachId);
	}

	@Override
	public void compressPictureLink() {
		List<FaceVoiceAttachLink> AttachLinkNeedCompress = getAttachLinkNeedCompress();
		for (FaceVoiceAttachLink faceVoiceAttachLink : AttachLinkNeedCompress) {
			byte[] content = pictureDownloadService.getPictureFromRemoteUrl(faceVoiceAttachLink.getLink());
			if (ArrayUtils.isNotEmpty(content)) {
				FaceVoiceAttach faceVoiceAttach = new FaceVoiceAttach();
				faceVoiceAttach.setBelongId(faceVoiceAttachLink.getBelongId());
				faceVoiceAttach.setBelongType(faceVoiceAttachLink.getBelongType());
				faceVoiceAttach.setUserId(faceVoiceAttachLink.getUserId());
				String link = faceVoiceAttachLink.getLink();
				faceVoiceAttach.setAttachmentName(CommonUtil.getPhotoNameLimited(link.substring(link.lastIndexOf("/") + 1)));
				faceVoiceAttach.setSize((long) content.length);
				faceVoiceAttach.setType("image/jpeg");
				faceVoiceAttach.setContent(content);
				faceVoiceAttachService.insertVoiceAttach(faceVoiceAttach);
			}
			deleteAttachPictureLink(faceVoiceAttachLink.getAttachmentLinkId());
		}
	}

}
