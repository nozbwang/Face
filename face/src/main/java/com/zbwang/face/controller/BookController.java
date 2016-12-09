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

import com.zbwang.face.constant.Constants;
import com.zbwang.face.domain.Attach;
import com.zbwang.face.domain.Book;
import com.zbwang.face.domain.Voice;
import com.zbwang.face.service.IAttachService;
import com.zbwang.face.service.IBookService;
import com.zbwang.face.service.IVoiceService;
import com.zbwang.face.util.CommonUtil;
import com.zbwang.face.util.RequestUtil;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController {

	@Autowired
	private IBookService faceBookService;
	@Autowired
	private IVoiceService faceVoiceService;
	@Autowired
	private IAttachService faceVoiceAttachService;

	@RequestMapping("")
	public ModelAndView book(HttpServletRequest request, String catalog) {
		List<Book> latestBookGroup = faceBookService.getLatestBook(0, 20, catalog);
		List<Integer> voiceIdGroup = new ArrayList<Integer>();
		for (Book faceBook : latestBookGroup) {
			voiceIdGroup.add(faceBook.getBookId());
		}
		Map<String, List<Attach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(voiceIdGroup,
				Constants.B_TYPE_BOOK);
		for (Book faceBook : latestBookGroup) {
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
		Book faceBook = faceBookService.getBookById(NumberUtils.toInt(request.getParameter("bookId")));
		List<Integer> bookIdGroup = new ArrayList<Integer>();
		bookIdGroup.add(faceBook.getBookId());
		Map<String, List<Attach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(bookIdGroup,
				Constants.B_TYPE_BOOK);
		faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getBookId(), faceVoiceAttachMap));
		List<Voice> latestVoiceGroup = faceVoiceService.getLatestVoice(0, 20, Constants.B_TYPE_BOOK,
				faceBook.getBookId());
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
		modelMap.put("book", faceBook);
		return getBaseModelAndView(modelMap, "book/detail_book", request);
	}

	@RequestMapping("/insert")
	public ModelAndView addVoice(HttpServletRequest request) {
		return getBaseModelAndView("book/book_add", request);
	}

	@RequestMapping("/insertBookVoice")
	public ModelAndView addBookVoice(HttpServletRequest request) {
		Book faceBook = faceBookService.getBookById(NumberUtils.toInt(request.getParameter("bookId")));
		List<Integer> bookIdGroup = new ArrayList<Integer>();
		bookIdGroup.add(faceBook.getBookId());
		Map<String, List<Attach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(bookIdGroup,
				Constants.B_TYPE_BOOK);
		faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getBookId(), faceVoiceAttachMap));
		return getBaseModelAndView(faceBook, "book/voice_add_book", request);
	}

	@RequestMapping("/editBookVoice")
	public ModelAndView editBookVoice(HttpServletRequest request) {
		Book faceBook = faceBookService.getBookById(NumberUtils.toInt(request.getParameter("bookId")));
		List<Integer> bookIdGroup = new ArrayList<Integer>();
		bookIdGroup.add(faceBook.getBookId());
		Map<String, List<Attach>> faceVoiceAttachMap = faceVoiceAttachService.getAttachByVoiceIdGroup(bookIdGroup,
				Constants.B_TYPE_BOOK);
		faceBook.setFaceVoiceAttach(CommonUtil.getFirstElement(faceBook.getBookId(), faceVoiceAttachMap));
		Voice faceVoice = faceVoiceService.getVoiceById(NumberUtils.toInt(request.getParameter("voiceId")));
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
