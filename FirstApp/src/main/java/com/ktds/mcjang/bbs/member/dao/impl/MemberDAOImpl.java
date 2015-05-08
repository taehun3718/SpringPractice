package com.ktds.mcjang.bbs.member.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.mcjang.bbs.member.dao.MemberDAO;
import com.ktds.mcjang.bbs.member.vo.MemberInfoVO;

public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO {

	@Override
	public boolean joinMember(MemberInfoVO memberInfoVO) {
		
		int insertCount = getSqlSession().insert("memberDAO.joinMember", memberInfoVO);
		return insertCount > 0;
	}
	
	@Override
	public boolean checkDuplicateUserId(String userId) {
		int count = getSqlSession().selectOne("memberDAO.getCountByUserId", userId);
		return count > 0;
	}
	
	@Override
	public List<MemberInfoVO> selectAllMember() {
		List<MemberInfoVO> memberList = getSqlSession().selectList("memberDAO.getAllMember");
		return memberList;
	}
	
	@Override
	public void injectionGradeToMember(Map<String, String> param){
		
		getSqlSession().update("memberDAO.injectionGradeToMember", param);
	}
	
	@Override
	public void injectionSndGradeToMember(Map<String, String> param) {
		int i = getSqlSession().update("memberDAO.injectionSndGradeToMember", param);
		System.out.println("i:" + i);
	}
	
	@Override
	public MemberInfoVO getMemberInfoById(String memberId) {
		MemberInfoVO memberInfoVO = getSqlSession().selectOne("memberDAO.getMemberInfoById", memberId);
		return memberInfoVO;
	}
}
