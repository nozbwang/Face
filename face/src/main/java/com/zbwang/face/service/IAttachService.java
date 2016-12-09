package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.Voice;
import com.zbwang.face.domain.Attach;

public interface IAttachService {

	int insertVoiceAttach(Attach faceVoiceAttach);

	Map<String, List<Attach>> getAttachByVoiceIdGroup(List<Integer> voiceIds);

	Attach getAttachByAttachId(Integer attachId);

	Attach getOriginalAttachByAttachId(Integer attachId);

	Attach getBigAttachByAttachId(Integer attachId);

	void updateAttachContentByAttachId(Attach faceVoiceAttach);

	List<Attach> getAttachNeedCompress();

	void compressPicture();

	int insertPictureFromRemote(Integer userId, Map<String, Object> elements, int belongId);

	List<Integer> insertLocalPicture(Integer userId, Map<String, Object> elements, int belongId);

	Map<String, List<Attach>> getAttachByVoiceIdGroup(List<Integer> voiceIds, String belongType);

	void prepareVoiceAttach(List<Voice> latestVoiceGroup);

}