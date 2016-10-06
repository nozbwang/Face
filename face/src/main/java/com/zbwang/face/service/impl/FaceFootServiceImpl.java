package com.zbwang.face.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.dao.FaceFootDao;
import com.zbwang.face.domain.FaceFoot;
import com.zbwang.face.service.FaceFootService;

@Service
public class FaceFootServiceImpl implements FaceFootService {

	@Autowired
	private FaceFootDao faceFootDao;

	@Override
	public int insertFoot(Integer userId, Map<String, Object> elements) {
		FaceFoot faceFoot = new FaceFoot();
		faceFoot.setFootTitle((String) elements.get("footTitle"));
		faceFoot.setFooter((String) elements.get("footer"));
		faceFoot.setAddTime((String) elements.get("addTime"));
		faceFoot.setFootDetail((String) elements.get("footDetail"));
		faceFoot.setUserId(userId);
		return faceFootDao.insertFoot(faceFoot);
	}

	@Override
	public List<FaceFoot> getLatestFoot(int startRow, int endRow) {
		return faceFootDao.getLatestFoot(startRow, endRow);
	}

	@Override
	public FaceFoot getFootById(Integer footId) {
		return faceFootDao.getFootById(footId);
	}
}
