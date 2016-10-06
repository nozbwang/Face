package com.zbwang.face.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zbwang.face.constant.FaceConstants;
import com.zbwang.face.domain.FaceBook;
import com.zbwang.face.domain.FaceVoice;
import com.zbwang.face.domain.FaceVoiceAttach;
import com.zbwang.face.service.FaceBookService;
import com.zbwang.face.service.FaceVoiceAttachService;
import com.zbwang.face.service.FaceVoiceService;
import com.zbwang.face.util.CommonUtil;
import com.zbwang.face.util.RequestUtil;

@Controller
@RequestMapping("/book")
public class FaceBookController extends BaseController {

	@Autowired
	private FaceBookService faceBookService;
	@Autowired
	private FaceVoiceService faceVoiceService;
	@Autowired
	private FaceVoiceAttachService faceVoiceAttachService;

	@RequestMapping("")
	public ModelAndView book(HttpServletRequest request, String catalog) {
		List<FaceBook> latestBookGroup = faceBookService.getLatestBook(0, 20, catalog);
		List<Integer> voiceIdGroup = new ArrayList<Integer>();
		for (FaceBook faceBook : latestBookGroup) {
			voiceIdGroup.add(faceBook.getBookId());
		}
		Map<String, List<FaceVoiceAttach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(voiceIdGroup,
				FaceConstants.B_TYPE_BOOK);
		for (FaceBook faceBook : latestBookGroup) {
			faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getBookId(), faceVoiceAttachMap));
		}
		return getBaseModelAndView(latestBookGroup, "book/index_book", request);
	}

	@RequestMapping("/read/{catalogName}")
	public ModelAndView bookCatalog(HttpServletRequest request, @PathVariable String catalogName) {
		return book(request, CommonUtil.getBookCatalog(catalogName));
	}

	@RequestMapping("/detail")
	public ModelAndView bookDetail(HttpServletRequest request) {
		FaceBook faceBook = faceBookService.getBookById(NumberUtils.toInt(request.getParameter("bookId")));
		List<Integer> bookIdGroup = new ArrayList<Integer>();
		bookIdGroup.add(faceBook.getBookId());
		Map<String, List<FaceVoiceAttach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(bookIdGroup,
				FaceConstants.B_TYPE_BOOK);
		faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getBookId(), faceVoiceAttachMap));
		List<FaceVoice> latestVoiceGroup = faceVoiceService.getLatestVoice(0, 20, FaceConstants.B_TYPE_BOOK,
				faceBook.getBookId());
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
		modelMap.put("book", faceBook);
		return getBaseModelAndView(modelMap, "book/detail_book", request);
	}

	@RequestMapping("/insert")
	public ModelAndView addVoice(HttpServletRequest request) {
		return getBaseModelAndView("book/book_add", request);
	}

	@RequestMapping("/insertBookVoice")
	public ModelAndView addBookVoice(HttpServletRequest request) {
		FaceBook faceBook = faceBookService.getBookById(NumberUtils.toInt(request.getParameter("bookId")));
		List<Integer> bookIdGroup = new ArrayList<Integer>();
		bookIdGroup.add(faceBook.getBookId());
		Map<String, List<FaceVoiceAttach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(bookIdGroup,
				FaceConstants.B_TYPE_BOOK);
		faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getBookId(), faceVoiceAttachMap));
		return getBaseModelAndView(faceBook, "book/voice_add_book", request);
	}

	@RequestMapping("/editBookVoice")
	public ModelAndView editBookVoice(HttpServletRequest request) {
		FaceBook faceBook = faceBookService.getBookById(NumberUtils.toInt(request.getParameter("bookId")));
		List<Integer> bookIdGroup = new ArrayList<Integer>();
		bookIdGroup.add(faceBook.getBookId());
		Map<String, List<FaceVoiceAttach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(bookIdGroup,
				FaceConstants.B_TYPE_BOOK);
		faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getBookId(), faceVoiceAttachMap));
		FaceVoice faceVoice = faceVoiceService.getVoiceById(NumberUtils.toInt(request.getParameter("voiceId")));
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("faceBook", faceBook);
		modelMap.put("faceVoice", faceVoice);
		return getBaseModelAndView(modelMap, "book/voice_edit_book", request);
	}

	@SuppressWarnings("unused")
	@RequestMapping("/insertBook")
	public ModelAndView insertBook(HttpServletRequest request) throws Exception {
		Map<String, Object> elements = RequestUtil.getElements(request);
		Integer userId = getUser(request).getUserId();
		if (!elements.isEmpty()) {
			int bookId = faceBookService.insertBook(getUser(request).getUserId(), elements);
			faceVoiceAttachService.insertLocalPicture(userId, elements, bookId);
			int remotePictureId = faceVoiceAttachService.insertPictureFromRemote(userId, elements, bookId);
		}
		return getBaseModelAndView(getRedirectView("/book"), request);
	}

}
