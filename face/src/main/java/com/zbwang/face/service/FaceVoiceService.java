package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.FaceVoice;

public interface FaceVoiceService {

	List<FaceVoice> getLatestVoice(int startRow, int endRow);

	List<FaceVoice> getLatestVoice(int startRow, int endRow, String belongType);

	int insertVoice(Integer userId, Map<String, Object> elements);

}
