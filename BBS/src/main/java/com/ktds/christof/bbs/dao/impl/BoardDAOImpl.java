package com.ktds.christof.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.christof.bbs.dao.BoardDAO;
import com.ktds.christof.bbs.vo.ArticleVO;

public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO{

	@Override
	public void writeArticle(ArticleVO articleVO) {
		getSqlSession().insert("articleDAO.insertArticle", articleVO);
	}

	@Override
	public List<ArticleVO> articleList() {
		return getSqlSession().selectList("articleDAO.getAllArticleList");
	}
	
	@Override
	public ArticleVO articleDetail(int articleId) {
		return getSqlSession().selectOne("articleDAO.getDetailArticleById", articleId);
	}

	@Override
	public String modifyArticle(ArticleVO articleVO) {
		getSqlSession().selectOne("articleDAO.updateArticleById", articleVO);
		return articleVO.getId();
	}
	
	@Override
	public void deleteArticle(int articleId) {
		getSqlSession().selectOne("articleDAO.deleteArticleById", articleId);
	}
}
