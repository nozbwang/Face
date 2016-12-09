package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.Book;

public interface IBookService {

	List<Book> getLatestBook(int startRow, int endRow, String bookType);

	Book getBookById(Integer bookId);

	int insertBook(Integer userId, Map<String, Object> elements);

}
