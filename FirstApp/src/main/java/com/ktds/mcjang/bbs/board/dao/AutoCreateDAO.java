package com.ktds.mcjang.bbs.board.dao;

import java.util.Map;

import com.ktds.mcjang.bbs.board.vo.BoardVO;

public interface AutoCreateDAO {

	public void createBoardTable(Map<String, String> param);
	public void createReplyTable(Map<String, String> param);
	public void createBoardSequence(Map<String, String> param);
	public void createReplySequence(Map<String, String> param);
	public void insertNewTableInfoWithoutReplyTable(BoardVO boardVO);
	public void insertNewTableInfoWithReplyTable(BoardVO boardVO);
	
}
