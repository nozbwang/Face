package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.FaceVoice;

public interface FaceVoiceService {

	List<FaceVoice> getLatestVoice(int startRow, int endRow);

	List<FaceVoice> getLatestVoice(int startRow, int endRow, String belongType);

	List<FaceVoice> getLatestVoice(int startRow, int endRow, String belongType, Integer belongId);

	int insertVoice(Integer userId, Map<String, Object> elements);

	FaceVoice getVoiceById(int voiceId);

	void deleteVoice(Integer voiceId, Integer userId);

	void updateVoice(Integer userId, Map<String, Object> elements);

	List<FaceVoice> getVisibleSecret(int startRow, int endRow, Integer userId);

}
