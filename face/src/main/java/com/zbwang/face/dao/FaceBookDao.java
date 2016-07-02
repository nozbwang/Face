package com.zbwang.face.dao;

import java.util.List;

import com.zbwang.face.domain.FaceBook;

public interface FaceBookDao {

	int insertBook(FaceBook faceBook);

	List<FaceBook> getLatestBook(int startRow, int endRow, String bookType);

	FaceBook getBookById(Integer bookId);

}