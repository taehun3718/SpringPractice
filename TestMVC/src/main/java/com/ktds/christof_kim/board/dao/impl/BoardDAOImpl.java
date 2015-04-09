package com.ktds.christof_kim.board.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.christof_kim.board.dao.BoardDAO;
import com.ktds.christof_kim.board.vo.ArticleVO;

public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO {

	
	@Override
	public int writeArticle(ArticleVO articleVO) {
		getSqlSession()
			.insert("com.ktds.christof_kim.board.dao.impl.insertArticle", articleVO);
		return 0;
	}

	@Override
	public ArticleVO readArticleById(int id) {
		
		return null;
	}

	@Override
	public List<ArticleVO> getAllArticleList() {
		return null;
	}

	@Override
	public void deleteArticleById(int id) {
		return;
	}

	@Override
	public void updateArticle(ArticleVO articleVO) {
		
	}

}
