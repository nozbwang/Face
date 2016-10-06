package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.FaceFoot;

public interface FaceFootService {

	int insertFoot(Integer userId, Map<String, Object> elements);

	List<FaceFoot> getLatestFoot(int startRow, int endRow);

	FaceFoot getFootById(Integer footId);

}
