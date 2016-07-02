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
	public List<FaceVoice> getLatestVoice(int startRow, int endRow, String belongType) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		paramMap.put("belongType", belongType);
		return (List<FaceVoice>) getSqlMapClientTemplate().queryForList("face_voice.getAllVoice", paramMap);
	}

}
