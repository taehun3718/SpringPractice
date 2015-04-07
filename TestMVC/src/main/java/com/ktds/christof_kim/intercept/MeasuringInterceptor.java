package com.ktds.christof_kim.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MeasuringInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//현재 시간을 가져온다.
		long currentTime = System.currentTimeMillis();
		
		//현재 시간을 모델에 넣는다.
		request.setAttribute("bTime", currentTime);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//View를 리턴하기 직전 실행됨
		
		//현재 시간을 구한다.
		
		long currentTime = System.currentTimeMillis();
		
		//요청이 시작된 시간을 가져온다.
		long beginTime = (long)request.getAttribute("bTime");
		
		//현재 시간에서 요청이 시각된 시간을 뺸다.
		//--> 총 처리시간을 구한다.
		long processedTime = currentTime - beginTime;
		
		System.out.println("요청된 URL:" + request.getRequestURI());
		System.out.println("총 처리시간은 : " + processedTime);
		
		//이렇게 하면 웹 페이제에서 요청하는 처리 시간을 구할 수 있음
		
	}
	
	private static String getPaddingFormat(String format){
		String number;
		
		return "";
	}
	
}