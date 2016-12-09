package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.Attach;

public interface IAttachDao {

	int insertVoiceAttach(Attach faceVoiceAttach);

	List<Attach> getAttachByVoiceIdGroup(List<Integer> voiceIds);

	void updateAttachContentByAttachId(Attach faceVoiceAttach);

	List<Attach> getAttachNeedCompress(Long compressPictureMaxSize);

	Attach getAttachByAttachId(Integer attachId);

	Attach getBigAttachByAttachId(Integer attachId);

	Attach getOrignalAttachByAttachId(Integer attachId);

	List<Attach> getAttachByBelongType(List<Integer> voiceIds, String belongType);

}
