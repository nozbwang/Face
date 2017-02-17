package com.zbwang.face.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.IUserDao;
import com.zbwang.face.domain.User;

@Repository
public class UserDao extends BaseDao implements IUserDao {
	@Override
	public Long insertUser(User user) {
		return (Long) getSqlMapClientTemplate().insert("user.insertUser", user);
	}

	@Override
	public User getUser(String userName) {
		return (User) getSqlMapClientTemplate().queryForObject("user.getUserByUserName", StringUtils.lowerCase(userName));
	}

	@Override
	public User getUser(Integer userId) {
		return (User) getSqlMapClientTemplate().queryForObject("user.getUserByUserId", userId);
	}
}
