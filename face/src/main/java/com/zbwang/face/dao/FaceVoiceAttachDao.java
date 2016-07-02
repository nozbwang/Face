package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.FaceVoiceAttach;

public interface FaceVoiceAttachDao {

	int insertVoiceAttach(FaceVoiceAttach faceVoiceAttach);

	List<FaceVoiceAttach> getAttachByVoiceIdGroup(List<Integer> voiceIds);

	void updateAttachContentByAttachId(FaceVoiceAttach faceVoiceAttach);

	List<FaceVoiceAttach> getAttachNeedCompress(Long compressPictureMaxSize);

	FaceVoiceAttach getAttachByAttachId(Integer attachId);

	FaceVoiceAttach getBigAttachByAttachId(Integer attachId);

	FaceVoiceAttach getOrignalAttachByAttachId(Integer attachId);

}
