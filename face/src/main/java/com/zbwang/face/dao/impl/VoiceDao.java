package com.zbwang.face.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.IVoiceDao;
import com.zbwang.face.domain.Voice;

@Repository
public class VoiceDao extends BaseDao implements IVoiceDao {

	@Override
	public int insertVoice(Voice faceVoice) {
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
	public void updateVoice(Voice faceVoice) {
		getSqlMapClientTemplate().update("face_voice.updateVoice", faceVoice);
	}

	@Override
	public List<Voice> getLatestVoice(int startRow, int endRow, String belongType, Integer belongId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		paramMap.put("belongType", belongType);
		paramMap.put("belongId", belongId);
		return (List<Voice>) getSqlMapClientTemplate().queryForList("face_voice.getAllVoice", paramMap);
	}

	@Override
	public List<Voice> getVisibleSecret(int startRow, int endRow, Integer userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		paramMap.put("userId", userId);
		return (List<Voice>) getSqlMapClientTemplate().queryForList("face_voice.getAllSecret", paramMap);
	}

	@Override
	public Voice getVoiceById(int voiceId) {
		return (Voice) getSqlMapClientTemplate().queryForObject("face_voice.getVoiceById", voiceId);
	}

}
