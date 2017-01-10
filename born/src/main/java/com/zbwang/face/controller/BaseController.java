package com.zbwang.face.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.constant.Constants;
import com.zbwang.face.domain.User;
import com.zbwang.face.util.SecurityInfoHolder;

public class BaseController {
	protected Logger log = Logger.getLogger("errorR");

	public ModelAndView getModelAndView(String key, Object object, String view) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(key, object);
		modelAndView.setViewName(view);
		modelAndView.addObject("user", getUser());
		return modelAndView;
	}

	public ModelAndView getBaseModelAndView(Object object, String view) {
		return getModelAndView("command", object, view);
	}

	public ModelAndView getBaseModelAndView(Map modelMap, String view) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(modelMap);
		modelAndView.setViewName(view);
		modelAndView.addObject("user", getUser());
		return modelAndView;
	}

	public ModelAndView getBaseModelAndView(String view) {
		return getBaseModelAndView(null, view);
	}

	public ModelAndView getSuccessModelAndView(Object object) {
		return getModelAndView("success", object, "common/success");
	}

	public ModelAndView getErrorModelAndView(Object object) {
		return getModelAndView("error", object, "common/error");
	}

	public boolean isLogon() {
		User user = getUser();
		return user != null && user.getUserId() != 0;
	}

	public boolean isInvalidID(int id) {
		return id == Constants.ID_UNKOWN;
	}

	public User getUser() {
		return SecurityInfoHolder.getSecurityInfo().getUser();
	}

	public String getForwardView(String view) {
		return "forward:/" + view;
	}

	public String getRedirectView(String view) {
		return "redirect:/" + view;
	}
}
