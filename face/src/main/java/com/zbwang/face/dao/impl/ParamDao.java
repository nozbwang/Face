package com.zbwang.face.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.IParamDao;
import com.zbwang.face.domain.Parameter;

@Repository
public class ParamDao extends BaseDao implements IParamDao {

	@Override
	public void insert(Parameter record) {
		getSqlMapClientTemplate().insert("face_base_parameter.insertBaseParameter", record);
	}

	@Override
	public List<Parameter> getAllBaseParameter() {
		return getSqlMapClientTemplate().queryForList("face_base_parameter.getAllBaseParameter");
	}

}