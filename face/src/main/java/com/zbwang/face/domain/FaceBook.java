package com.zbwang.face.domain;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.zbwang.face.util.FormatUtil;

public class FaceBook {

	private Integer bookId;

	private Integer userId;

	private String bookTitle;

	private String author;

	private String bookDetail;

	private Date addTime;

	private Date updateTime;

	private String bookType;

	private FaceVoiceAttach faceVoiceAttach;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getFormattedAddTime() {
		if (addTime != null) {
			return FormatUtil.formatDailyTime(addTime);
		}
		return StringUtils.EMPTY;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public FaceVoiceAttach getFaceVoiceAttach() {
		return faceVoiceAttach;
	}

	public void setFaceVoiceAttach(FaceVoiceAttach faceVoiceAttach) {
		this.faceVoiceAttach = faceVoiceAttach;
	}

}