package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.AttachLink;

public interface IAttachLinkDao {

	List<AttachLink> getAttachLinkByVoiceIdGroup(List<Integer> voiceIds);

	int insertVoiceAttachLink(AttachLink faceVoiceAttachLink);

	void deleteAttachPictureLink(Integer attachId);

	List<AttachLink> getAttachLinkNeedCompress();

}
