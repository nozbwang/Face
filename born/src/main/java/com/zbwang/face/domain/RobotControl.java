package com.zbwang.face.domain;

import java.util.Date;

import com.zbwang.face.util.FormatUtil;

public class RobotControl {
	private Long recId;
	private Long userId;
	private Long robotId;
	private Short action;
	private Date addTime;

	public Long getRecId() {
		return recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRobotId() {
		return robotId;
	}

	public void setRobotId(Long robotId) {
		this.robotId = robotId;
	}

	public Short getAction() {
		return action;
	}

	public void setAction(Short action) {
		this.action = action;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getFormattedAddTime() {
		return FormatUtil.formatMinuteTime(addTime);
	}
}