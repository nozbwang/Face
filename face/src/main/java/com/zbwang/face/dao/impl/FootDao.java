package com.zbwang.face.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.IFootDao;
import com.zbwang.face.domain.Foot;

@Repository
public class FootDao extends BaseDao implements IFootDao {

	@Override
	public int insertFoot(Foot faceFoot) {
		return (Integer) getSqlMapClientTemplate().insert("face_foot.insertFoot", faceFoot);
	}

	@Override
	public List<Foot> getLatestFoot(int startRow, int endRow) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		return (List<Foot>) getSqlMapClientTemplate().queryForList("face_foot.getFoot", paramMap);
	}

	@Override
	public Foot getFootById(Integer footId) {
		return (Foot) getSqlMapClientTemplate().queryForObject("face_foot.getFootById", footId);
	}

}
