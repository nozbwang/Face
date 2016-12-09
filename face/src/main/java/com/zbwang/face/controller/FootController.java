package com.zbwang.face.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.constant.Constants;
import com.zbwang.face.domain.Attach;
import com.zbwang.face.domain.Foot;
import com.zbwang.face.domain.Voice;
import com.zbwang.face.service.IAttachService;
import com.zbwang.face.service.IFootService;
import com.zbwang.face.service.IVoiceService;
import com.zbwang.face.util.CommonUtil;
import com.zbwang.face.util.RequestUtil;

@Controller
@RequestMapping("/foot")
public class FootController extends BaseController {

	@Autowired
	private IFootService faceFootService;
	@Autowired
	private IAttachService faceVoiceAttachService;
	@Autowired
	private IVoiceService faceVoiceService;

	@RequestMapping("")
	public ModelAndView foot(HttpServletRequest request, String catalog) {
		List<Foot> latestFootGroup = faceFootService.getLatestFoot(0, 20);
		List<Integer> voiceIdGroup = new ArrayList<Integer>();
		for (Foot faceFoot : latestFootGroup) {
			voiceIdGroup.add(faceFoot.getFootId());
		}
		Map<String, List<Attach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(voiceIdGroup,
				Constants.B_TYPE_FOOT);
		for (Foot faceFoot : latestFootGroup) {
			faceFoot.setFaceVoiceAttach(CommonUtil.getFirstElement(faceFoot.getFootId(), faceVoiceAttachMap));
		}
		return getBaseModelAndView(latestFootGroup, "foot/index_foot", request);
	}

	@RequestMapping("/insert")
	public ModelAndView addVoice(HttpServletRequest request) {
		return getBaseModelAndView("foot/foot_add", request);
	}

	@RequestMapping("/insertFootVoice")
	public ModelAndView addFootVoice(HttpServletRequest request) {
		Foot faceBook = faceFootService.getFootById(NumberUtils.toInt(request.getParameter("footId")));
		List<Integer> bookIdGroup = new ArrayList<Integer>();
		bookIdGroup.add(faceBook.getFootId());
		Map<String, List<Attach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(bookIdGroup,
				Constants.B_TYPE_FOOT);
		faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getFootId(), faceVoiceAttachMap));
		return getBaseModelAndView(faceBook, "foot/voice_add_foot", request);
	}

	@RequestMapping("/detail")
	public ModelAndView bookDetail(HttpServletRequest request) {
		Foot faceBook = faceFootService.getFootById(NumberUtils.toInt(request.getParameter("footId")));
		List<Integer> footIdGroup = new ArrayList<Integer>();
		footIdGroup.add(faceBook.getFootId());
		Map<String, List<Attach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(footIdGroup,
				Constants.B_TYPE_FOOT);
		faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getFootId(), faceVoiceAttachMap));
		List<Voice> latestVoiceGroup = faceVoiceService.getLatestVoice(0, 20, Constants.B_TYPE_FOOT,
				faceBook.getFootId());
		List<Integer> voiceIdGroup = new ArrayList<Integer>();
		for (Voice faceVoice : latestVoiceGroup) {
			voiceIdGroup.add(faceVoice.getVoiceId());
		}
		Map<String, List<Attach>> faceVoiceAttachMap2 = faceVoiceAttachService.getAttachByVoiceIdGroup(voiceIdGroup);
		for (Voice faceVoice : latestVoiceGroup) {
			faceVoice.setFaceVoiceAttachs(faceVoiceAttachMap2.get(String.valueOf(faceVoice.getVoiceId())));
		}
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("voices", latestVoiceGroup);
		modelMap.put("foot", faceBook);
		return getBaseModelAndView(modelMap, "foot/detail_foot", request);
	}

	@SuppressWarnings("unused")
	@RequestMapping("/insertFoot")
	public ModelAndView insertFoot(HttpServletRequest request) throws Exception {
		Map<String, Object> elements = RequestUtil.getElements(request);
		Integer userId = getUser(request).getUserId();
		if (!elements.isEmpty()) {
			int footId = faceFootService.insertFoot(getUser(request).getUserId(), elements);
			faceVoiceAttachService.insertLocalPicture(userId, elements, footId);
			int remotePictureId = faceVoiceAttachService.insertPictureFromRemote(userId, elements, footId);
		}
		return getBaseModelAndView(getRedirectView("/foot"), request);
	}

}
