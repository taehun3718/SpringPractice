package com.ktds.mcjang.bbs.board.dao.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.mcjang.bbs.board.dao.AutoCreateDAO;
import com.ktds.mcjang.bbs.board.vo.BoardVO;

public class AutoCreateDAOImpl extends SqlSessionDaoSupport implements AutoCreateDAO {
	@Override
	public void createBoardSequence(Map<String, String> param) {
		
	}@Override
	public void createBoardTable(Map<String, String> param) {
		
		
		getSqlSession().insert("autoCreate.createBoardTableStep1", param);
		getSqlSession().insert("autoCreate.createBoardTableStep2", param);
		getSqlSession().insert("autoCreate.createBoardTableStep3", param);
		
	}
	
	public void createReplyTable(Map<String, String> param) {
		getSqlSession().insert("autoCreate.createReplyTableStep1", param);
		getSqlSession().insert("autoCreate.createReplyTableStep2", param);
		getSqlSession().insert("autoCreate.createReplyTableStep3", param);
		
	}
	
	@Override
	public void createReplySequence(Map<String, String> param) {
		getSqlSession().insert("autoCreate.createSeqStep1", param);
		getSqlSession().insert("autoCreate.createSeqStep2", param);
		
	}
	
	@Override
	public void insertNewTableInfoWithReplyTable(BoardVO boardVO) {
		getSqlSession().insert("autoCreate.insertNewTableInfo", boardVO);
		getSqlSession().insert("autoCreate.insertNewReplyTableInfo", boardVO);
		
	}
	
	@Override
	public void insertNewTableInfoWithoutReplyTable(BoardVO boardVO) {
		getSqlSession().insert("autoCreate.insertNewTableInfo", boardVO);
	}

}
