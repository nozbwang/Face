package com.zbwang.face.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.zbwang.face.util.FormatUtil;

public class RobotTemperature {
	private Long recId;
	private Long robotId;
	private BigDecimal temperature;
	private Date collectTime;
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

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
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
}