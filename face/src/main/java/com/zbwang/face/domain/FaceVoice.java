package com.zbwang.face.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.zbwang.face.util.FormatUtil;

public class FaceVoice {

	private Integer voiceId;
	private Integer userId;
	private String voice;
	private Date addTime;
	private Date updateTime;
	// 0：网站建议 1：读书
	private String voiceType;
	private Integer belongId;
	private String belongType;
	private List<FaceVoiceAttach> faceVoiceAttachs;
	private List<FaceVoiceAttachLink> faceVoiceAttachLinks;

	public Integer getVoiceId() {
		return voiceId;
	}

	public void setVoiceId(Integer voiceId) {
		this.voiceId = voiceId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getVoice() {
		return voice;
	}

	public void clearExtraLine() {
		voice = StringUtils.trimToEmpty(voice).replaceAll("(\r\n){1,}", "\r\n");
	}

	public boolean isNotEmpty() {
		return StringUtils.isNotBlank(voice);
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public Date getAddTime() {
		return addTime;
	}

	public String getFormattedAddTime() {
		if (addTime != null) {
			return FormatUtil.formatDailyTime(addTime);
		}
		return StringUtils.EMPTY;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<FaceVoiceAttach> getFaceVoiceAttachs() {
		return faceVoiceAttachs;
	}

	public void setFaceVoiceAttachs(List<FaceVoiceAttach> faceVoiceAttachs) {
		this.faceVoiceAttachs = faceVoiceAttachs;
	}

	public List<FaceVoiceAttachLink> getFaceVoiceAttachLinks() {
		return faceVoiceAttachLinks;
	}

	public void setFaceVoiceAttachLinks(List<FaceVoiceAttachLink> faceVoiceAttachLinks) {
		this.faceVoiceAttachLinks = faceVoiceAttachLinks;
	}

	public String getVoiceType() {
		return voiceType;
	}

	public void setVoiceType(String voiceType) {
		this.voiceType = voiceType;
	}

	public Integer getBelongId() {
		return belongId;
	}

	public void setBelongId(Integer belongId) {
		this.belongId = belongId;
	}

	public String getBelongType() {
		return belongType;
	}

	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}

}