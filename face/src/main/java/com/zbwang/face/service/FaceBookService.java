package com.zbwang.face.service;

import java.util.List;
import java.util.Map;

import com.zbwang.face.domain.FaceBook;

public interface FaceBookService {

	List<FaceBook> getLatestBook(int startRow, int endRow, String bookType);

	FaceBook getBookById(Integer bookId);

	int insertBook(Integer userId, Map<String, Object> elements);

}
