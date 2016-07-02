package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.FaceVoiceAttachLink;

public interface FaceVoiceAttachLinkService {

	Map<String, List<FaceVoiceAttachLink>> getAttachLinkByVoiceIdGroup(List<Integer> voiceIds);

	int insertVoiceAttachLink(FaceVoiceAttachLink faceVoiceAttachLink);

	void deleteAttachPictureLink(Integer attachId);

	List<FaceVoiceAttachLink> getAttachLinkNeedCompress();

	void compressPictureLink();

	void insertMusicFromRemote(Integer userId, Map<String, Object> elements, int voiceId);

}