package com.ktds.christof_kim.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.christof_kim.bbs.dao.BoardDAO;
import com.ktds.christof_kim.bbs.vo.BoardVO;

public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO {
	
	@Override
	public boolean writeArticle(BoardVO boardVO) {
		
		int insertCnt = getSqlSession()
				.insert("boardDAO.insertArticle", boardVO);
		return insertCnt > 0;
	}
	
	@Override
	public List<BoardVO> articleAllList() {
		List<BoardVO> boardList = getSqlSession().selectList("boardDAO.getAllArticleList");
		return boardList;
		
	}
	
	@Override
	public BoardVO getArticleDetailById(String boardId) {
		
		BoardVO boardVO = getSqlSession().selectOne("boardDAO.getDetailArticleById", boardId);
		return boardVO;
	}
	
	@Override
	public int updateBoard(BoardVO boardVO) {
		int updatedCnt = getSqlSession().update("boardDAO.updateArticleById", boardVO);
		return updatedCnt>0 ? boardVO.getId() : updatedCnt; 
	}
	
	@Override
	public boolean deleteArticle(int articleId) {
		int deletedCNT = getSqlSession().delete("boardDAO.deleteArticleById", articleId);
		return deletedCNT>0 ? true : false;
	}
}
