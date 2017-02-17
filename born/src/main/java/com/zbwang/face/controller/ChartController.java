package com.zbwang.face.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/chart")
public class ChartController extends BaseController {
	public static int i = 1;

	@RequestMapping("/showData")
	public ModelAndView showData() {
		return getBaseModelAndView("chart/showData");
	}

	@RequestMapping("/getRealTimeData")
	public void getRealTimeData(HttpServletResponse response) throws IOException {
		List<List<List<Double>>> result = Lists.newArrayList();
		List<List<Double>> middle = Lists.newArrayList();
		for (int j = 1; j < 50; j++) {
			List<Double> inner = new ArrayList<>();
			inner.add(i * 1.0);
			inner.add(Math.sin(i));
			i++;
			middle.add(inner);
		}
		result.add(middle);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().write(JSONArray.fromObject(result).toString());
	}
}
