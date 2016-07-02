package com.zbwang.face.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.zbwang.face.dao.FaceVoiceAttachDao;
import com.zbwang.face.domain.FaceVoiceAttach;

@Repository
public class FaceVoiceAttachDaoImpl extends BaseDaoImpl implements FaceVoiceAttachDao {

	@Override
	public int insertVoiceAttach(FaceVoiceAttach faceVoiceAttach) {
		return (Integer) getSqlMapClientTemplate().insert("face_voice_attachment.insertVoiceAttachment", faceVoiceAttach);
	}

	@Override
	public List<FaceVoiceAttach> getAttachNeedCompress(Long compressPictureMaxSize) {
		return getSqlMapClientTemplate().queryForList("face_voice_attachment.getAttachNeedCompress", compressPictureMaxSize);
	}

	@Override
	public List<FaceVoiceAttach> getAttachByVoiceIdGroup(List<Integer> voiceIds) {
		if (CollectionUtils.isEmpty(voiceIds)) {
			return Lists.newArrayList();
		}
		return getSqlMapClientTemplate().queryForList("face_voice_attachment.getAttachByVoiceIdGroup", voiceIds);
	}

	@Override
	public FaceVoiceAttach getAttachByAttachId(Integer attachId) {
		return (FaceVoiceAttach) getSqlMapClientTemplate().queryForObject("face_voice_attachment.getSmallAttachByAttachId",
				attachId);
	}

	@Override
	public FaceVoiceAttach getBigAttachByAttachId(Integer attachId) {
		return (FaceVoiceAttach) getSqlMapClientTemplate().queryForObject("face_voice_attachment.getBigAttachByAttachId",
				attachId);
	}

	@Override
	public FaceVoiceAttach getOrignalAttachByAttachId(Integer attachId) {
		return (FaceVoiceAttach) getSqlMapClientTemplate().queryForObject("face_voice_attachment.getOriginalAttachByAttachId",
				attachId);
	}

	@Override
	public void updateAttachContentByAttachId(FaceVoiceAttach faceVoiceAttach) {
		getSqlMapClientTemplate().update("face_voice_attachment.updateAttachContentByAttachId", faceVoiceAttach);
	}

}
