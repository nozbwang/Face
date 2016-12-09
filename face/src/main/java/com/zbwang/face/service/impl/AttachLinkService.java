package com.zbwang.face.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.constant.Constants;
import com.zbwang.face.dao.IAttachLinkDao;
import com.zbwang.face.domain.Attach;
import com.zbwang.face.domain.AttachLink;
import com.zbwang.face.service.IAttachLinkService;
import com.zbwang.face.service.IAttachService;
import com.zbwang.face.util.CommonUtil;

@Service
public class AttachLinkService implements IAttachLinkService {
	@Autowired
	private IAttachLinkDao faceVoiceAttachLinkDao;
	@Autowired
	private DownloadService pictureDownloadService;
	@Autowired
	private IAttachService faceVoiceAttachService;

	@Override
	public Map<String, List<AttachLink>> getAttachLinkByVoiceIdGroup(List<Integer> voiceIds) {
		List<AttachLink> faceVoiceAttachLinkGroup = faceVoiceAttachLinkDao.getAttachLinkByVoiceIdGroup(voiceIds);
		Map<String, List<AttachLink>> result = new HashMap<String, List<AttachLink>>();
		for (AttachLink FaceVoiceAttachLink : faceVoiceAttachLinkGroup) {
			String voiceId = String.valueOf(FaceVoiceAttachLink.getBelongId());
			if (!result.containsKey(voiceId)) {
				result.put(voiceId, new ArrayList<AttachLink>());
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
			String type = Constants.MUSIC_UNKNOWN;
			if (CommonUtil.is163Music(musicLink)) {
				musicId = CommonUtil.get163MusicId(musicLink);
				type = Constants.MUSIC_163;
			} else if (CommonUtil.isXiamiMusic(musicLink)) {
				musicId = CommonUtil.getXiamiMusicId(musicLink);
				type = Constants.MUSIC_XIAMI;
			}
			AttachLink attachLink = new AttachLink();
			attachLink.setLink(musicLink);
			attachLink.setBelongId(voiceId);
			attachLink.setBelongType(belongType);
			attachLink.setUserId(userId);
			attachLink.setType(Constants.LINK_MUSIC);
			attachLink.setMusicType(type);
			if (StringUtils.isNotEmpty(musicId)) {
				attachLink.setMusicId(musicId);
			}
			insertVoiceAttachLink(attachLink);
		}
	}

	@Override
	public int insertVoiceAttachLink(AttachLink faceVoiceAttachLink) {
		return faceVoiceAttachLinkDao.insertVoiceAttachLink(faceVoiceAttachLink);
	}

	@Override
	public List<AttachLink> getAttachLinkNeedCompress() {
		return faceVoiceAttachLinkDao.getAttachLinkNeedCompress();
	}

	@Override
	public void deleteAttachPictureLink(Integer attachId) {
		faceVoiceAttachLinkDao.deleteAttachPictureLink(attachId);
	}

	@Override
	public void compressPictureLink() {
		List<AttachLink> AttachLinkNeedCompress = getAttachLinkNeedCompress();
		for (AttachLink faceVoiceAttachLink : AttachLinkNeedCompress) {
			byte[] content = pictureDownloadService.getPictureFromRemoteUrl(faceVoiceAttachLink.getLink());
			if (ArrayUtils.isNotEmpty(content)) {
				Attach faceVoiceAttach = new Attach();
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
