package com.zbwang.face.service;

import com.zbwang.face.domain.FaceUser;

public interface FaceUserService {

	Integer insertUser(FaceUser user);

	FaceUser getUser(String userName);

	FaceUser getUser(Integer userId);

}
