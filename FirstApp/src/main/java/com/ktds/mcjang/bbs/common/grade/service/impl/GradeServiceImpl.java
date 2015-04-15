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
		// TODO Auto-generated method stub
		return this.gradeDAO.selectAllGrade();
	}
	
}
