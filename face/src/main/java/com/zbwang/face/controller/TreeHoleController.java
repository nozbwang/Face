package com.zbwang.face.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.domain.Attach;
import com.zbwang.face.domain.AttachLink;
import com.zbwang.face.domain.Voice;
import com.zbwang.face.service.IAttachLinkService;
import com.zbwang.face.service.IAttachService;
import com.zbwang.face.service.IVoiceService;

@Controller
@RequestMapping("/treehole")
public class TreeHoleController extends BaseController {
	@Autowired
	private IVoiceService faceVoiceService;
	@Autowired
	private IAttachService faceVoiceAttachService;
	@Autowired
	private IAttachLinkService faceVoiceAttachLinkService;

	@RequestMapping("")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Voice> latestVoiceGroup = faceVoiceService.getVisibleSecret(0, 20, getUser(request).getUserId());
		List<Integer> voiceIdGroup = new ArrayList<Integer>();
		for (Voice faceVoice : latestVoiceGroup) {
			voiceIdGroup.add(faceVoice.getVoiceId());
		}
		Map<String, List<Attach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(voiceIdGroup);
		Map<String, List<AttachLink>> faceVoiceAttachLinkMap = faceVoiceAttachLinkService
				.getAttachLinkByVoiceIdGroup(voiceIdGroup);
		for (Voice faceVoice : latestVoiceGroup) {
			faceVoice.setFaceVoiceAttachs(faceVoiceAttachMap.get(String.valueOf(faceVoice.getVoiceId())));
			faceVoice.setFaceVoiceAttachLinks(faceVoiceAttachLinkMap.get(String.valueOf(faceVoice.getVoiceId())));
		}
		return getBaseModelAndView(latestVoiceGroup, "treehole/index", request);
	}

	@RequestMapping("/insert")
	public ModelAndView addBookVoice(HttpServletRequest request) {
		return getBaseModelAndView("treehole/voice_add", request);
	}

}
