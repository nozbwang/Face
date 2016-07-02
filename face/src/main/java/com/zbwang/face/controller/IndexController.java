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

import com.zbwang.face.domain.FaceVoice;
import com.zbwang.face.domain.FaceVoiceAttach;
import com.zbwang.face.domain.FaceVoiceAttachLink;
import com.zbwang.face.service.FaceBookService;
import com.zbwang.face.service.FaceVoiceAttachLinkService;
import com.zbwang.face.service.FaceVoiceAttachService;
import com.zbwang.face.service.FaceVoiceService;

@Controller
public class IndexController extends BaseController {
	@Autowired
	private FaceVoiceService faceVoiceService;
	@Autowired
	private FaceBookService faceBookService;
	@Autowired
	private FaceVoiceAttachService faceVoiceAttachService;
	@Autowired
	private FaceVoiceAttachLinkService faceVoiceAttachLinkService;

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<FaceVoice> latestVoiceGroup = faceVoiceService.getLatestVoice(0, 20);
		List<Integer> voiceIdGroup = new ArrayList<Integer>();
		for (FaceVoice faceVoice : latestVoiceGroup) {
			voiceIdGroup.add(faceVoice.getVoiceId());
		}
		Map<String, List<FaceVoiceAttach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(voiceIdGroup);
		Map<String, List<FaceVoiceAttachLink>> faceVoiceAttachLinkMap = faceVoiceAttachLinkService
				.getAttachLinkByVoiceIdGroup(voiceIdGroup);
		for (FaceVoice faceVoice : latestVoiceGroup) {
			faceVoice.setFaceVoiceAttachs(faceVoiceAttachMap.get(String.valueOf(faceVoice.getVoiceId())));
			faceVoice.setFaceVoiceAttachLinks(faceVoiceAttachLinkMap.get(String.valueOf(faceVoice.getVoiceId())));
		}
		return getBaseModelAndView(latestVoiceGroup, "index", request);
	}

}
