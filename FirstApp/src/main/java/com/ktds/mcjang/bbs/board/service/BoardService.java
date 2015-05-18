package com.ktds.mcjang.bbs.board.service;

import java.util.List;

import com.ktds.mcjang.bbs.board.vo.ArticleVO;
import com.ktds.mcjang.bbs.board.vo.BoardVO;

public interface BoardService {

	public void createBoardTableWithoutReplyTable(BoardVO boardVO);
	public void createReplyTableWithReplyTable(BoardVO boardVO);
	public void createBoardSequenceWithoutReplySequences(BoardVO boardVO);
	public void createReplySequenceWithReplySequence(BoardVO boardVO);
	public boolean isExistTable(String tableName);
	public boolean isValidAuthorization(String tableName, String memberId);
	public void writeArticle(String tableName, ArticleVO articleVO);
	public ArticleVO getFileInfo(String tableName, int articleId);
	public List<BoardVO> getTableList(String tableName);
	public BoardVO getArticleById(String tableName, int articleId);
	
}
