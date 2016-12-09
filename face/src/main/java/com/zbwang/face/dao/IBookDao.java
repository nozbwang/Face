package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.Book;

public interface IBookDao {

	int insertBook(Book faceBook);

	List<Book> getLatestBook(int startRow, int endRow, String bookType);

	Book getBookById(Integer bookId);

}