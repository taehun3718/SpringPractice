package com.ktds.christof_kim.member.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.ktds.christof_kim.common.Interceptor.LoginAttr;
import com.ktds.christof_kim.common.util.SessionStore;
import com.ktds.christof_kim.member.dao.MemberDAO;
import com.ktds.christof_kim.member.service.MemberService;
import com.ktds.christof_kim.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{

	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}


	@Override
	public boolean doLogin(MemberVO memberVO, HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		//DO login (DB)
		//아이디가 데이터베이스에서 존재하는지 확인하였다고 가정.
		boolean logined = memberDAO.doLogin(memberVO);
		
		if(logined) {
			SessionStore sessionStore = SessionStore.getInstance();
			
			if(!sessionStore.isExists("taehun3718")) {
				session.setAttribute(LoginAttr.MEMBER_ATTR, memberVO);
				sessionStore.putSession(memberVO.getId(), session);
				return true;
			}
			else {
				int  i = JOptionPane
							.showConfirmDialog(null
									, "이미 로그인 되어 있는 아이디입니다. 로그 아웃을 하시겠습니까?"
									, "로그인 확인"
									, JOptionPane.YES_NO_OPTION);
				//세션은 브라우져 마다 다른 세션을 가지고 있기 때문에, Invalidate 및 removeSession 처리를 해야 하며
				//같은 브라우져일 경우 로그인이 되 있을 경우, 로그인 페이지로 가지 않고 다른 페이지로 가도록 처리해야 함. 
				if(i==0) {
					sessionStore.getSession(memberVO.getId()).invalidate();
					sessionStore.removeSession(memberVO.getId());
					session.setAttribute(LoginAttr.MEMBER_ATTR, memberVO);
					//...
					sessionStore.putSession(memberVO.getId(), session);
					
					return true;
				}
				else if(i==1){
					return false;
				}
			}
		}
		return false;
	}
	
	@Override
	public void doLogout(HttpServletRequest request) {
		SessionStore sessionStore = SessionStore.getInstance();
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute(LoginAttr.MEMBER_ATTR);
		
		if(memberVO!=null)
			sessionStore.getSession(memberVO.getId()).invalidate();
		sessionStore.removeSession(memberVO.getId());
	}
}
