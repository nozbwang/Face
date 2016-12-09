package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.Parameter;

public interface IParamDao {
	void insert(Parameter record);

	List<Parameter> getAllBaseParameter();
}