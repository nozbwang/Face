package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.Foot;

public interface IFootDao {

	int insertFoot(Foot faceFoot);

	List<Foot> getLatestFoot(int startRow, int endRow);

	Foot getFootById(Integer footId);

}