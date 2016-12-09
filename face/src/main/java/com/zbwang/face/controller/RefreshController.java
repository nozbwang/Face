package com.zbwang.face.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;

/**
 * 用来刷新sqlmap。
 * 
 * @author yuezhen
 */
@Controller
@RequestMapping("/refresh")
public class RefreshController {

	@Autowired
	private SqlMapClientImpl sqlMapClient;

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap modelMap, HttpServletRequest request) throws IOException {

		sqlMapClient.fresh();

		return "redirect:/";
	}
}
