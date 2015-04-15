package com.ktds.mcjang.bbs.member.service;

import com.ktds.mcjang.bbs.member.vo.MemberInfoVO;

public interface MemberService {

	public boolean joinMember(MemberInfoVO memberInfoVO);
	public boolean isExceed50(MemberInfoVO memberInfoVO);
	public boolean checkDuplicateUserId(String userId);
	
}
