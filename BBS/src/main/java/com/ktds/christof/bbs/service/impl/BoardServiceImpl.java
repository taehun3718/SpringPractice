package com.ktds.christof.bbs.service.impl;

import java.util.List;

import com.ktds.christof.bbs.dao.BoardDAO;
import com.ktds.christof.bbs.service.BoardService;
import com.ktds.christof.bbs.vo.ArticleVO;

public class BoardServiceImpl implements BoardService{

	private BoardDAO boardDAO;
	
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public void writeArticle(ArticleVO articleVO) {
		boardDAO.writeArticle(articleVO);
	}

	@Override
	public List<ArticleVO> articleList() {
		List<ArticleVO> articleList = boardDAO.articleList();
		return articleList;
	}

	@Override
	public ArticleVO articleDetail(int articleId) {
		return boardDAO.articleDetail(articleId);
	}
	
	@Override
	public String modifyArticle(ArticleVO articleVO) {
		return boardDAO.modifyArticle(articleVO);
	}
	
	@Override
	public void deleteArticle(int articleId) {
		boardDAO.deleteArticle(articleId);
	}
}
