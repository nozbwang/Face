package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.Voice;

public interface IVoiceService {

	List<Voice> getLatestVoice(int startRow, int endRow);

	List<Voice> getLatestVoice(int startRow, int endRow, String belongType);

	List<Voice> getLatestVoice(int startRow, int endRow, String belongType, Integer belongId);

	int insertVoice(Integer userId, Map<String, Object> elements);

	Voice getVoiceById(int voiceId);

	void deleteVoice(Integer voiceId, Integer userId);

	void updateVoice(Integer userId, Map<String, Object> elements);

	List<Voice> getVisibleSecret(int startRow, int endRow, Integer userId);

}
