package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.FaceVoiceAttachLink;

public interface FaceVoiceAttachLinkDao {

	List<FaceVoiceAttachLink> getAttachLinkByVoiceIdGroup(List<Integer> voiceIds);

	int insertVoiceAttachLink(FaceVoiceAttachLink faceVoiceAttachLink);

	void deleteAttachPictureLink(Integer attachId);

	List<FaceVoiceAttachLink> getAttachLinkNeedCompress();

}
