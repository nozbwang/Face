package com.zbwang.face.command;

import com.zbwang.face.domain.FaceUser;

public class BaseCommand {

	private FaceUser user;

	public FaceUser getUser() {
		return user;
	}

	public void setUser(FaceUser user) {
		this.user = user;
	}
}
