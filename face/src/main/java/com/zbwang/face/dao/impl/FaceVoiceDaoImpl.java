package com.zbwang.face.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.FaceVoiceDao;
import com.zbwang.face.domain.FaceVoice;

@Repository
public class FaceVoiceDaoImpl extends BaseDaoImpl implements FaceVoiceDao {

	@Override
	public int insertVoice(FaceVoice faceVoice) {
		return (Integer) getSqlMapClientTemplate().insert("face_voice.insertVoice", faceVoice);
	}

	@Override
	public void deleteVoice(Integer voiceId, Integer userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("voiceId", voiceId);
		paramMap.put("userId", userId);
		getSqlMapClientTemplate().update("face_voice.deleteVoice", paramMap);
	}

	@Override
	public void updateVoice(FaceVoice faceVoice) {
		getSqlMapClientTemplate().update("face_voice.updateVoice", faceVoice);
	}

	@Override
	public List<FaceVoice> getLatestVoice(int startRow, int endRow, String belongType, Integer belongId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		paramMap.put("belongType", belongType);
		paramMap.put("belongId", belongId);
		return (List<FaceVoice>) getSqlMapClientTemplate().queryForList("face_voice.getAllVoice", paramMap);
	}

	@Override
	public List<FaceVoice> getVisibleSecret(int startRow, int endRow, Integer userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		paramMap.put("userId", userId);
		return (List<FaceVoice>) getSqlMapClientTemplate().queryForList("face_voice.getAllSecret", paramMap);
	}

	@Override
	public FaceVoice getVoiceById(int voiceId) {
		return (FaceVoice) getSqlMapClientTemplate().queryForObject("face_voice.getVoiceById", voiceId);
	}

}
