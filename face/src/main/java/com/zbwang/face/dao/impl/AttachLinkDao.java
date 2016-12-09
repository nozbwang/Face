package com.zbwang.face.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.zbwang.face.dao.IAttachLinkDao;
import com.zbwang.face.domain.AttachLink;

@Repository
public class AttachLinkDao extends BaseDao implements IAttachLinkDao {

	@Override
	public int insertVoiceAttachLink(AttachLink faceVoiceAttachLink) {
		return (Integer) getSqlMapClientTemplate().insert("face_voice_attachment_link.insertFaceVoiceAttachLink",
				faceVoiceAttachLink);
	}

	@Override
	public List<AttachLink> getAttachLinkNeedCompress() {
		return getSqlMapClientTemplate().queryForList("face_voice_attachment_link.getAttachLinkNeedCompress");
	}

	@Override
	public List<AttachLink> getAttachLinkByVoiceIdGroup(List<Integer> voiceIds) {
		if (CollectionUtils.isEmpty(voiceIds)) {
			return Lists.newArrayList();
		}
		return getSqlMapClientTemplate().queryForList("face_voice_attachment_link.getAttachLinkByVoiceIdGroup", voiceIds);
	}

	@Override
	public void deleteAttachPictureLink(Integer attachId) {
		getSqlMapClientTemplate().delete("face_voice_attachment_link.deleteAttachLink", attachId);
	}

}
