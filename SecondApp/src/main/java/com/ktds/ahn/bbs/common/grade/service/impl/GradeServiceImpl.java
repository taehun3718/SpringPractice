package com.ktds.ahn.bbs.common.grade.service.impl;

import java.util.List;

import com.ktds.ahn.bbs.common.grade.dao.GradeDAO;
import com.ktds.ahn.bbs.common.grade.service.GradeService;
import com.ktds.ahn.bbs.common.grade.vo.GradeVO;

public class GradeServiceImpl implements GradeService{

	private GradeDAO gradeDAO; 

	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}

	@Override
	public List<GradeVO> getAllGradeList() {
		return gradeDAO.getAllGradeList();
	}
	
	@Override
	public void writeGrade(GradeVO gradeVO) {
		gradeDAO.writeGrade(gradeVO);
		
	}
	
	@Override
	public void deleteGrade(int gradeIndex) {
		gradeDAO.deleteGrade(gradeIndex);
	}
	
	@Override
	public GradeVO selectGradeInfoById(int gradeIndex) {
		return gradeDAO.selectGradeInfoById(gradeIndex);
	}
	
	@Override
	public void modifyGrade(GradeVO gradeVO) {
		gradeDAO.modifyGrade(gradeVO);
	}
	
	@Override
	public List<GradeVO> getDefaultGrade() {
		return gradeDAO.getDefaultGrade();
	}
	
	@Override
	public List<GradeVO> getMemberGradeList() {
		return gradeDAO.getMemberGradeList();
	}

	@Override
	public boolean isValidGradeByGradeIdx(String tableGrade, String myGrade) {
		List<String> validGradeList =
				this.gradeDAO.getValidGradeByGradeIdx(Integer.parseInt(tableGrade));
		
		return validGradeList.contains(myGrade);
	}
}
