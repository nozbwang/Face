package com.zbwang.face.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.domain.Parameter;
import com.zbwang.face.service.IParamService;

@Controller
@RequestMapping("/bp")
public class ParamController extends BaseController {
	@Autowired
	private IParamService faceBaseParameterService;

	@RequestMapping("")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		List<Parameter> baseParameter = faceBaseParameterService.getAllBaseParameter();
		return getBaseModelAndView(baseParameter, "baseParameter/index", request);
	}

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		List<Parameter> baseParameter = faceBaseParameterService.getAllBaseParameter();
		return getBaseModelAndView(baseParameter, "baseParameter/baseParameter_add", request);
	}

	@RequestMapping("/insert")
	public String insert(Parameter baseParameter, HttpServletRequest request, HttpServletResponse response) {
		faceBaseParameterService.insert(baseParameter);
		return getRedirectView("bp");
	}

}
