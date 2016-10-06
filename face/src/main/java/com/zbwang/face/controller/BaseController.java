package com.zbwang.face.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.constant.FaceConstants;
import com.zbwang.face.domain.FaceUser;
import com.zbwang.face.util.SecurityInfoHolder;

public class BaseController {

	protected Logger log = Logger.getLogger(getClass());

	public ModelAndView getModelAndView(String key, Object object, String view, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(key, object);
		modelAndView.setViewName(view);
		modelAndView.addObject("user", getUser(request));
		return modelAndView;
	}

	public ModelAndView getBaseModelAndView(Object object, String view, HttpServletRequest request) {
		return getModelAndView("command", object, view, request);
	}

	public ModelAndView getBaseModelAndView(Map modelMap, String view, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(modelMap);
		modelAndView.setViewName(view);
		modelAndView.addObject("user", getUser(request));
		return modelAndView;
	}

	public ModelAndView getBaseModelAndView(String view, HttpServletRequest request) {
		return getBaseModelAndView(null, view, request);
	}

	public ModelAndView getSuccessModelAndView(Object object, HttpServletRequest request) {
		return getModelAndView("success", object, "common/success", request);
	}

	public ModelAndView getErrorModelAndView(Object object, HttpServletRequest request) {
		return getModelAndView("error", object, "common/error", request);
	}

	public boolean isLogon(HttpServletRequest request) {
		FaceUser user = getUser(request);
		return user != null && user.getUserId() != 0;
	}

	public boolean isInvalidID(int id) {
		return id == FaceConstants.ID_UNKOWN;
	}

	public FaceUser getUser(HttpServletRequest request) {
		return SecurityInfoHolder.getSecurityInfo().getUser();
	}

	public String getForwardView(String view) {
		return "forward:/" + view;
	}

	public String getRedirectView(String view) {
		return "redirect:/" + view;
	}

}
