package com.ktds.christof_kim.bbs.dao;

import java.util.List;

import com.ktds.christof_kim.bbs.vo.BoardVO;

public interface BoardDAO {

	/**
	 * <pre>
	 * 	writeBoard : 데이터베이스에서 글을 insert한다.
	 * 	글을 입력하면 1건의 결과가 리턴되면 true
	 * 	만약 실패하면 0건의 결과가 리턴되므로 false를 리턴
	 * </pre>
	 * @param boardVO
	 * @return
	 */
	public boolean writeBoard(BoardVO boardVO);
	/**
	 * <pre>
	 * boardAllList : 데이터베이스에서 모든 글 리스트를 불러온다.
	 * 게시글은 Map Type으로 받아 리스트로 리턴하는 방식이다.
	 * com.ktds.christof_kim.dao.impl.sql.boardDAO.xml
	 * </pre>
	 * @see com.ktds.christof_kim.bbs.dao.impl.sql
	 * @return 모근 게시글 리스트
	 *
	 */
	public List<BoardVO> boardAllList();
	/**
	 * <pre>
	 * boardAllList : 데이터베이스에서 특정 글 세부정보를 불러온다.
	 * 게시글은 BoardVO 타입으로리턴하는 방식이다.
	 * com.ktds.christof_kim.dao.impl.sql.boardDAO.xml
	 * </pre>
	 * @see com.ktds.christof_kim.bbs.dao.impl.sql
	 * @return 제목, 내용, 업로드된 파일
	 *
	 */
	public BoardVO getBoardDetail(String boardId);

}
