package com.ktds.christof_kim.bbs.dao;

import java.util.List;

import com.ktds.christof_kim.bbs.vo.BoardVO;

public interface BoardDAO {

	/**
	 * <pre>
	 * 	writeArticle : �����ͺ��̽����� ���� insert�Ѵ�.
	 * 	���� �Է��ϸ� 1���� ����� ���ϵǸ� true
	 * 	���� �����ϸ� 0���� ����� ���ϵǹǷ� false�� ����
	 * </pre>
	 * @param boardVO
	 * @return
	 */
	public boolean writeArticle(BoardVO boardVO);
	/**
	 * <pre>
	 * articleAllList : �����ͺ��̽����� ��� �� ����Ʈ�� �ҷ��´�.
	 * �Խñ��� Map Type���� �޾� ����Ʈ�� �����ϴ� ����̴�.
	 * com.ktds.christof_kim.dao.impl.sql.boardDAO.xml
	 * </pre>
	 * @see com.ktds.christof_kim.bbs.dao.impl.sql
	 * @return ��� �Խñ� ����Ʈ
	 *
	 */
	public List<BoardVO> articleAllList();
	/**
	 * <pre>
	 * getArticleDetailById : �����ͺ��̽����� Ư�� �� ���������� �ҷ��´�.
	 * �Խñ��� BoardVO Ÿ�����θ����ϴ� ����̴�.
	 * com.ktds.christof_kim.dao.impl.sql.boardDAO.xml
	 * </pre>
	 * @see com.ktds.christof_kim.bbs.dao.impl.sql
	 * @return ����, ����, ���ε�� ����
	 *
	 */
	public BoardVO getArticleDetailById(String boardId);
	/**
	 * Ư�� �Խñ��� ��ȣ�� ������Ʈ �Ѵ�.
	 * ������ ��� �����ͺ��̽����� ������Ʈ�� �����Ѵ�.
	 * @param boardVO
	 * @return
	 */
	public int updateBoard(BoardVO boardVO);
	/**
	 * Ư�� �Խñ��� ��ȣ�� �����Ѵ�.
	 * ������ ��� �����ͺ��̽����� �Խñ��� �����Ѵ�.
	 * @param articleId
	 * @return ���� ����(������ true, ���н� false)
	 */
	public boolean deleteArticle(int articleId);

}
