package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.Foot;

public interface IFootService {

	int insertFoot(Integer userId, Map<String, Object> elements);

	List<Foot> getLatestFoot(int startRow, int endRow);

	Foot getFootById(Integer footId);

}
