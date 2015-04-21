package com.ktds.ahn.bbs.board.dao;

import java.util.List;
import java.util.Map;

import com.ktds.ahn.bbs.board.vo.ArticleVO;

public interface BoardDAO {

	boolean isValidAuthorization(Map<String, String> param);

	void writeArticle(Map<String, Object> param);

	List<ArticleVO> getAllArticleList(Map<String, String> param);

	ArticleVO getFileInfo(Map<String, Object> param);

	ArticleVO getArticleInfoById(Map<String, Object> param);
}
