package com.ktds.christof_kim.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ktds.christof_kim.board.dao.BoardDAO;
import com.ktds.christof_kim.board.service.BoardService;
import com.ktds.christof_kim.board.vo.ArticleVO;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public int writeArticle(ArticleVO articleVO) {
		String articleContent = articleVO.getContent();
		articleContent = articleContent.replaceAll("\n","<br/>").replaceAll("\r", "");
		articleVO.setContent(articleContent);
		return boardDAO.writeArticle(articleVO);
	}

	@Override
	public ArticleVO readArticleById(int id) {
		return boardDAO.readArticleById(id);
	}

	@Override
	public List<ArticleVO> getAllArticleList() {
		return boardDAO.getAllArticleList();
	}

	@Override
	public void deleteArticleById(int id) {
		boardDAO.deleteArticleById(id);
	}

	@Override
	public void updateArticle(ArticleVO articleVO) {
		
		String articleContent = articleVO.getContent();
		articleContent = articleContent.replaceAll("\n","<br/>").replaceAll("\r", "");
		articleVO.setContent(articleContent);
		
		/*
		 * 업데이트 하기 이전에 Database에 있는 원본 데이터를 가지고 온다.
		 */
		ArticleVO originalArticleInfo = boardDAO.readArticleById(articleVO.getId());
		/*
		 *  DAO에 전달해줄 Map 객체 하나를 만든다.
		 *  이 객체에 업데이트할 항목만 넣는다.
		 */
		Map<String, Object> params = new HashMap<String, Object>();
		
		/*
		 * 원본 데이터의 제목과 업데이트할 제목이 다른지 확인한다.
		 */
		if(!articleVO.getSubject().equals(
				//제목이 다르다면 Map 객체에 넣는다.
				originalArticleInfo.getSubject())) {
			params.put("subject", articleVO.getSubject());
		}
		
		params.put("id", articleVO.getId());
		/*
		 *  원본 데이터의 내용과 업데이트할 내용이 다른지확인한다.
		 */

		if(!articleVO.getContent().equals(
				originalArticleInfo.getContent())) {
			//내용이 다르다면 Map 객체에 넣는다.
			params.put("content", articleVO.getContent());
		}
		
		/*
		 * 업데이트할 항목이 하나 이상인지 확인한다.
		 */
		if(params.size() > 1){
			//업데이트할 항목이 있다면 DAO를 호출한다.
			boardDAO.updateArticle(params);
		}
		
		
	}

}
