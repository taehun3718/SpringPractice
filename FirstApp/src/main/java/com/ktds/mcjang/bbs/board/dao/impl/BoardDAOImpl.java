package com.ktds.mcjang.bbs.board.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.mcjang.bbs.board.dao.BoardDAO;
import com.ktds.mcjang.bbs.board.vo.ArticleVO;
import com.ktds.mcjang.bbs.board.vo.BoardVO;

//OK
public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO {

	@Override
	public boolean isExistTable(String tableName) {
		
		int count 
				= getSqlSession()
				.selectOne("boardDAO.isExistsTable", tableName);
		
		return count>0;
	}
	
	@Override
	public boolean isValidAuthorization(Map<String, String> param) {
		int count 
				= getSqlSession()
				.selectOne("boardDAO.isValidAuthorization",param);
		return count>0;
	}
	
	@Override
	public void writeArticle(Map<String, Object> param) {
		getSqlSession().insert("boardDAO.writeArticle", param);
	}
	
	@Override
	public ArticleVO getFileInfo(Map<String, Object> param) {
		ArticleVO articleVO 
				= getSqlSession()
				.selectOne("boardDAO.getFileInfo", param);
		
		return articleVO;
	}
	
	@Override
	public List<BoardVO> getTableList(Map<String, Object> param) {
		
		List<BoardVO> list = getSqlSession().selectList("boardDAO.getAllArticle", param);
		return list;
		//getAllArticle
	}

	@Override
	public BoardVO getArticleById(Map<String, Object> param) {
		return null;
	}
}
