package com.zbwang.face.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.dao.IUserDao;
import com.zbwang.face.domain.User;
import com.zbwang.face.service.IUserService;
import com.zbwang.face.util.CommonUtil;

@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDao loginDao;

	@Override
	public Long insertUser(User user) {
		return loginDao.insertUser(user);
	}

	@Override
	public User getUser(String userName) {
		return loginDao.getUser(userName);
	}

	@Override
	public User getUser(Integer userId) {
		if (userId == null || userId == 0) {
			return CommonUtil.getVisitor();
		}
		return loginDao.getUser(userId);
	}
}
