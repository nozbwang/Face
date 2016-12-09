package com.zbwang.face.controller;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.constant.Constants;
import com.zbwang.face.constant.MessageConstants;
import com.zbwang.face.domain.Mail;
import com.zbwang.face.service.IAttachLinkService;
import com.zbwang.face.service.IAttachService;
import com.zbwang.face.service.IVoiceService;
import com.zbwang.face.util.FileUtil;
import com.zbwang.face.util.FormatUtil;
import com.zbwang.face.util.MailUtil;
import com.zbwang.face.util.RequestUtil;
import com.zbwang.face.util.StringUtil;

@Controller
@RequestMapping("/face")
public class VoiceController extends BaseController {

	@Autowired
	private IVoiceService faceVoiceService;
	@Autowired
	private IAttachService faceVoiceAttachService;
	@Autowired
	private IAttachLinkService faceVoiceAttachLinkService;
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
		String belongType = (String) elements.get("belongType");
		if (!elements.isEmpty()) {
			int voiceId = faceVoiceService.insertVoice(userId, elements);
			List<Integer> localPictureIds = faceVoiceAttachService.insertLocalPicture(userId, elements, voiceId);
			int remotePictureId = faceVoiceAttachService.insertPictureFromRemote(userId, elements, voiceId);
			faceVoiceAttachLinkService.insertMusicFromRemote(userId, elements, voiceId);
			if (!Constants.B_TYPE_TREEHOLE.equals(belongType)) {
				sendVoiceNoticeMail((String) elements.get("voice"), localPictureIds, remotePictureId);
			}
		}
		if (StringUtils.isNotEmpty(belongType)) {
			if (Constants.B_TYPE_BOOK.equals(belongType)) {
				int belongId = NumberUtils.toInt((String) elements.get("belongId"));
				return getBaseModelAndView(getRedirectView("book/detail?bookId=" + belongId), request);
			} else if (Constants.B_TYPE_TREEHOLE.equals(belongType)) {
				return getBaseModelAndView(getRedirectView("treehole"), request);
			} else if (Constants.B_TYPE_HOME.equals(belongType)) {
				return getBaseModelAndView(getRedirectView("home"), request);
			}
		}
		return getBaseModelAndView(getRedirectView(""), request);
	}

	@RequestMapping("/updateVoice")
	public ModelAndView updateVoice(HttpServletRequest request) throws Exception {
		Map<String, Object> elements = RequestUtil.getElements(request);
		Integer userId = getUser(request).getUserId();
		if (userId != null && Constants.ID_UNKOWN != userId) {
			faceVoiceService.updateVoice(userId, elements);
			sendVoiceNoticeMail((String) elements.get("voice"));
		}
		String belongType = (String) elements.get("belongType");
		if (Constants.B_TYPE_BOOK.equals(belongType)) {
			int belongId = NumberUtils.toInt((String) elements.get("belongId"));
			return getBaseModelAndView(getRedirectView("book/detail?bookId=" + belongId), request);
		}
		return

		getBaseModelAndView(getRedirectView(""), request);
	}

	@RequestMapping("/deleteVoice")
	public ModelAndView deleteVoice(HttpServletRequest request) throws Exception {
		Integer userId = getUser(request).getUserId();
		Integer voiceId = NumberUtils.toInt((String) request.getParameter("voiceId"));
		if (userId != null && Constants.ID_UNKOWN != userId) {
			faceVoiceService.deleteVoice(voiceId, userId);
		}
		String belongType = (String) request.getParameter("belongType");
		if (Constants.B_TYPE_BOOK.equals(belongType)) {
			int belongId = NumberUtils.toInt((String) request.getParameter("belongId"));
			return getBaseModelAndView(getRedirectView("book/detail?bookId=" + belongId), request);
		}
		return getBaseModelAndView(getRedirectView(""), request);
	}

	private void sendVoiceNoticeMail(String voice) {
		sendVoiceNoticeMail(voice, null, Constants.ID_UNKOWN);
	}

	private void sendVoiceNoticeMail(String voice, List<Integer> localPictureIds, int remotePictureId) {
		if (StringUtils.isBlank(voice) && CollectionUtils.isEmpty(localPictureIds) && isInvalidID(remotePictureId)) {
			return;
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("voice", voice);
		map.put("photo", getPhoto(localPictureIds, remotePictureId));
		map.put("addTime", FormatUtil.formatMinuteTime(new Date()));
		String basePath = this.getClass().getResource("").getPath();
		String rootPath = basePath.substring(1, basePath.indexOf("classes"));
		String voiceNoticeTemplate = getVoiceNoticeTemplate(voice, localPictureIds, remotePictureId);
		String mailPath = rootPath + "classes/mail/" + voiceNoticeTemplate;
		String mailtemplate = FileUtil.readFile(mailPath);
		String content = StringUtil.replaceVariables(mailtemplate, map);
		sendVoiceNoticeMail(voice, content, voiceNoticeTo);
		sendVoiceNoticeMail(voice, content, voiceNoticeBcc);
	}

	private void sendVoiceNoticeMail(String voice, String content, String email) {
		Mail findMail = new Mail();
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
		return getBaseModelAndView("common/success", request);
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

	private String getPhoto(List<Integer> localPictureIds, int remotePictureId) {
		StringBuilder result = new StringBuilder();
		if (CollectionUtils.isNotEmpty(localPictureIds)) {
			for (Integer localPictureId : localPictureIds) {
				result.append(MessageFormat.format(Constants.photoDiv, localPictureId));
			}
		}
		if (!isInvalidID(remotePictureId)) {
			result.append(MessageFormat.format(Constants.photoDiv, remotePictureId));
		}
		return result.toString();
	}

	private String getVoiceNoticeTemplate(String voice, List<Integer> localPictureIds, int remotePictureId) {
		if (StringUtils.isBlank(voice)) {
			return "notice_picture.mail";
		}
		if (CollectionUtils.isNotEmpty(localPictureIds) || !isInvalidID(remotePictureId)) {
			return "notice_voice_picture.mail";
		}
		return "notice_voice.mail";
	}

	private String getNoticeMailTitle(String voice) {
		if (StringUtils.isEmpty(voice)) {
			return MessageConstants.VOICE_UPDATE.getNotice();
		}
		String result = StringUtils.trimToEmpty(voice);
		if (result.length() > Constants.NOTICE_MAIL_TITLE_LENGTH) {
			return result.substring(0, Constants.NOTICE_MAIL_TITLE_LENGTH);
		}
		return result;
	}

}
