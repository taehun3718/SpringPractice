package com.ktds.christof_kim.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
	
		//그 사람이 최근 어떤 페이지에서 클릭해서 왔는지 알 수 있음(인가 체크)
		String refererURL = request.getHeader("referer");
		System.out.println("REFERER URL:" + refererURL);
		
		if(session.getAttribute("_MEMBER_")==null) {
			//세션이 비어 있을 경우 로그인 페이지로
			//response.sendRedirect("http://localhost:8080/TestMVC/write");
			response.sendRedirect("/TestMVC/write");
//			response.sendRedirect("/TestMVC/login");
			return false;
		}
		return true;
	}
	
	
}
