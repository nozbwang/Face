package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.FaceFoot;

public interface FaceFootDao {

	int insertFoot(FaceFoot faceFoot);

	List<FaceFoot> getLatestFoot(int startRow, int endRow);

	FaceFoot getFootById(Integer footId);

}