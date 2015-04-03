package com.ktds.christof_kim.board.service.impl;

import java.util.List;

import com.ktds.christof_kim.board.dao.BoardDAO;
import com.ktds.christof_kim.board.service.BoardService;
import com.ktds.christof_kim.board.vo.ArticleVO;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public int writeArticle(ArticleVO articleVO) {
		String articleContent = articleVO.getContent();
		articleContent = articleContent.replaceAll("\n","<br/>");
		articleVO.setContent(articleContent);
		return boardDAO.writeArticle(articleVO);
	}

	@Override
	public ArticleVO readArticleById(int id) {
		return boardDAO.readArticleById(id);
	}

	@Override
	public List<ArticleVO> getAllArticleList() {
		return boardDAO.getAllArticleList();
	}

}
