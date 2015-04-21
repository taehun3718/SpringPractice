package com.ktds.ahn.bbs.board.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.ahn.bbs.board.dao.BoardDAO;
import com.ktds.ahn.bbs.board.vo.ArticleVO;

public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO{

	
	@Override
	public boolean isValidAuthorization(Map<String, String> param) {
		int count = getSqlSession().selectOne("boardDAO.isValidAuthorization", param);
		return count > 0;
	}
	
	@Override
	public void writeArticle(Map<String, Object> param) {
		getSqlSession().insert("boardDAO.writeArticle", param);
	}
	
	@Override
	public List<ArticleVO> getAllArticleList(Map<String, String> param) {
		return getSqlSession().selectList("boardDAO.getAllArticleList", param);
	}
	
	@Override
	public ArticleVO getFileInfo(Map<String, Object> param) {
		return getSqlSession().selectOne("boardDAO.getFileInfo", param);
	}
	
	@Override
	public ArticleVO getArticleInfoById(Map<String, Object> param) {
		return getSqlSession().selectOne("boardDAO.getArticleInfoById", param);
	}
}
