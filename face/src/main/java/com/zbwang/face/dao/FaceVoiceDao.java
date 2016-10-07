package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.FaceVoice;

public interface FaceVoiceDao {

	int insertVoice(FaceVoice faceVoice);

	List<FaceVoice> getLatestVoice(int startRow, int endRow, String belongType, Integer belongId);

	void deleteVoice(Integer voiceId, Integer userId);

	void updateVoice(FaceVoice faceVoice);

	FaceVoice getVoiceById(int voiceId);

	List<FaceVoice> getVisibleSecret(int startRow, int endRow, Integer userId);

}