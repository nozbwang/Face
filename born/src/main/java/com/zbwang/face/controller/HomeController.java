package com.zbwang.face.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
	@RequestMapping("/")
	public ModelAndView index() {
		return getBaseModelAndView("index");
	}
}
