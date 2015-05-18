package com.ktds.mcjang.bbs.member.dao.impl;

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
	
}
