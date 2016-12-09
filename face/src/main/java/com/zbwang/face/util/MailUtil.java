package com.zbwang.face.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zbwang.face.domain.Mail;

@Component
public class MailUtil {
	@Value("${mail.smtp.auth}")
	private String mailAuth;
	@Value("${mail.smtp.host}")
	private String mailHost;
	@Value("${mail.user}")
	private String mailUser;
	@Value("${mail.password}")
	private static String mailPassword;

	private static final Logger LOG = Logger.getLogger(MailUtil.class);

	public static void sendMailAsync(final Mail mailBean) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				sendMail(mailBean);
			}
		}).start();
	}

	public static void main(String[] args) {
		Mail jj = new Mail();
		jj.setTo("498330153@qq.com");
		jj.setContent("来自于马来西12亚的玻璃");
		jj.setSubject("来自于马来西12ewr亚的玻璃");
		sendMail(jj);
	}

	public static void sendMail(Mail mailBean) {
		final Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.user", "melody1926@126.com");
		props.put("mail.password", "a19891123");
		props.put("mail.smtp.port", "25");

		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		Session mailSession = Session.getInstance(props, authenticator);
		MimeMessage message = new MimeMessage(mailSession);
		InternetAddress form;
		try {
			form = new InternetAddress(props.getProperty("mail.user"));
			message.setFrom(form);
			if (mailBean.getTo() != null) {
				message.setRecipients(RecipientType.TO, InternetAddress.parse(mailBean.getTo()));
			}
			// if (mailBean.getCc() != null) {
			// message.setRecipients(RecipientType.CC,
			// InternetAddress.parse(mailBean.getCc()));
			// }
			// if (mailBean.getBcc() != null) {
			// message.setRecipients(RecipientType.BCC,
			// InternetAddress.parse(mailBean.getBcc()));
			// }
			message.setSubject(mailBean.getSubject());
			message.setContent(mailBean.getContent(), "text/html;charset=UTF-8");
			Transport.send(message);
		} catch (MessagingException e) {
			LOG.error("Fail to send mail", e);
			throw new RuntimeException(e.getMessage());
		}
	}
}