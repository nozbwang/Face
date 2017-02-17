package com.zbwang.face.dto;

import java.math.BigDecimal;

public class RobotOnlineDataCommand {
	private String uuid;
	private BigDecimal voltage;
	private BigDecimal current;
	private Short mode;
	private BigDecimal postionX;
	private BigDecimal postionY;
	private Short alarmStatus;
	private String collectTime;

	public BigDecimal getVoltage() {
		return voltage;
	}

	public void setVoltage(BigDecimal voltage) {
		this.voltage = voltage;
	}

	public BigDecimal getCurrent() {
		return current;
	}

	public void setCurrent(BigDecimal current) {
		this.current = current;
	}

	public Short getMode() {
		return mode;
	}

	public void setMode(Short mode) {
		this.mode = mode;
	}

	public BigDecimal getPostionX() {
		return postionX;
	}

	public void setPostionX(BigDecimal postionX) {
		this.postionX = postionX;
	}

	public BigDecimal getPostionY() {
		return postionY;
	}

	public void setPostionY(BigDecimal postionY) {
		this.postionY = postionY;
	}

	public Short getAlarmStatus() {
		return alarmStatus;
	}

	public void setAlarmStatus(Short alarmStatus) {
		this.alarmStatus = alarmStatus;
	}

	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}