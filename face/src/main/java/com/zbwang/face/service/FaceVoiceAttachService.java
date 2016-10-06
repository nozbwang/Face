package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.FaceVoiceAttach;

public interface FaceVoiceAttachService {

	int insertVoiceAttach(FaceVoiceAttach faceVoiceAttach);

	Map<String, List<FaceVoiceAttach>> getAttachByVoiceIdGroup(List<Integer> voiceIds);

	FaceVoiceAttach getAttachByAttachId(Integer attachId);

	FaceVoiceAttach getOriginalAttachByAttachId(Integer attachId);

	FaceVoiceAttach getBigAttachByAttachId(Integer attachId);

	void updateAttachContentByAttachId(FaceVoiceAttach faceVoiceAttach);

	List<FaceVoiceAttach> getAttachNeedCompress();

	void compressPicture();

	int insertPictureFromRemote(Integer userId, Map<String, Object> elements, int belongId);

	List<Integer> insertLocalPicture(Integer userId, Map<String, Object> elements, int belongId);

	Map<String, List<FaceVoiceAttach>> getAttachByVoiceIdGroup(List<Integer> voiceIds, String belongType);

}