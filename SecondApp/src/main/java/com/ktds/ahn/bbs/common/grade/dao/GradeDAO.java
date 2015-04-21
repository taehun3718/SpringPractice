package com.ktds.ahn.bbs.common.grade.dao;

import java.util.List;

import com.ktds.ahn.bbs.common.grade.vo.GradeVO;

public interface GradeDAO {

	public List<GradeVO> getAllGradeList();

	public void writeGrade(GradeVO gradeVO);

	public void deleteGrade(int gradeIndex);

	public GradeVO selectGradeInfoById(int gradeIndex);

	public void modifyGrade(GradeVO gradeVO);

	public List<GradeVO> getDefaultGrade();

	public List<GradeVO> getMemberGradeList();
	
	public List<String> getValidGradeByGradeIdx(int tableGrade);

}
