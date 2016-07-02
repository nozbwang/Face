package com.zbwang.face.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.dao.FaceVoiceDao;
import com.zbwang.face.domain.FaceVoice;
import com.zbwang.face.service.FaceVoiceService;

@Service
public class FaceVoiceServiceImpl implements FaceVoiceService {
	@Autowired
	private FaceVoiceDao faceVociceDao;

	@Override
	public List<FaceVoice> getLatestVoice(int startRow, int endRow, String belongType) {
		return faceVociceDao.getLatestVoice(startRow, endRow, belongType);
	}

	@Override
	public List<FaceVoice> getLatestVoice(int startRow, int endRow) {
		return faceVociceDao.getLatestVoice(startRow, endRow, null);
	}

	@Override
	public int insertVoice(Integer userId, Map<String, Object> elements) {
		FaceVoice faceVoice = new FaceVoice();
		faceVoice.setVoice((String) elements.get("voice"));
		faceVoice.setVoiceType((String) elements.get("voiceType"));
		faceVoice.setUserId(userId);
		faceVoice.setBelongId(NumberUtils.toInt((String) elements.get("belongId")));
		faceVoice.setBelongType((String) elements.get("belongType"));
		faceVoice.clearExtraLine();
		return faceVociceDao.insertVoice(faceVoice);
	}

}
