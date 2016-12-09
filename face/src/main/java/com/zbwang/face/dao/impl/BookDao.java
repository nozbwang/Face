package com.zbwang.face.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.IBookDao;
import com.zbwang.face.domain.Book;

@Repository
public class BookDao extends BaseDao implements IBookDao {

	@Override
	public int insertBook(Book faceBook) {
		return (Integer) getSqlMapClientTemplate().insert("face_book.insertBook", faceBook);
	}

	@Override
	public List<Book> getLatestBook(int startRow, int endRow, String bookType) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		paramMap.put("bookType", bookType);
		return (List<Book>) getSqlMapClientTemplate().queryForList("face_book.getBookByType", paramMap);
	}

	@Override
	public Book getBookById(Integer bookId) {
		return (Book) getSqlMapClientTemplate().queryForObject("face_book.getBookById", bookId);
	}

}
