package com.zbwang.face.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.dao.IVoiceDao;
import com.zbwang.face.domain.Voice;
import com.zbwang.face.service.IVoiceService;

@Service
public class VoiceService implements IVoiceService {
	@Autowired
	private IVoiceDao faceVociceDao;

	@Override
	public List<Voice> getLatestVoice(int startRow, int endRow, String belongType, Integer belongId) {
		return faceVociceDao.getLatestVoice(startRow, endRow, belongType, belongId);
	}

	@Override
	public List<Voice> getLatestVoice(int startRow, int endRow, String belongType) {
		return getLatestVoice(startRow, endRow, belongType, null);
	}

	@Override
	public List<Voice> getLatestVoice(int startRow, int endRow) {
		return getLatestVoice(startRow, endRow, null, null);
	}

	@Override
	public List<Voice> getVisibleSecret(int startRow, int endRow, Integer userId) {
		return faceVociceDao.getVisibleSecret(startRow, endRow, userId);
	}

	@Override
	public void updateVoice(Integer userId, Map<String, Object> elements) {
		Voice faceVoice = new Voice();
		faceVoice.setVoice((String) elements.get("voice"));
		faceVoice.setVoiceId(NumberUtils.toInt((String) elements.get("voiceId")));
		faceVoice.setUserId(userId);
		faceVociceDao.updateVoice(faceVoice);
	}

	@Override
	public void deleteVoice(Integer voiceId, Integer userId) {
		faceVociceDao.deleteVoice(voiceId, userId);
	}

	@Override
	public Voice getVoiceById(int voiceId) {
		return faceVociceDao.getVoiceById(voiceId);
	}

	@Override
	public int insertVoice(Integer userId, Map<String, Object> elements) {
		Voice faceVoice = new Voice();
		faceVoice.setVoice((String) elements.get("voice"));
		faceVoice.setUserId(userId);
		faceVoice.setBelongId(NumberUtils.toInt((String) elements.get("belongId")));
		faceVoice.setBelongType((String) elements.get("belongType"));
		faceVoice.clearExtraLine();
		return faceVociceDao.insertVoice(faceVoice);
	}

}
