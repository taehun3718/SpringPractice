package com.ktds.mcjang.bbs.common.grade.service.impl;

import java.util.List;

import com.ktds.mcjang.bbs.common.grade.dao.GradeDAO;
import com.ktds.mcjang.bbs.common.grade.service.GradeService;
import com.ktds.mcjang.bbs.common.grade.vo.GradeInfoVO;

public class GradeServiceImpl implements GradeService{

	private GradeDAO gradeDAO;
	
	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}

	@Override
	public boolean insertGrade(GradeInfoVO gradeInfoVO) {
		return this.gradeDAO.insertGrade(gradeInfoVO);
	}
	
	@Override
	public List<GradeInfoVO> selectAllGrade() {
		return this.gradeDAO.selectAllGrade();
	}
	
	@Override
	public boolean updateGrade(GradeInfoVO gradeInfoVO) {
		return this.gradeDAO.updateGrade(gradeInfoVO);
	}

	@Override
	public boolean deleteGrade(GradeInfoVO gradeInfoVO) {
		return this.gradeDAO.deleteGrade(gradeInfoVO);
	}
	
	@Override
	public List<GradeInfoVO> getDefaultGrade() {
		return gradeDAO.getDefaultGrade();
	}
	@Override
	public List<GradeInfoVO> getMemberGradeList() {
		return gradeDAO.getMemberGradeList();
	}
}
