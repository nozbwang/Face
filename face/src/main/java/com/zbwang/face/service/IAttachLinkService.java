package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.AttachLink;

public interface IAttachLinkService {

	Map<String, List<AttachLink>> getAttachLinkByVoiceIdGroup(List<Integer> voiceIds);

	int insertVoiceAttachLink(AttachLink faceVoiceAttachLink);

	void deleteAttachPictureLink(Integer attachId);

	List<AttachLink> getAttachLinkNeedCompress();

	void compressPictureLink();

	void insertMusicFromRemote(Integer userId, Map<String, Object> elements, int voiceId);

}