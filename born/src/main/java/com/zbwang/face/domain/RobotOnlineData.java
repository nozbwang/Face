package com.zbwang.face.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.zbwang.face.util.FormatUtil;

public class RobotOnlineData {
	private Long recId;
	private String uuid;
	private BigDecimal voltage;
	private BigDecimal current;
	private Short mode;
	private BigDecimal postionX;
	private BigDecimal postionY;
	private Short alarmStatus;
	private Date collectTime;
	private Date addTime;

	public Long getRecId() {
		return recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

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

	public Date getCollectTime() {
		return collectTime;
	}

	public String getFormattedCollectTime() {
		return FormatUtil.formatMinuteTime(collectTime);
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}