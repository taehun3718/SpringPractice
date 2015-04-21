package com.ktds.ahn.bbs.common.grade.service;

import java.util.List;

import com.ktds.ahn.bbs.common.grade.vo.GradeVO;

public interface GradeService {

	public List<GradeVO> getAllGradeList();

	public void writeGrade(GradeVO gradeVO);

	public void deleteGrade(int gradeIndex);

	public GradeVO selectGradeInfoById(int gradeIndex);

	public void modifyGrade(GradeVO gradeVO);

	public List<GradeVO> getDefaultGrade();

	public List<GradeVO> getMemberGradeList();
	
	public boolean isValidGradeByGradeIdx(String tableGrade, String myGrade);

}
