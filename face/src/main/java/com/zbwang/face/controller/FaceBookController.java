package com.zbwang.face.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.domain.FaceBook;
import com.zbwang.face.domain.FaceVoiceAttach;
import com.zbwang.face.service.FaceBookService;
import com.zbwang.face.service.FaceVoiceAttachService;
import com.zbwang.face.util.CommonUtil;
import com.zbwang.face.util.RequestUtil;

@Controller
@RequestMapping("/book")
public class FaceBookController extends BaseController {

	@Autowired
	private FaceBookService faceBookService;
	@Autowired
	private FaceVoiceAttachService faceVoiceAttachService;

	@RequestMapping("")
	public ModelAndView book(HttpServletRequest request, String catalog) {
		List<FaceBook> latestBookGroup = faceBookService.getLatestBook(0, 20, catalog);
		List<Integer> voiceIdGroup = new ArrayList<Integer>();
		for (FaceBook faceBook : latestBookGroup) {
			voiceIdGroup.add(faceBook.getBookId());
		}
		Map<String, List<FaceVoiceAttach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(voiceIdGroup);
		for (FaceBook faceBook : latestBookGroup) {
			faceBook.setFaceVoiceAttachs(faceVoiceAttachMap.get(String.valueOf(faceBook.getBookId())));
		}
		return getBaseModelAndView(latestBookGroup, "index_book", request);
	}

	@RequestMapping("/read/{catalogName}")
	public ModelAndView bookCatalog(HttpServletRequest request, @PathVariable String catalogName) {
		return book(request, CommonUtil.getBookCatalog(catalogName));
	}

	@RequestMapping("/insert")
	public ModelAndView addVoice(HttpServletRequest request) {
		return getBaseModelAndView("book_add", request);
	}

	@RequestMapping("/insertBook")
	public ModelAndView insertBook(HttpServletRequest request) throws Exception {
		Map<String, Object> elements = RequestUtil.getElements(request);
		Integer userId = getUser(request).getUserId();
		if (!elements.isEmpty()) {
			int bookId = faceBookService.insertBook(getUser(request).getUserId(), elements);
			int localPictureId = faceVoiceAttachService.insertLocalPicture(userId, elements, bookId);
			int remotePictureId = faceVoiceAttachService.insertPictureFromRemote(userId, elements, bookId);
			// sendVoiceNoticeMail((String) elements.get("voice"),
			// localPictureId, remotePictureId);
		}
		return getBaseModelAndView(getRedirectView("/book"), request);
	}

}
