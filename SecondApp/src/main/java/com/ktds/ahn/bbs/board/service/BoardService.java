package com.ktds.ahn.bbs.board.service;

import java.util.List;

import com.ktds.ahn.bbs.board.vo.ArticleVO;
import com.ktds.ahn.bbs.board.vo.BoardVO;

public interface BoardService {

	public boolean isValidAuthorization(String memberId);
	public void writeArticle(ArticleVO articleVO);
	public List<ArticleVO> getAllArticleList();
	public ArticleVO getFileInfo(int articleId);
	public ArticleVO getArticleInfoById(int articleId);
	
}