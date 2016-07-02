package com.zbwang.face.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.dao.FaceBookDao;
import com.zbwang.face.domain.FaceBook;
import com.zbwang.face.service.FaceBookService;

@Service
public class FaceBookServiceImpl implements FaceBookService {
	@Autowired
	private FaceBookDao faceBookDao;

	@Override
	public int insertBook(Integer userId, Map<String, Object> elements) {
		FaceBook faceBook = new FaceBook();
		faceBook.setBookTitle((String) elements.get("bookTitle"));
		faceBook.setAuthor((String) elements.get("author"));
		faceBook.setBookDetail((String) elements.get("bookDetail"));
		faceBook.setBookType((String) elements.get("bookType"));
		faceBook.setUserId(userId);
		return faceBookDao.insertBook(faceBook);
	}

	@Override
	public List<FaceBook> getLatestBook(int startRow, int endRow, String bookType) {
		return faceBookDao.getLatestBook(startRow, endRow, bookType);
	}

	@Override
	public FaceBook getBookById(Integer bookId) {
		return faceBookDao.getBookById(bookId);
	}

}
