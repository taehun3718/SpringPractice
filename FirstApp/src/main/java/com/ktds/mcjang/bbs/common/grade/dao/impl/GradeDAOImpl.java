package com.ktds.mcjang.bbs.common.grade.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.mcjang.bbs.common.grade.dao.GradeDAO;
import com.ktds.mcjang.bbs.common.grade.vo.GradeInfoVO;
import com.ktds.mcjang.bbs.member.web.MemberController;

public class GradeDAOImpl extends SqlSessionDaoSupport implements GradeDAO{
	
	private static Logger logger = LoggerFactory.getLogger(GradeDAOImpl.class);
	@Override
	public boolean insertGrade(GradeInfoVO gradeInfoVO) {
		int count = getSqlSession().insert("gradeDAO.insertGrade", gradeInfoVO);
		return count > 0;
	}
	
	@Override
	public List<GradeInfoVO> selectAllGrade() {
		List<GradeInfoVO> gradeInfoVOList = getSqlSession().selectList("gradeDAO.getAllGrade");
		return gradeInfoVOList;
	}

	@Override
	public boolean updateGrade(GradeInfoVO gradeInfoVO) {
		int count = getSqlSession().update("gradeDAO.updateGrade", gradeInfoVO);
		return count > 0;
	}

	@Override
	public boolean deleteGrade(GradeInfoVO gradeInfoVO) {
		int count = getSqlSession().delete("gradeDAO.deleteGrade", gradeInfoVO);
		return count > 0;
	}
	
	@Override
	public List<GradeInfoVO> getDefaultGrade() {
		return getSqlSession().selectList("gradeDAO.getDefaultGrade");
	}
	
	@Override
	public List<GradeInfoVO> getMemberGradeList() {
		return getSqlSession().selectList("gradeDAO.getMemberGradeList");
	}
}
