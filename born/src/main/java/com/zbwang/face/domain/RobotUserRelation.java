package com.zbwang.face.domain;

import java.util.Date;

import com.zbwang.face.util.FormatUtil;

public class RobotUserRelation {
	private Long recId;
	private Long robotId;
	private String uuid;
	private Long userId;
	private Short status;
	private Short workStatus;
	private Date addTime;

	public Long getRecId() {
		return recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public Long getRobotId() {
		return robotId;
	}

	public void setRobotId(Long robotId) {
		this.robotId = robotId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Date getAddTime() {
		return addTime;
	}

	public String getFormattedAddTime() {
		return FormatUtil.formatMinuteTime(addTime);
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Short getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(Short workStatus) {
		this.workStatus = workStatus;
	}
}