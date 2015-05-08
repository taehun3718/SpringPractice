package com.ktds.mcjang.bbs.member.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@Override
	public List<MemberInfoVO> selectAllMember() {
		return this.memberDAO.selectAllMember();
	}
	
	@Override
	public MemberInfoVO getMemberInfoById(String memberId) {
		return this.memberDAO.getMemberInfoById(memberId);
	}
	@Override
	public void injectionGradeToMember(List<String> memberIds, String gradeIndex) {
		
		Map<String, String> param = null;
		for(String memberId : memberIds){
			
			param = new HashMap<String, String>();
			param.put("memberId", memberId);
			param.put("gradeIndex", gradeIndex);
			
			this.memberDAO.injectionGradeToMember(param);
		}
		
	}
	
	@Override
	public void injectionSndGradeToMember(List<String> memberIds,
			String sndGradeIndex) {
		Map<String, String> param = null;
		for(String memberId : memberIds){
			
			param = new HashMap<String, String>();
			param.put("memberId", memberId);
			param.put("sndGradeIndex", sndGradeIndex);
			
			this.memberDAO.injectionSndGradeToMember(param);
		}
		
	}
}
