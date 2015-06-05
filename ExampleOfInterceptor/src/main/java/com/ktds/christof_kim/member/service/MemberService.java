package com.ktds.christof_kim.member.service;

import javax.servlet.http.HttpServletRequest;

import com.ktds.christof_kim.member.vo.MemberVO;

public interface MemberService {

	public boolean doLogin(MemberVO memberVO,  HttpServletRequest request);
	public void doLogout(HttpServletRequest request);

}
