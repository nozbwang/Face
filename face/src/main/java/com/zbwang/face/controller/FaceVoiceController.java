package com.zbwang.face.controller;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.constant.FaceConstants;
import com.zbwang.face.constant.FaceNotice;
import com.zbwang.face.domain.FaceMail;
import com.zbwang.face.service.FaceVoiceAttachLinkService;
import com.zbwang.face.service.FaceVoiceAttachService;
import com.zbwang.face.service.FaceVoiceService;
import com.zbwang.face.util.FileUtil;
import com.zbwang.face.util.FormatUtil;
import com.zbwang.face.util.MailUtil;
import com.zbwang.face.util.RequestUtil;
import com.zbwang.face.util.StringUtil;

@Controller
@RequestMapping("/face")
public class FaceVoiceController extends BaseController {

	@Autowired
	private FaceVoiceService faceVoiceService;
	@Autowired
	private FaceVoiceAttachService faceVoiceAttachService;
	@Autowired
	private FaceVoiceAttachLinkService faceVoiceAttachLinkService;
	@Value("#{propertyConfigurer['compress.picture.open']}")
	private String compressPictureOpen;
	@Value("#{propertyConfigurer['mail.voice.notice.to']}")
	private String voiceNoticeTo;
	@Value("#{propertyConfigurer['mail.voice.notice.bcc']}")
	private String voiceNoticeBcc;

	@RequestMapping("/insertVoice")
	public ModelAndView insertVoice(HttpServletRequest request) throws Exception {
		Map<String, Object> elements = RequestUtil.getElements(request);
		Integer userId = getUser(request).getUserId();
		if (!elements.isEmpty()) {
			int voiceId = faceVoiceService.insertVoice(userId, elements);
			int localPictureId = faceVoiceAttachService.insertLocalPicture(userId, elements, voiceId);
			int remotePictureId = faceVoiceAttachService.insertPictureFromRemote(userId, elements, voiceId);
			faceVoiceAttachLinkService.insertMusicFromRemote(userId, elements, voiceId);
			sendVoiceNoticeMail((String) elements.get("voice"), localPictureId, remotePictureId);
		}
		return getBaseModelAndView(getRedirectView(""), request);
	}

	private void sendVoiceNoticeMail(String voice, int localPictureId, int remotePictureId) {
		if (StringUtils.isBlank(voice) && isInvalidID(localPictureId) && isInvalidID(remotePictureId)) {
			return;
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("voice", voice);
		map.put("photo", getPhoto(localPictureId, remotePictureId));
		map.put("addTime", FormatUtil.formatDailyTime(new Date()));
		String basePath = this.getClass().getResource("").getPath();
		String rootPath = basePath.substring(1, basePath.indexOf("classes"));
		String voiceNoticeTemplate = getVoiceNoticeTemplate(voice, localPictureId, remotePictureId);
		String mailPath = rootPath + "classes/mail/" + voiceNoticeTemplate;
		String mailtemplate = FileUtil.readFile(mailPath);
		String content = StringUtil.replaceVariables(mailtemplate, map);
		sendVoiceNoticeMail(voice, content, voiceNoticeTo);
		sendVoiceNoticeMail(voice, content, voiceNoticeBcc);
	}

	private void sendVoiceNoticeMail(String voice, String content, String email) {
		FaceMail findMail = new FaceMail();
		findMail.setTo(email);
		findMail.setContent(content);
		findMail.setSubject(getNoticeMailTitle(voice));
		MailUtil.sendMailAsync(findMail);
	}

	@RequestMapping("/insert")
	public ModelAndView addVoice(HttpServletRequest request) {
		return getBaseModelAndView("voice_add", request);
	}

	@RequestMapping("/compressPicture")
	public ModelAndView compressPicture(HttpServletRequest request) {
		faceVoiceAttachService.compressPicture();
		return getBaseModelAndView("success", request);
	}

	@PostConstruct
	public void startCompressPictureMonitor() {
		if ("true".equals(compressPictureOpen)) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							TimeUnit.SECONDS.sleep(30);
							faceVoiceAttachService.compressPicture();
							faceVoiceAttachLinkService.compressPictureLink();
						} catch (Exception e) {
							log.error("Fail to compress Picture.", e);
						}
					}
				}
			}).start();
		}
	}

	private String getPhoto(int localPictureId, int remotePictureId) {
		StringBuilder result = new StringBuilder();
		if (!isInvalidID(localPictureId)) {
			result.append(MessageFormat.format(FaceConstants.photoDiv, localPictureId));
		}
		if (!isInvalidID(remotePictureId)) {
			result.append(MessageFormat.format(FaceConstants.photoDiv, remotePictureId));
		}
		return result.toString();
	}

	private String getVoiceNoticeTemplate(String voice, int localPictureId, int remotePictureId) {
		if (StringUtils.isBlank(voice)) {
			return "voiceNotice_Picture.mail";
		}
		if (isInvalidID(localPictureId) && isInvalidID(remotePictureId)) {
			return "voiceNotice_voice.mail";
		}
		return "voiceNotice.mail";
	}

	private String getNoticeMailTitle(String voice) {
		if (StringUtils.isEmpty(voice)) {
			return FaceNotice.VOICE_UPDATE.getNotice();
		}
		String result = StringUtils.trimToEmpty(voice);
		if (result.length() > FaceConstants.NOTICE_MAIL_TITLE_LENGTH) {
			return result.substring(0, FaceConstants.NOTICE_MAIL_TITLE_LENGTH);
		}
		return result;
	}

}
