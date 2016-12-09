package com.zbwang.face.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.domain.Voice;
import com.zbwang.face.service.IAttachService;
import com.zbwang.face.service.IVoiceService;

@Controller
public class IndexController extends BaseController {
	@Autowired
	private IVoiceService faceVoiceService;
	@Autowired
	private IAttachService faceVoiceAttachService;

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Voice> latestVoiceGroup = faceVoiceService.getLatestVoice(0, 20);
		faceVoiceAttachService.prepareVoiceAttach(latestVoiceGroup);
		return getBaseModelAndView(latestVoiceGroup, "index", request);
	}

}
