package com.zbwang.face.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plan")
public class PlanController {
	@RequestMapping("/add")
	public String addPlan() {
		return "plan/plan_add";
	}
}
