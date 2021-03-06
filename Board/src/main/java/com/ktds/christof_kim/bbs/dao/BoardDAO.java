package com.ktds.christof_kim.bbs.dao;

import java.util.List;

import com.ktds.christof_kim.bbs.vo.BoardVO;

public interface BoardDAO {

	/**
	 * <pre>
	 * 	writeArticle : 데이터베이스에서 글을 insert한다.
	 * 	글을 입력하면 1건의 결과가 리턴되면 true
	 * 	만약 실패하면 0건의 결과가 리턴되므로 false를 리턴
	 * </pre>
	 * @param boardVO
	 * @return
	 */
	public boolean writeArticle(BoardVO boardVO);
	/**
	 * <pre>
	 * articleAllList : 데이터베이스에서 모든 글 리스트를 불러온다.
	 * 게시글은 Map Type으로 받아 리스트로 리턴하는 방식이다.
	 * com.ktds.christof_kim.dao.impl.sql.boardDAO.xml
	 * </pre>
	 * @see com.ktds.christof_kim.bbs.dao.impl.sql
	 * @return 모근 게시글 리스트
	 *
	 */
	public List<BoardVO> articleAllList();
	/**
	 * <pre>
	 * getArticleDetailById : 데이터베이스에서 특정 글 세부정보를 불러온다.
	 * 게시글은 BoardVO 타입으로리턴하는 방식이다.
	 * com.ktds.christof_kim.dao.impl.sql.boardDAO.xml
	 * </pre>
	 * @see com.ktds.christof_kim.bbs.dao.impl.sql
	 * @return 제목, 내용, 업로드된 파일
	 *
	 */
	public BoardVO getArticleDetailById(String boardId);
	/**
	 * 특정 게시글의 번호를 업데이트 한다.
	 * 성공할 경우 데이터베이스에서 업데이트를 수행한다.
	 * @param boardVO
	 * @return
	 */
	public int updateBoard(BoardVO boardVO);
	/**
	 * 특정 게시글의 번호를 삭제한다.
	 * 성공할 경우 데이터베이스에서 게시글을 삭제한다.
	 * @param articleId
	 * @return 삭제 여부(성공시 true, 실패시 false)
	 */
	public boolean deleteArticle(int articleId);

}
