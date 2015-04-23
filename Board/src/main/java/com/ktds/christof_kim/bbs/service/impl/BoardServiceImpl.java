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
	public boolean writeBoard(BoardVO boardVO) {
		
		System.out.println("serviceImpl : " + boardVO);
		return boardDAO.writeBoard(boardVO);
	}
	
	@Override
	public List<BoardVO> boardAllList() {
		return boardDAO.boardAllList();
	}
	
	@Override
	public BoardVO getBoardDetail(String boardId) {
		return boardDAO.getBoardDetail(boardId);
	}
	
	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardDAO.updateBoard(boardVO);
	}
}
