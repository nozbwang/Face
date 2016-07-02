package com.zbwang.face.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.dao.LoginDao;
import com.zbwang.face.domain.FaceUser;
import com.zbwang.face.service.FaceUserService;
import com.zbwang.face.util.CommonUtil;
import com.zbwang.face.util.DesEncryptComponent;

@Service
public class FaceUserServiceImpl implements FaceUserService {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private DesEncryptComponent desEncryptComponent;

	@Override
	public Integer insertUser(FaceUser user) {
		return loginDao.insertUser(user);
	}

	@Override
	public FaceUser getUser(String userName) {
		return loginDao.getUser(userName);
	}

	@Override
	public FaceUser getUser(Integer userId) {
		if (userId == null || userId == 0) {
			return CommonUtil.getVisitor();
		}
		return loginDao.getUser(userId);
	}

}
