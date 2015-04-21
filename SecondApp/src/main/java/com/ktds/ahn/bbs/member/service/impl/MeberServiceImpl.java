package com.ktds.ahn.bbs.member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ktds.ahn.bbs.member.dao.MemberDAO;
import com.ktds.ahn.bbs.member.service.MemberService;
import com.ktds.ahn.bbs.member.vo.MemberInfoVO;

public class MeberServiceImpl implements MemberService{

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
	public boolean checkDuplicateUserId(String usrId) {
		return this.memberDAO.checkDuplicateUserId(usrId);
	}
	
	@Override
	public List<MemberInfoVO> getAllMemberList() {
		return this.memberDAO.getAllMemberList();
	}
	
	@Override
	public MemberInfoVO getMemberInfoById(String usrId) {
		return this.memberDAO.getMemberInfoById(usrId);
	}
	
	@Override
	public void injectiionGradeToMember(List<String> memberIds,
			String gradeIndex) {
		Map<String, String> param = null;
		for( String memberId : memberIds ) {
			param = new HashMap<String, String>();
			param.put("memberId", memberId);
			param.put("gradeIndex", gradeIndex);
			this.memberDAO.injectiionGradeToMember(param);
		}
		
	}
}
