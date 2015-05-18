package com.ktds.mcjang.bbs.member.service.impl;

import com.ktds.mcjang.bbs.member.dao.MemberDAO;
import com.ktds.mcjang.bbs.member.service.MemberService;
import com.ktds.mcjang.bbs.member.vo.MemberInfoVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public boolean joinMember(MemberInfoVO memberInfoVO) {
		
		String emailId = memberInfoVO.getEmailId();
		String emailHost = memberInfoVO.getEmailHost();
		emailId = emailId + "@" + emailHost;
		
		memberInfoVO.setEmailId(emailId);
		
		return this.memberDAO.joinMember(memberInfoVO);
	}

	@Override
	public boolean isExceed50(MemberInfoVO memberInfoVO) {
		String emailId = memberInfoVO.getEmailId();
		String emailHost = memberInfoVO.getEmailHost();
		emailId = emailId + "@" + emailHost;
		
		return emailId.length() > 50;
	}
	
	@Override
	public boolean checkDuplicateUserId(String userId) {
		return this.memberDAO.checkDuplicateUserId(userId);
	}
}
