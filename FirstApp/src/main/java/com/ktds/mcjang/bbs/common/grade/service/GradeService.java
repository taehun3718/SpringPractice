package com.ktds.mcjang.bbs.common.grade.service;

import java.util.List;

import com.ktds.mcjang.bbs.common.grade.vo.GradeInfoVO;

public interface GradeService {

	/**
	 * 등급을 데이터베이스에 삽입한다.<br/> 
	 * 만약 등급이 올바르게 삽입됬다면, TRUE를 리턴하고<br/>
	 * 그렇지 않으면 FALSE를 리턴한다.
	 * @return 등급이 삽입이 올바르게 됬는지의 boolean 타입
	 */
	public boolean insertGrade(GradeInfoVO gradeInfoVO);
	/**
	 * 모든 등급을 선택한다.
	 * @return 모든 등급 리스트
	 */
	public List<GradeInfoVO> selectAllGrade();
	
}
