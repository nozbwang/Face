package com.zbwang.face.dto;

import java.math.BigDecimal;

public class RobotMotionCommand {
	private String uuid;
	private BigDecimal power;
	private BigDecimal heartRateWired;
	private BigDecimal heartRateWireless;
	private BigDecimal speed;
	private BigDecimal energy;
	private Short status;
	private String collectTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}
}