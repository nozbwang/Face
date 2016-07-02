package com.zbwang.face.dao;

import com.zbwang.face.domain.FaceUser;

public interface LoginDao {

	Integer insertUser(FaceUser user);

	FaceUser getUser(String userName);

	FaceUser getUser(Integer userId);

}
