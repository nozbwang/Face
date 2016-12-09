package com.zbwang.face.dto;

import com.zbwang.face.domain.User;

public class BaseCommand {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
