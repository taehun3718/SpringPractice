package com.ktds.christof_kim.bbs.service;

import java.util.List;

import com.ktds.christof_kim.bbs.vo.BoardVO;

public interface BoardService {
	
	/**
	 * 게시글을 쓴다.
	 * @param boardVO
	 * @return 글을 쓰는데 성공하면 true, 실패하면 false
	 */
	public boolean writeBoard(BoardVO boardVO);
	/**
	 * 게시글의 모든 리스트를 본다.
	 * @return 게시글이 있으면 모든 게시글의 리스트를 리턴
	 */
	public List<BoardVO> boardAllList();
	/**
	 * 특정 게시글의 정보를 본다.
	 * 제목, 내용, 업로드 파일 정보를 보여준다.
	 * @param boardId
	 * @return BoardVO(제목, 내용, 업로드)
	 */
	public BoardVO getBoardDetail(String boardId);
	/**
	 * 특정 게시글의 내용을 수정한다.
	 * 수정 성공시 성공된 게시글 id를 리턴하고 그렇지 않으면 0을 리턴한다.
	 * @param boardVO
	 * @return int(게시글 번호)
	 */
	public int updateBoard(BoardVO boardVO);
}
