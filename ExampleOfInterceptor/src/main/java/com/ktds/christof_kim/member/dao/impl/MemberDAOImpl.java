package com.ktds.christof_kim.member.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.christof_kim.member.dao.MemberDAO;
import com.ktds.christof_kim.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public boolean doLogin(MemberVO memberVO) {
		return true;
	}

}
