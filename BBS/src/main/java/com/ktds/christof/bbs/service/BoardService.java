package com.ktds.christof.bbs.service;

import java.util.List;

import com.ktds.christof.bbs.vo.ArticleVO;

public interface BoardService {

	/**
	 * �Խù��� ���´�
	 */
	public void writeArticle(ArticleVO articleVO);
	public List<ArticleVO> articleList();
	public ArticleVO articleDetail(int boardId);
	public String modifyArticle(ArticleVO articleVO);
	public void deleteArticle(int articleId);
	
}
