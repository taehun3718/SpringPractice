package com.ktds.christof_kim.common.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.christof_kim.common.util.SessionStore;
import com.ktds.christof_kim.member.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	//컨트롤러/핸들러 객체를 실행하기 전에 필요한 기능을 구현할 때
	@Override
	public boolean preHandle(HttpServletRequest request
							, HttpServletResponse response
							, Object handler) throws Exception {
		
		if(request.getSession().getAttribute(LoginAttr.MEMBER_ATTR)==null){
			response.sendRedirect("/ExampleOfInterceptor/requiredLogin");
			return false;
		}
		return true;
	}
	
	//컨트롤러와 핸들러가 정상적으로 실행된 이후에 추가 기능을 구현할 때
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
	//클라이언트에 뷰를 전송한 뒤에 실행
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
