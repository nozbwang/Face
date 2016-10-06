package com.zbwang.face.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.command.FaceUserCommand;
import com.zbwang.face.constant.FaceConstants;
import com.zbwang.face.constant.FaceNotice;
import com.zbwang.face.domain.FaceMail;
import com.zbwang.face.domain.FaceUser;
import com.zbwang.face.service.FaceUserService;
import com.zbwang.face.util.CookieUtil;
import com.zbwang.face.util.FileUtil;
import com.zbwang.face.util.MailUtil;
import com.zbwang.face.util.StringUtil;

@Controller
@RequestMapping("/user")
public class FaceUserController extends BaseController {

	@Autowired
	private FaceUserService loginService;

	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request) {
		return getBaseModelAndView("user/register", request);
	}

	@RequestMapping("/registerVoice")
	public ModelAndView registerVoice(FaceUserCommand userCommand, HttpServletRequest request, HttpServletResponse response) {
		if (userCommand.isRegisterComplete()) {
			FaceUser userInDB = loginService.getUser(userCommand.getUserName());
			if (userInDB == null) {
				FaceUser user = new FaceUser();
				user.setUserName(userCommand.getUserName());
				user.setPassword(userCommand.getPassword());
				user.setEmail(userCommand.getEmail());
				user.lowerUserName();
				Integer userId = loginService.insertUser(user);
				recordLGFoot(request, response, userId);
				return getSuccessModelAndView(FaceNotice.REGISTER_SUCCESS.getNotice(), request);
			}
			return getErrorModelAndView(FaceNotice.REGISTER_EXIST.getNotice(), request);
		}
		return getErrorModelAndView(FaceNotice.REGISTER_ERROR.getNotice(), request);
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		if (isLogon(request)) {
			return getBaseModelAndView(getRedirectView(""), request);
		}
		return getBaseModelAndView("user/login", request);
	}

	@RequestMapping("/loginVoice")
	public ModelAndView loginVoice(FaceUserCommand userCommand, HttpServletRequest request, HttpServletResponse response) {
		if (userCommand.isLoginComplete()) {
			FaceUser faceUser = loginService.getUser(userCommand.getUserName());
			if (faceUser != null && faceUser.getPassword().equals(userCommand.getPassword())) {
				recordLGFoot(request, response, faceUser.getUserId());
				return getSuccessModelAndView(FaceNotice.LOGIN_SUCCESS.getNotice(), request);
			}
		}
		return getErrorModelAndView(FaceNotice.LOGIN_ERROR.getNotice(), request);
	}

	@RequestMapping("/loginOut")
	public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response) {
		CookieUtil.removeLGCookie(response);
		CookieUtil.removeLVTCookie(response);
		request.getSession().removeAttribute(FaceConstants.SESSION_LOGIN);
		return getBaseModelAndView(getRedirectView(""), request);
	}

	private void recordLGFoot(HttpServletRequest request, HttpServletResponse response, Integer userId) {
		CookieUtil.addLVTCookie(response);
		CookieUtil.addLGCookie(response, userId.toString());
		request.getSession().setAttribute(FaceConstants.SESSION_LOGIN, userId.toString());
	}

	@RequestMapping("/find")
	public ModelAndView find(HttpServletRequest request) {
		return getBaseModelAndView("user/findPassword", request);
	}

	@RequestMapping("/findPassword")
	public ModelAndView findPassword(FaceUserCommand userCommand, HttpServletRequest request) {
		if (StringUtils.isNotBlank(userCommand.getUserName())) {
			FaceUser faceUser = loginService.getUser(userCommand.getUserName());
			if (faceUser != null) {
				String basePath = this.getClass().getResource("").getPath();
				String rootPath = basePath.substring(1, basePath.indexOf("classes"));
				String mailPath = rootPath + "classes/mail/Getpassword.mail";
				String mailtemplate = FileUtil.readFile(mailPath);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("password", faceUser.getPassword());
				String content = StringUtil.replaceVariables(mailtemplate, map);
				FaceMail findMail = new FaceMail();
				findMail.setTo(faceUser.getEmail());
				findMail.setContent(content);
				findMail.setSubject(FaceNotice.FINDMAIL_TOPIC.getNotice());
				MailUtil.sendMailAsync(findMail);
				return getSuccessModelAndView(FaceNotice.FIND_SUCCESS.getNotice(), request);
			}
		}
		return getErrorModelAndView(FaceNotice.FIND_NOT_EXIST.getNotice(), request);
	}

}
