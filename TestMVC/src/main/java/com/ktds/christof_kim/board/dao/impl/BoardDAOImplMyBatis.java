package com.ktds.christof_kim.board.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.christof_kim.board.dao.BoardDAO;
import com.ktds.christof_kim.board.vo.ArticleVO;

public class BoardDAOImplMyBatis extends SqlSessionDaoSupport implements BoardDAO {

	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOImplMyBatis.class);
	
	@Override
	public int writeArticle(ArticleVO articleVO) {
		// boardDAO는namespace를 가진 Mapper중에서
		// insertArticle 이라는 ID를 가진  SQL을 실행!!
		getSqlSession().insert("boardDAO.insertArticle", articleVO);
		//int articleId = getSqlSession().selectOne("boardDAO.getWritedArticleID");
		return articleVO.getId();
	}

	@Override
	public ArticleVO readArticleById(int id) {
		ArticleVO article = getSqlSession().selectOne("boardDAO.getArticleInfoById", id);
		return article;
	}

	@Override
	public List<ArticleVO> getAllArticleList() {
		List<ArticleVO> articleList = getSqlSession().selectList("boardDAO.getAllArticleInfo");
		return articleList;
	}

	@Override
	public void deleteArticleById(int id) {
		getSqlSession().delete("boardDAO.deleteArticleInfoById", id);
		logger.info("삭제 완료");
	}

	@Override
	public void updateArticle(Map<String, Object> params) {
		getSqlSession().update("boardDAO.updateArticleInfoById", params);
		logger.info("업데이트 완료");
	}
}
