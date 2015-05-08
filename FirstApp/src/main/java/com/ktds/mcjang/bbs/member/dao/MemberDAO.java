package com.ktds.mcjang.bbs.member.dao;

import java.util.List;
import java.util.Map;

import com.ktds.mcjang.bbs.member.vo.MemberInfoVO;


public interface MemberDAO {

	public boolean joinMember(MemberInfoVO memberInfoVO);

	public boolean checkDuplicateUserId(String userId);
	/**
	 * DB에서 회원 정보들을 불러들인다.
	 * @return 회원 정보들
	 */
	public List<MemberInfoVO> selectAllMember();
	
	public void injectionGradeToMember(Map<String, String> param);
	public void injectionSndGradeToMember(Map<String, String> param);
	/**
	 * DB에서 idx에 해당하는 회원정보를 불러들인다.
	 * @return idx번째 회원
	 */
	public MemberInfoVO getMemberInfoById(String memberId);
}
