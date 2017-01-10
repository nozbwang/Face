package com.zbwang.face.service;

import com.zbwang.face.domain.User;

public interface IUserService {

	Integer insertUser(User user);

	User getUser(String userName);

	User getUser(Integer userId);

}
