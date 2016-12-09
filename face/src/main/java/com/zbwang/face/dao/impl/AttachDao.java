package com.zbwang.face.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.zbwang.face.dao.IAttachDao;
import com.zbwang.face.domain.Attach;

@Repository
public class AttachDao extends BaseDao implements IAttachDao {

	@Override
	public int insertVoiceAttach(Attach faceVoiceAttach) {
		return (Integer) getSqlMapClientTemplate().insert("face_voice_attachment.insertVoiceAttachment", faceVoiceAttach);
	}

	@Override
	public List<Attach> getAttachNeedCompress(Long compressPictureMaxSize) {
		return getSqlMapClientTemplate().queryForList("face_voice_attachment.getAttachNeedCompress", compressPictureMaxSize);
	}

	@Override
	public List<Attach> getAttachByVoiceIdGroup(List<Integer> voiceIds) {
		return getAttachByBelongType(voiceIds, StringUtils.EMPTY);
	}

	@Override
	public List<Attach> getAttachByBelongType(List<Integer> voiceIds, String belongType) {
		if (CollectionUtils.isEmpty(voiceIds)) {
			return Lists.newArrayList();
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("voiceIds", voiceIds);
		paramMap.put("belongType", belongType);
		return getSqlMapClientTemplate().queryForList("face_voice_attachment.getAttachByVoiceIdGroup", paramMap);
	}

	@Override
	public Attach getAttachByAttachId(Integer attachId) {
		return (Attach) getSqlMapClientTemplate().queryForObject("face_voice_attachment.getSmallAttachByAttachId",
				attachId);
	}

	@Override
	public Attach getBigAttachByAttachId(Integer attachId) {
		return (Attach) getSqlMapClientTemplate().queryForObject("face_voice_attachment.getBigAttachByAttachId",
				attachId);
	}

	@Override
	public Attach getOrignalAttachByAttachId(Integer attachId) {
		return (Attach) getSqlMapClientTemplate().queryForObject("face_voice_attachment.getOriginalAttachByAttachId",
				attachId);
	}

	@Override
	public void updateAttachContentByAttachId(Attach faceVoiceAttach) {
		getSqlMapClientTemplate().update("face_voice_attachment.updateAttachContentByAttachId", faceVoiceAttach);
	}

}
