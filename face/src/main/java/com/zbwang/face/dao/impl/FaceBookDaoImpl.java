package com.zbwang.face.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zbwang.face.dao.FaceBookDao;
import com.zbwang.face.domain.FaceBook;

@Repository
public class FaceBookDaoImpl extends BaseDaoImpl implements FaceBookDao {

	@Override
	public int insertBook(FaceBook faceBook) {
		return (Integer) getSqlMapClientTemplate().insert("face_book.insertBook", faceBook);
	}

	@Override
	public List<FaceBook> getLatestBook(int startRow, int endRow, String bookType) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		paramMap.put("bookType", bookType);
		return (List<FaceBook>) getSqlMapClientTemplate().queryForList("face_book.getBookByType", paramMap);
	}

	@Override
	public FaceBook getBookById(Integer bookId) {
		return (FaceBook) getSqlMapClientTemplate().queryForObject("face_book.getBookById", bookId);
	}

}
