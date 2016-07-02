package com.zbwang.face.dao.impl;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.LoginDao;
import com.zbwang.face.domain.FaceUser;

@Repository
public class LoginDaoImpl extends BaseDaoImpl implements LoginDao {

	@Override
	public Integer insertUser(FaceUser user) {
		return (Integer) getSqlMapClientTemplate().insert("face_user.insertUser", user);
	}

	@Override
	public FaceUser getUser(String userName) {
		return (FaceUser) getSqlMapClientTemplate().queryForObject("face_user.getUserByUserName", userName);
	}

	@Override
	public FaceUser getUser(Integer userId) {
		return (FaceUser) getSqlMapClientTemplate().queryForObject("face_user.getUserByUserId", userId);
	}

}
