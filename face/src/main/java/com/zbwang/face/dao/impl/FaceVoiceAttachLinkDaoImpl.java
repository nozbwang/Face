package com.zbwang.face.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.zbwang.face.dao.FaceVoiceAttachLinkDao;
import com.zbwang.face.domain.FaceVoiceAttachLink;

@Repository
public class FaceVoiceAttachLinkDaoImpl extends BaseDaoImpl implements FaceVoiceAttachLinkDao {

	@Override
	public int insertVoiceAttachLink(FaceVoiceAttachLink faceVoiceAttachLink) {
		return (Integer) getSqlMapClientTemplate().insert("face_voice_attachment_link.insertFaceVoiceAttachLink",
				faceVoiceAttachLink);
	}

	@Override
	public List<FaceVoiceAttachLink> getAttachLinkNeedCompress() {
		return getSqlMapClientTemplate().queryForList("face_voice_attachment_link.getAttachLinkNeedCompress");
	}

	@Override
	public List<FaceVoiceAttachLink> getAttachLinkByVoiceIdGroup(List<Integer> voiceIds) {
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
