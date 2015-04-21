package com.ktds.ahn.bbs.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ktds.ahn.bbs.board.dao.BoardDAO;
import com.ktds.ahn.bbs.board.service.BoardService;
import com.ktds.ahn.bbs.board.vo.ArticleVO;
import com.ktds.ahn.bbs.member.dao.MemberDAO;
import com.ktds.ahn.bbs.member.vo.MemberInfoVO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO;
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public BoardDAO getBoardDAO() {
		return boardDAO;
	}

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public boolean isValidAuthorization(String memberId) {
		
		MemberInfoVO memberInfo = this.memberDAO.getMemberInfoById(memberId);
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("gradeId", memberInfo.getUserGrade());
		
		boolean isValidAuthorization = this.boardDAO.isValidAuthorization(param);
		
		if ( !isValidAuthorization ) {
			return false;
		}
		else {
			if ( memberInfo.getUserGrade().equals("4") ) {
				param = new HashMap<String, String>();
				param.put("gradeId", memberInfo.getUserSecondGrade());
				isValidAuthorization = this.boardDAO.isValidAuthorization(param);
			}
			return isValidAuthorization;
		}
	}
	
	@Override
	public void writeArticle(ArticleVO articleVO) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("articleVO", articleVO);
		
		this.boardDAO.writeArticle(param);
	}
	
	@Override
	public List<ArticleVO> getAllArticleList() {
		Map<String, String> param = new HashMap<String, String>();
		return this.boardDAO.getAllArticleList(param);
	}
	
	@Override
	public ArticleVO getFileInfo(int articleId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("articleId", articleId);
		return this.boardDAO.getFileInfo(param);
	}
	
	@Override
	public ArticleVO getArticleInfoById(int articleId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("articleId", articleId);
		return this.boardDAO.getArticleInfoById(param);
	}
}