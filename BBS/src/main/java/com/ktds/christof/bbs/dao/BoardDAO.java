package com.ktds.christof.bbs.dao;

import java.util.List;

import com.ktds.christof.bbs.vo.ArticleVO;

public interface BoardDAO {
	/**
	 * 게시물을 적는다
	 */
	public void writeArticle(ArticleVO articleVO);
	public List<ArticleVO> articleList();
	public ArticleVO articleDetail(int articleId);
	public String modifyArticle(ArticleVO articleVO);
	public void deleteArticle(int articleId);
}
