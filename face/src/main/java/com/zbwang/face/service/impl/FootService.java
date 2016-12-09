package com.zbwang.face.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.dao.IFootDao;
import com.zbwang.face.domain.Foot;
import com.zbwang.face.service.IFootService;

@Service
public class FootService implements IFootService {

	@Autowired
	private IFootDao faceFootDao;

	@Override
	public int insertFoot(Integer userId, Map<String, Object> elements) {
		Foot faceFoot = new Foot();
		faceFoot.setFootTitle((String) elements.get("footTitle"));
		faceFoot.setFooter((String) elements.get("footer"));
		faceFoot.setAddTime((String) elements.get("addTime"));
		faceFoot.setFootDetail((String) elements.get("footDetail"));
		faceFoot.setUserId(userId);
		return faceFootDao.insertFoot(faceFoot);
	}

	@Override
	public List<Foot> getLatestFoot(int startRow, int endRow) {
		return faceFootDao.getLatestFoot(startRow, endRow);
	}

	@Override
	public Foot getFootById(Integer footId) {
		return faceFootDao.getFootById(footId);
	}
}
