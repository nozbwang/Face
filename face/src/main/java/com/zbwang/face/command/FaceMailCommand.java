package com.zbwang.face.command;

public class FaceMailCommand extends BaseCommand {
	private String to;
	private String subject;
	private String content;

	public void setContent(String username, String password) {
		content = "";
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
