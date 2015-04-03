package com.ktds.christof_kim.board.dao;

import java.util.List;

import com.ktds.christof_kim.board.vo.ArticleVO;

public interface BoardDAO {

	/**
	 * 게시글을 등록한다.
	 * 
	 * @param articleVO (게시글 작성 정보)
	 * @return int (게시글 번호)
	 */
	
	public int writeArticle(ArticleVO articleVO);
	/**<pre>
	 * ID로 게시글 정보를 가져온다.
	 * 게시글 정보 : 게시글 아이디, 게시글 제목, 게시글 내용.
	 * </pre>
	 * @param id(게시글 아이디)
	 * @return ArticleVO (게시글 정보)
	 */
	public ArticleVO readArticleById(int id);
	
	/**
	 * 모든 게시글을 가져온다. <br/>
	 * 단, 페이징 처리는 하지 않는다. 
	 * @return List<ArticleVO> (모든 게시물)
	 */
	public List<ArticleVO> getAllArticleList();
	
}
