package com.zbwang.face.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.constant.Constants;
import com.zbwang.face.dao.cache.ParamCache;
import com.zbwang.face.domain.Parameter;
import com.zbwang.face.domain.Voice;
import com.zbwang.face.service.IAttachService;
import com.zbwang.face.service.IVoiceService;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
	@Autowired
	private IVoiceService faceVoiceService;
	@Autowired
	private IAttachService faceVoiceAttachService;

	@RequestMapping("")
	public ModelAndView index(HttpServletRequest request, Integer homeId) throws ExecutionException {
		List<Voice> latestVoiceGroup = faceVoiceService.getLatestVoice(0, 100, Constants.B_TYPE_HOME, homeId);
		List<Parameter> baseParameters = ParamCache.getBaseParameter(Constants.HOME);
		faceVoiceAttachService.prepareVoiceAttach(latestVoiceGroup);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("command", latestVoiceGroup);
		modelMap.put("baseLink", "/home");
		modelMap.put("baseParameters", baseParameters);
		return getBaseModelAndView(modelMap, "home/index", request);
	}

	@RequestMapping("/{NameEn}")
	public ModelAndView bookCatalog(HttpServletRequest request, @PathVariable String NameEn) throws ExecutionException {
		Integer homeId = ParamCache.getBaseParameterId(Constants.HOME, NameEn);
		return index(request, homeId);
	}

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request) throws ExecutionException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Parameter> baseParameters = ParamCache.getBaseParameter(Constants.HOME);
		modelMap.put("baseLink", "/home");
		modelMap.put("baseParameters", baseParameters);
		return getBaseModelAndView(modelMap, "home/voice_add_home", request);
	}

}
