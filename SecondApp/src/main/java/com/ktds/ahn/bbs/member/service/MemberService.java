package com.ktds.ahn.bbs.member.service;

import java.util.List;

import com.ktds.ahn.bbs.member.vo.MemberInfoVO;

public interface MemberService {

	public boolean checkDuplicateUserId(String usrId);
	
	public boolean joinMember(MemberInfoVO memberInfoVO);
	
	public boolean isExceed50(MemberInfoVO memberInfoVO);

	public List<MemberInfoVO> getAllMemberList();

	public MemberInfoVO getMemberInfoById(String usrId);
	
	public void injectiionGradeToMember(List<String> memberIds, String gradeIndex);
	
}
