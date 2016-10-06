package com.zbwang.face.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.FaceFootDao;
import com.zbwang.face.domain.FaceFoot;

@Repository
public class FaceFootDaoImpl extends BaseDaoImpl implements FaceFootDao {

	@Override
	public int insertFoot(FaceFoot faceFoot) {
		return (Integer) getSqlMapClientTemplate().insert("face_foot.insertFoot", faceFoot);
	}

	@Override
	public List<FaceFoot> getLatestFoot(int startRow, int endRow) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		return (List<FaceFoot>) getSqlMapClientTemplate().queryForList("face_foot.getFoot", paramMap);
	}

	@Override
	public FaceFoot getFootById(Integer footId) {
		return (FaceFoot) getSqlMapClientTemplate().queryForObject("face_foot.getFootById", footId);
	}

}
