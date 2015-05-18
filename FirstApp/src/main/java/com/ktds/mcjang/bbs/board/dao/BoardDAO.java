package com.ktds.mcjang.bbs.board.dao;

import java.util.List;
import java.util.Map;

import com.ktds.mcjang.bbs.board.vo.ArticleVO;
import com.ktds.mcjang.bbs.board.vo.BoardVO;

public interface BoardDAO {

	boolean isExistTable(String tableName);

	boolean isValidAuthorization(Map<String, String> param);

	void writeArticle(Map<String, Object> param);

	ArticleVO getFileInfo(Map<String, Object> param);

	List<BoardVO> getTableList(Map<String, Object> param);

	BoardVO getArticleById(Map<String, Object> param);

}
