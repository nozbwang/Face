package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.FaceVoice;

public interface FaceVoiceDao {

	int insertVoice(FaceVoice faceVoice);

	List<FaceVoice> getLatestVoice(int startRow, int endRow, String belongType);

}