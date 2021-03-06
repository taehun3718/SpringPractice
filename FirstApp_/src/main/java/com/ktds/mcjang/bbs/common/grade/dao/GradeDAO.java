package com.ktds.mcjang.bbs.common.grade.dao;

import java.util.List;

import com.ktds.mcjang.bbs.common.grade.vo.GradeInfoVO;

public interface GradeDAO {

	/**
	 * 데이터베이스에서 회원 등급을 넣는다.<br/>
	 * 만약 회원 등급을 넣은 결과(1건)가 있다면 TRUE<br/>
	 * 그렇지 않다면 FALSE를 리턴한다. 
	 * 
	 * @return 1건일경우 true 0건일 경우 false
	 */
	public boolean insertGrade(GradeInfoVO gradeInfoVO);
	/**
	 * 데이터베이스에서 회원등급을 모두 선택한다.
	 * List를 리턴한다.
	 * @return
	 */
	public List<GradeInfoVO> selectAllGrade();
}
