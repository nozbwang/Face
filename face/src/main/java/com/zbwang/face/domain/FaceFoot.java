package com.zbwang.face.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zbwang.face.util.FormatUtil;

public class FaceFoot {

	private Integer footId;

	private Integer userId;

	private String footTitle;

	private String footer;

	private String footDetail;

	private Date addTime;

	private Date updateTime;

	private FaceVoiceAttach faceVoiceAttach;

	public Integer getFootId() {
		return footId;
	}

	public void setFootId(Integer footId) {
		this.footId = footId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFootTitle() {
		return footTitle;
	}

	public void setFootTitle(String footTitle) {
		this.footTitle = footTitle;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getFootDetail() {
		return footDetail;
	}

	public void setFootDetail(String footDetail) {
		this.footDetail = footDetail;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public void setAddTime(String addTime) {
		try {
			this.addTime = new SimpleDateFormat("yy-MM-dd").parse(addTime);
		} catch (ParseException e) {
			this.addTime = new Date();
		}
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getFormattedAddTime() {
		return FormatUtil.formatDailyTime(addTime);
	}

	public FaceVoiceAttach getFaceVoiceAttach() {
		return faceVoiceAttach;
	}

	public void setFaceVoiceAttach(FaceVoiceAttach faceVoiceAttach) {
		this.faceVoiceAttach = faceVoiceAttach;
	}
}