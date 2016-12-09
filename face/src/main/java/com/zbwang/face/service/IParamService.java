package com.zbwang.face.service;

import java.util.List;

import com.zbwang.face.domain.Parameter;

public interface IParamService {

	void insert(Parameter record);

	List<Parameter> getAllBaseParameter();
}
