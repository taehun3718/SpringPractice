package com.ktds.ahn.bbs.member.dao;

import java.util.List;
import java.util.Map;

import com.ktds.ahn.bbs.member.vo.MemberInfoVO;

public interface MemberDAO {

	public boolean joinMember(MemberInfoVO memberInfoVO);

	public boolean checkDuplicateUserId(String usrId);

	public List<MemberInfoVO> getAllMemberList();

	public MemberInfoVO getMemberInfoById(String usrId);
	
	public void injectiionGradeToMember(Map<String,String> param);
	
}
