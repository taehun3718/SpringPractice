package com.ktds.mcjang.bbs.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.mcjang.bbs.board.dao.AutoCreateDAO;
import com.ktds.mcjang.bbs.board.dao.BoardDAO;
import com.ktds.mcjang.bbs.board.service.BoardService;
import com.ktds.mcjang.bbs.board.vo.ArticleVO;
import com.ktds.mcjang.bbs.board.vo.BoardVO;
import com.ktds.mcjang.bbs.member.dao.MemberDAO;
import com.ktds.mcjang.bbs.member.vo.MemberInfoVO;

public class BoardServiceImpl implements BoardService{
	
	private BoardDAO boardDAO;
	private AutoCreateDAO autoCreateDAO;
	private MemberDAO memberDAO;
	private static Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	
	
	public void setAutoCreateDAO(AutoCreateDAO autoCreateDAO) {
		this.autoCreateDAO = autoCreateDAO;
	}
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public void createReplyTableWithReplyTable(BoardVO boardVO) {
		
		Map<String, String> param = new HashMap<String, String>();
		
		logger.info("Board Code : " + boardVO.getBoardCode());
		param.put("tableName", boardVO.getBoardCode());
		logger.info("param      : " + boardVO.getBoardCode());
		
		this.autoCreateDAO.createBoardTable(param);
		this.autoCreateDAO.createReplyTable(param);
		
	}
	
	@Override
	public void createBoardTableWithoutReplyTable(BoardVO boardVO) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("tableName", boardVO.getBoardCode());
		
		this.autoCreateDAO.createBoardTable(param);
		this.autoCreateDAO.insertNewTableInfoWithoutReplyTable(boardVO);
		
	}
	
	@Override
	public void createReplySequenceWithReplySequence(BoardVO boardVO) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("tableName", boardVO.getBoardCode());
		
		this.autoCreateDAO.createBoardSequence(param);
		this.autoCreateDAO.createReplySequence(param);
		this.autoCreateDAO.insertNewTableInfoWithReplyTable(boardVO);
		
	}
	
	@Override
	public void createBoardSequenceWithoutReplySequences(BoardVO boardVO) {
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("tableName", boardVO.getBoardCode());
		
		this.autoCreateDAO.createBoardSequence(param);
		
	}
	
	@Override
	public boolean isExistTable(String tableName) {
		
		return this.boardDAO.isExistTable(tableName);
	}
	
	@Override
	public boolean isValidAuthorization(String tableName, String memberId) {
		
		MemberInfoVO memberInfo 
			= this.memberDAO.getMemberInfoById(memberId);
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("tableName", tableName);
		param.put("gradeId", memberInfo.getUsrGrd());
		
		boolean isValidAuthorization
			=	this.boardDAO.isValidAuthorization(param);
		
		if(!isValidAuthorization){
			return false;
		}
		else {
			
			if(memberInfo.getUsrGrd().equals("4")) {
				
				param = new HashMap<String, String>();
				param.put("tableName", tableName);
				param.put("gradeId",memberInfo.getUsrSndGrd());
				
				isValidAuthorization = this.boardDAO.isValidAuthorization(param);
				return isValidAuthorization;
			}
			return true;
		}
	}
	
	public void writeArticle(String tableName, ArticleVO articleVO) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tableName", tableName);
		param.put("articleVO", articleVO);
		this.boardDAO.writeArticle(param);
	};
	
	@Override
	public ArticleVO getFileInfo(String tableName, int articleId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tableName", tableName);
		param.put("articleId", articleId);
		
		return this.boardDAO.getFileInfo(param);
	}
	
	@Override
	public List<BoardVO> getTableList(String tableName) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tableName", tableName);	
		return this.boardDAO.getTableList(param);
	}



	@Override
	public BoardVO getArticleById(String tableName, int articleId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("tableName", tableName);	
		param.put("articleId", articleId);	
		
		return this.boardDAO.getArticleById(param);
	}
}
