package com.zbwang.face.domain;

import java.util.Date;

import com.zbwang.face.constant.Constants;

public class Robot {
	private Long robotId;
	private String uuid;
	private Short robotType;
	private Short status;
	private String adder;
	private Long adderId;
	private Date addTime;
	private String updater;
	private Long updaterId;
	private Date updateTime;

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

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getAdder() {
		return adder;
	}

	public void setAdder(String adder) {
		this.adder = adder;
	}

	public Long getAdderId() {
		return adderId;
	}

	public void setAdderId(Long adderId) {
		this.adderId = adderId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Long getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(Long updaterId) {
		this.updaterId = updaterId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Short getRobotType() {
		return robotType;
	}

	public void setRobotType(Short robotType) {
		this.robotType = robotType;
	}

	public boolean isSensor() {
		return Constants.TYPE_TEMPERATURE_SENSOR.equals(robotType);
	}

	public boolean isMotionEquip() {
		return Constants.TYPE_MOTION_EQUIPMENT.equals(robotType);
	}
}