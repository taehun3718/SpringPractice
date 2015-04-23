package com.ktds.christof_kim.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.christof_kim.bbs.dao.BoardDAO;
import com.ktds.christof_kim.bbs.vo.BoardVO;

public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO {
	
	@Override
	public boolean writeBoard(BoardVO boardVO) {
		
		int insertCnt = getSqlSession()
				.insert("boardDAO.insertBoard", boardVO);
		return insertCnt > 0;
	}
	
	@Override
	public List<BoardVO> boardAllList() {
		List<BoardVO> boardList = getSqlSession().selectList("boardDAO.getAllBoardList");
		return boardList;
		
	}
	
	@Override
	public BoardVO getBoardDetail(String boardId) {
		
		BoardVO boardVO = getSqlSession().selectOne("boardDAO.getDetailBoardById", boardId);
		return boardVO;
	}
	
	@Override
	public int updateBoard(BoardVO boardVO) {
		int updatedCnt = getSqlSession().update("boardDAO.updateBoardById", boardVO);
		return updatedCnt>0 ? boardVO.getId() : updatedCnt; 
	}
}
