package com.ktds.mcjang.bbs.member.dao;

import com.ktds.mcjang.bbs.member.vo.MemberInfoVO;


public interface MemberDAO {

	public boolean joinMember(MemberInfoVO memberInfoVO);

	public boolean checkDuplicateUserId(String userId);
	
}
