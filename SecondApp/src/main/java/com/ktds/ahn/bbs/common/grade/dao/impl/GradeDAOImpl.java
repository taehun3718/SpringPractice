package com.ktds.ahn.bbs.common.grade.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.ahn.bbs.common.grade.dao.GradeDAO;
import com.ktds.ahn.bbs.common.grade.vo.GradeVO;

public class GradeDAOImpl extends SqlSessionDaoSupport implements GradeDAO{

	@Override
	public List<GradeVO> getAllGradeList() {
		List<GradeVO> allGradeList = getSqlSession().selectList("gradeDAO.getCountByUserId");
		return allGradeList;
	}
	
	@Override
	public void writeGrade(GradeVO gradeVO) {
		getSqlSession().insert("gradeDAO.insertGrade", gradeVO);
	}
	
	@Override
	public void deleteGrade(int gradeIndex) {
		getSqlSession().delete("gradeDAO.deleteGrade", gradeIndex);
	}
	
	@Override
	public GradeVO selectGradeInfoById(int gradeIndex) {
		return getSqlSession().selectOne("gradeDAO.getGradeInfoByUserId", gradeIndex);
	}
	
	@Override
	public void modifyGrade(GradeVO gradeVO) {
		getSqlSession().update("gradeDAO.modifyGradeByUserId", gradeVO);
	}
	
	@Override
	public List<GradeVO> getDefaultGrade() {
		return getSqlSession().selectList("gradeDAO.getDefaultGrade");
	}
	
	@Override
	public List<GradeVO> getMemberGradeList() {
		return getSqlSession().selectList("gradeDAO.getMemberGradeList");
	}
	
	@Override
	public List<String> getValidGradeByGradeIdx(int tableGrade) {
		return getSqlSession().selectList("gradeDAO.validGradeByGradeIdx", tableGrade);
	}
}
