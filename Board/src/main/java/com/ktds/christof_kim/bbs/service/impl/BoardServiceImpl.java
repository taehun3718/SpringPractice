package com.ktds.christof_kim.bbs.service.impl;

import java.util.List;

import com.ktds.christof_kim.bbs.dao.BoardDAO;
import com.ktds.christof_kim.bbs.service.BoardService;
import com.ktds.christof_kim.bbs.vo.BoardVO;

public class BoardServiceImpl implements BoardService{

	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public boolean writeArticle(BoardVO boardVO) {
		
		System.out.println("serviceImpl : " + boardVO);
		return boardDAO.writeArticle(boardVO);
	}
	
	@Override
	public List<BoardVO> articleAllList() {
		return boardDAO.articleAllList();
	}
	
	@Override
	public BoardVO getArticleDetailById(String articleId) {
		return boardDAO.getArticleDetailById(articleId);
	}
	
	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardDAO.updateBoard(boardVO);
	}
	
	@Override
	public boolean deleteArticle(int articleId) {
		return boardDAO.deleteArticle(articleId);
	}
}
