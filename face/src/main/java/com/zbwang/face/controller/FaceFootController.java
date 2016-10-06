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

import com.zbwang.face.constant.FaceConstants;
import com.zbwang.face.domain.FaceFoot;
import com.zbwang.face.domain.FaceVoice;
import com.zbwang.face.domain.FaceVoiceAttach;
import com.zbwang.face.service.FaceFootService;
import com.zbwang.face.service.FaceVoiceAttachService;
import com.zbwang.face.service.FaceVoiceService;
import com.zbwang.face.util.CommonUtil;
import com.zbwang.face.util.RequestUtil;

@Controller
@RequestMapping("/foot")
public class FaceFootController extends BaseController {

	@Autowired
	private FaceFootService faceFootService;
	@Autowired
	private FaceVoiceAttachService faceVoiceAttachService;
	@Autowired
	private FaceVoiceService faceVoiceService;

	@RequestMapping("")
	public ModelAndView foot(HttpServletRequest request, String catalog) {
		List<FaceFoot> latestFootGroup = faceFootService.getLatestFoot(0, 20);
		List<Integer> voiceIdGroup = new ArrayList<Integer>();
		for (FaceFoot faceFoot : latestFootGroup) {
			voiceIdGroup.add(faceFoot.getFootId());
		}
		Map<String, List<FaceVoiceAttach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(voiceIdGroup,
				FaceConstants.B_TYPE_FOOT);
		for (FaceFoot faceFoot : latestFootGroup) {
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
		FaceFoot faceBook = faceFootService.getFootById(NumberUtils.toInt(request.getParameter("footId")));
		List<Integer> bookIdGroup = new ArrayList<Integer>();
		bookIdGroup.add(faceBook.getFootId());
		Map<String, List<FaceVoiceAttach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(bookIdGroup,
				FaceConstants.B_TYPE_FOOT);
		faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getFootId(), faceVoiceAttachMap));
		return getBaseModelAndView(faceBook, "foot/voice_add_foot", request);
	}

	@RequestMapping("/detail")
	public ModelAndView bookDetail(HttpServletRequest request) {
		FaceFoot faceBook = faceFootService.getFootById(NumberUtils.toInt(request.getParameter("footId")));
		List<Integer> footIdGroup = new ArrayList<Integer>();
		footIdGroup.add(faceBook.getFootId());
		Map<String, List<FaceVoiceAttach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(footIdGroup,
				FaceConstants.B_TYPE_FOOT);
		faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getFootId(), faceVoiceAttachMap));
		List<FaceVoice> latestVoiceGroup = faceVoiceService.getLatestVoice(0, 20, FaceConstants.B_TYPE_FOOT,
				faceBook.getFootId());
		List<Integer> voiceIdGroup = new ArrayList<Integer>();
		for (FaceVoice faceVoice : latestVoiceGroup) {
			voiceIdGroup.add(faceVoice.getVoiceId());
		}
		Map<String, List<FaceVoiceAttach>> faceVoiceAttachMap2 = faceVoiceAttachService.getAttachByVoiceIdGroup(voiceIdGroup);
		for (FaceVoice faceVoice : latestVoiceGroup) {
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
