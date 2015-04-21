package com.ktds.ahn.bbs.member.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.ahn.bbs.member.dao.MemberDAO;
import com.ktds.ahn.bbs.member.vo.MemberInfoVO;

public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO{

	@Override
	public boolean joinMember(MemberInfoVO memberInfoVO) {
		int insertCount = getSqlSession().insert("memberDAO.joinMember", memberInfoVO);
		return insertCount > 0 ;
	}
	
	@Override
	public boolean checkDuplicateUserId(String usrId) {

		int count = getSqlSession().selectOne("memberDAO.getCountByUserId", usrId);
		
		return count > 0;
	}
	
	@Override
	public List<MemberInfoVO> getAllMemberList() {
		List<MemberInfoVO> memberList = getSqlSession().selectList("memberDAO.getMemberList");
		return memberList;
	}
	
	@Override
	public MemberInfoVO getMemberInfoById(String usrId) {
		MemberInfoVO memberInfoVO = getSqlSession().selectOne("memberDAO.getMemberInfoById", usrId);
		return memberInfoVO;
	}
	
	@Override
	public void injectiionGradeToMember(Map<String,String> param) {
		getSqlSession().update("memberDAO.injectiionGradeToMember", param);
	}
}
