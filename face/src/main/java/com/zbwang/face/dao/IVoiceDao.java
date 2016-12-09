package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.Voice;

public interface IVoiceDao {

	int insertVoice(Voice faceVoice);

	List<Voice> getLatestVoice(int startRow, int endRow, String belongType, Integer belongId);

	void deleteVoice(Integer voiceId, Integer userId);

	void updateVoice(Voice faceVoice);

	Voice getVoiceById(int voiceId);

	List<Voice> getVisibleSecret(int startRow, int endRow, Integer userId);

}