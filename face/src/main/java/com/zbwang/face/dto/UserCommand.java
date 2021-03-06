package com.zbwang.face.dto;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.zbwang.face.constant.Constants;

public class UserCommand extends BaseCommand {
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private String confirmPassword;
	private Date addTime;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public boolean isRegisterComplete() {
		return StringUtils.isNotBlank(userName) && userName.matches(Constants.USERNAME_PATTERN)
				&& StringUtils.isNotBlank(password) && password.matches(Constants.USERNAME_PATTERN)
				&& StringUtils.isNotBlank(email) && email.matches(Constants.EMAIL_PATTERN)
				&& StringUtils.equals(password, confirmPassword);
	}

	public boolean isLoginComplete() {
		return StringUtils.isNotBlank(userName) && userName.matches(Constants.USERNAME_PATTERN)
				&& StringUtils.isNotBlank(password) && password.matches(Constants.USERNAME_PATTERN);
	}

	public void lowerUserName() {
		userName = userName.toLowerCase();
	}

}