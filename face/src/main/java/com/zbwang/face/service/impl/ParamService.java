package com.zbwang.face.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.dao.IParamDao;
import com.zbwang.face.domain.Parameter;
import com.zbwang.face.service.IParamService;

@Service
public class ParamService implements IParamService {

	@Autowired
	private IParamDao faceBaseParameterDAO;

	@Override
	public void insert(Parameter record) {
		faceBaseParameterDAO.insert(record);
	}

	@Override
	public List<Parameter> getAllBaseParameter() {
		return faceBaseParameterDAO.getAllBaseParameter();
	}

}
