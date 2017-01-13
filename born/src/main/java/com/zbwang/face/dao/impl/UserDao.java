package com.zbwang.face.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.IUserDao;
import com.zbwang.face.domain.User;

@Repository
public class UserDao extends BaseDao implements IUserDao {
	@Override
	public Integer insertUser(User user) {
		return (Integer) getSqlMapClientTemplate().insert("face_user.insertUser", user);
	}

	@Override
	public User getUser(String userName) {
		return (User) getSqlMapClientTemplate().queryForObject("face_user.getUserByUserName", StringUtils.lowerCase(userName));
	}

	@Override
	public User getUser(Integer userId) {
		return (User) getSqlMapClientTemplate().queryForObject("face_user.getUserByUserId", userId);
	}
}
