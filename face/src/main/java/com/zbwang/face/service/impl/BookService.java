package com.zbwang.face.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbwang.face.dao.IBookDao;
import com.zbwang.face.domain.Book;
import com.zbwang.face.service.IBookService;

@Service
public class BookService implements IBookService {
	@Autowired
	private IBookDao faceBookDao;

	@Override
	public int insertBook(Integer userId, Map<String, Object> elements) {
		Book faceBook = new Book();
		faceBook.setBookTitle((String) elements.get("bookTitle"));
		faceBook.setAuthor((String) elements.get("author"));
		faceBook.setBookDetail((String) elements.get("bookDetail"));
		faceBook.setBookType((String) elements.get("bookType"));
		faceBook.setUserId(userId);
		return faceBookDao.insertBook(faceBook);
	}

	@Override
	public List<Book> getLatestBook(int startRow, int endRow, String bookType) {
		return faceBookDao.getLatestBook(startRow, endRow, bookType);
	}

	@Override
	public Book getBookById(Integer bookId) {
		return faceBookDao.getBookById(bookId);
	}

}
