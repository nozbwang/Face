package com.zbwang.face.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.zbwang.face.constant.Constants;
import com.zbwang.face.domain.User;
import com.zbwang.face.util.SecurityInfoHolder;

import net.sf.json.JSONObject;

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

	public void writeData(HttpServletResponse response, Object result) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().write(JSONObject.fromObject(result).toString());
	}

	public void writeSuccessData(HttpServletResponse response) throws IOException {
		Map<String, Object> map = Maps.newHashMap();
		map.put("code", Constants.SUCCESS);
		writeData(response, map);
	}

	public void writeSuccessData(HttpServletResponse response, String key, Object value) throws IOException {
		Map<String, Object> map = Maps.newHashMap();
		map.put("code", Constants.SUCCESS);
		map.put(key, value);
		writeData(response, map);
	}

	public void writeSuccessData(HttpServletResponse response, Map<String, Object> map) throws IOException {
		map.put("code", Constants.SUCCESS);
		writeData(response, map);
	}

	public void writeFailureData(HttpServletResponse response, String key, Object value) throws IOException {
		Map map = Maps.newHashMap();
		map.put("code", Constants.FAILURE);
		map.put(key, value);
		response.getWriter().write(JSONObject.fromObject(map).toString());
	}
}
