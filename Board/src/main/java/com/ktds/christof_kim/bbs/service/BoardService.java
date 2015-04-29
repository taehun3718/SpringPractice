package com.ktds.christof_kim.bbs.service;

import java.util.List;

import com.ktds.christof_kim.bbs.vo.BoardVO;

public interface BoardService {
	
	/**
	 * �Խñ��� ����.
	 * @param boardVO
	 * @return ���� ���µ� �����ϸ� true, �����ϸ� false
	 */
	public boolean writeArticle(BoardVO boardVO);
	/**
	 * �Խñ��� ��� ����Ʈ�� ����.
	 * @return �Խñ��� ������ ��� �Խñ��� ����Ʈ�� ����
	 */
	public List<BoardVO> articleAllList();
	/**
	 * Ư�� �Խñ��� ������ ����.
	 * ����, ����, ���ε� ���� ������ �����ش�.
	 * @param boardId
	 * @return BoardVO(����, ����, ���ε�)
	 */
	public BoardVO getArticleDetailById(String articleId);
	/**
	 * Ư�� �Խñ��� ������ �����Ѵ�.
	 * ���� ������ ������ �Խñ� id�� �����ϰ� �׷��� ������ 0�� �����Ѵ�.
	 * @param boardVO
	 * @return int(�Խñ� ��ȣ)
	 */
	public int updateBoard(BoardVO boardVO);
	/**
	 * Ư�� �Խñ��� �����Ѵ�.
	 * @param boardVO
	 * @return
	 */
	public boolean deleteArticle(int articleId);
	/**
	 * Ư�� �Խñ��� ������ ��� �����´�.
	 * @param articleId
	 * @return
	 */
	public BoardVO getFileInfo(String articleId);
}
