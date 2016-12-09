package com.zbwang.face.dao;

import com.zbwang.face.domain.User;

public interface IUserDao {

	Integer insertUser(User user);

	User getUser(String userName);

	User getUser(Integer userId);

}
