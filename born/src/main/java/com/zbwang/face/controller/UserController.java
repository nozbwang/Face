package com.zbwang.face.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.constant.Constants;
import com.zbwang.face.constant.MessageConstants;
import com.zbwang.face.domain.Mail;
import com.zbwang.face.domain.User;
import com.zbwang.face.dto.UserCommand;
import com.zbwang.face.service.IUserService;
import com.zbwang.face.util.CookieUtil;
import com.zbwang.face.util.FileUtil;
import com.zbwang.face.util.MailUtil;
import com.zbwang.face.util.StringUtil;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private IUserService loginService;

	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request) {
		return getBaseModelAndView("user/register");
	}

	@RequestMapping("/registerVoice")
	public ModelAndView registerVoice(UserCommand userCommand, HttpServletRequest request, HttpServletResponse response) {
		if (userCommand.isRegisterComplete()) {
			User userInDB = loginService.getUser(userCommand.getUserName());
			if (userInDB == null) {
				User user = new User();
				user.setUserName(userCommand.getUserName());
				user.setPassword(userCommand.getPassword());
				user.setEmail(userCommand.getEmail());
				Integer userId = loginService.insertUser(user);
				recordLGFoot(request, response, userId);
				return getSuccessModelAndView(MessageConstants.REGISTER_SUCCESS.getNotice());
			}
			return getErrorModelAndView(MessageConstants.REGISTER_EXIST.getNotice());
		}
		return getErrorModelAndView(MessageConstants.REGISTER_ERROR.getNotice());
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		if (isLogon()) {
			return getBaseModelAndView(getRedirectView(""));
		}
		return getBaseModelAndView("user/login");
	}

	@RequestMapping("/loginVoice")
	public ModelAndView loginVoice(UserCommand userCommand, HttpServletRequest request, HttpServletResponse response) {
		if (userCommand.isLoginComplete()) {
			User faceUser = loginService.getUser(userCommand.getUserName());
			if (faceUser != null && faceUser.getPassword().equals(userCommand.getPassword())) {
				recordLGFoot(request, response, faceUser.getUserId());
				return getSuccessModelAndView(MessageConstants.LOGIN_SUCCESS.getNotice());
			}
		}
		return getErrorModelAndView(MessageConstants.LOGIN_ERROR.getNotice());
	}

	@RequestMapping("/loginOut")
	public ModelAndView loginOut(HttpServletRequest request, HttpServletResponse response) {
		CookieUtil.removeLGCookie(response);
		CookieUtil.removeLVTCookie(response);
		request.getSession().removeAttribute(Constants.SESSION_LOGIN);
		return getBaseModelAndView(getRedirectView(""));
	}

	private void recordLGFoot(HttpServletRequest request, HttpServletResponse response, Integer userId) {
		CookieUtil.addLVTCookie(response);
		CookieUtil.addLGCookie(response, userId.toString());
		request.getSession().setAttribute(Constants.SESSION_LOGIN, userId.toString());
	}

	@RequestMapping("/find")
	public ModelAndView find(HttpServletRequest request) {
		return getBaseModelAndView("user/findPassword");
	}

	@RequestMapping("/findPassword")
	public ModelAndView findPassword(UserCommand userCommand, HttpServletRequest request) {
		if (StringUtils.isNotBlank(userCommand.getUserName())) {
			User faceUser = loginService.getUser(userCommand.getUserName());
			log.error("start");
			if (faceUser != null) {
				String basePath = this.getClass().getResource("").getPath();
				String rootPath = basePath.substring(0, basePath.indexOf("classes"));
				String mailPath = rootPath + "classes/mail/find_password.mail";
				String mailtemplate = FileUtil.readFile(mailPath);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("password", faceUser.getPassword());
				String content = StringUtil.replaceVariables(mailtemplate, map);
				Mail findMail = new Mail();
				findMail.setTo(faceUser.getEmail());
				findMail.setContent(content);
				findMail.setSubject(MessageConstants.FINDMAIL_TOPIC.getNotice());
				MailUtil.sendMailAsync(findMail);
				return getSuccessModelAndView(MessageConstants.FIND_SUCCESS.getNotice());
			}
		}
		return getErrorModelAndView(MessageConstants.FIND_NOT_EXIST.getNotice());
	}
}
