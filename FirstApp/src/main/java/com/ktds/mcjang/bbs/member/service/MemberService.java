package com.ktds.mcjang.bbs.member.service;

import java.util.List;

import com.ktds.mcjang.bbs.member.vo.MemberInfoVO;

public interface MemberService {

	public boolean joinMember(MemberInfoVO memberInfoVO);
	public boolean isExceed50(MemberInfoVO memberInfoVO);
	public boolean checkDuplicateUserId(String userId);
	
	/**
	 * 모든 회원들을 선택한다.
	 * @return 모든 회원들
	 */
	public List<MemberInfoVO> selectAllMember();
	/**
	 * 특정한 회원들을 선택한다.
	 * @param id
	 * @return id의 디테일한 정보들
	 */
	public MemberInfoVO getMemberInfoById(String memberId);
	
	public void injectionGradeToMember(List<String> memberids, String gradeIndex);
	
	public void injectionSndGradeToMember(List<String> memberids, String sndGradeIndex);
}
