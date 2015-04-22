package com.ktds.christof_kim.bbs.dao;

import java.util.List;

import com.ktds.christof_kim.bbs.vo.BoardVO;

public interface BoardDAO {

	/**
	 * <pre>
	 * 	writeBoard : �����ͺ��̽����� ���� insert�Ѵ�.
	 * 	���� �Է��ϸ� 1���� ����� ���ϵǸ� true
	 * 	���� �����ϸ� 0���� ����� ���ϵǹǷ� false�� ����
	 * </pre>
	 * @param boardVO
	 * @return
	 */
	public boolean writeBoard(BoardVO boardVO);
	/**
	 * <pre>
	 * boardAllList : �����ͺ��̽����� ��� �� ����Ʈ�� �ҷ��´�.
	 * �Խñ��� Map Type���� �޾� ����Ʈ�� �����ϴ� ����̴�.
	 * com.ktds.christof_kim.dao.impl.sql.boardDAO.xml
	 * </pre>
	 * @see com.ktds.christof_kim.bbs.dao.impl.sql
	 * @return ��� �Խñ� ����Ʈ
	 *
	 */
	public List<BoardVO> boardAllList();
	/**
	 * <pre>
	 * boardAllList : �����ͺ��̽����� Ư�� �� ���������� �ҷ��´�.
	 * �Խñ��� BoardVO Ÿ�����θ����ϴ� ����̴�.
	 * com.ktds.christof_kim.dao.impl.sql.boardDAO.xml
	 * </pre>
	 * @see com.ktds.christof_kim.bbs.dao.impl.sql
	 * @return ����, ����, ���ε�� ����
	 *
	 */
	public BoardVO getBoardDetail(String boardId);

}
