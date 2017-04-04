package com.zbwang.face.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.zbwang.face.util.FormatUtil;

public class RobotMotion {
	private Long recId;
	private String uuid;
	private BigDecimal power;
	private BigDecimal heartRateWired;
	private BigDecimal heartRateWireless;
	private BigDecimal speed;
	private BigDecimal energy;
	private Short status;
	private Date collectTime;
	private Date addTime;

	public Long getRecId() {
		return recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public BigDecimal getPower() {
		return power;
	}

	public void setPower(BigDecimal power) {
		this.power = power;
	}

	public BigDecimal getHeartRateWired() {
		return heartRateWired;
	}

	public void setHeartRateWired(BigDecimal heartRateWired) {
		this.heartRateWired = heartRateWired;
	}

	public BigDecimal getHeartRateWireless() {
		return heartRateWireless;
	}

	public void setHeartRateWireless(BigDecimal heartRateWireless) {
		this.heartRateWireless = heartRateWireless;
	}

	public BigDecimal getSpeed() {
		return speed;
	}

	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}

	public BigDecimal getEnergy() {
		return energy;
	}

	public void setEnergy(BigDecimal energy) {
		this.energy = energy;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
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