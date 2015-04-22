package com.ktds.christof_kim.bbs.service;

import java.util.List;

import com.ktds.christof_kim.bbs.vo.BoardVO;

public interface BoardService {
	
	/**
	 * �Խñ��� ����.
	 * @param boardVO
	 * @return ���� ���µ� �����ϸ� true, �����ϸ� false
	 */
	public boolean writeBoard(BoardVO boardVO);
	/**
	 * �Խñ��� ��� ����Ʈ�� ����.
	 * @return �Խñ��� ������ ��� �Խñ��� ����Ʈ�� ����
	 */
	public List<BoardVO> boardAllList();
	/**
	 * Ư�� �Խñ��� ������ ����.
	 * ����, ����, ���ε� ���� ������ �����ش�.
	 * @param boardId
	 * @return BoardVO(����, ����, ���ε�)
	 */
	public BoardVO getBoardDetail(String boardId);
}
