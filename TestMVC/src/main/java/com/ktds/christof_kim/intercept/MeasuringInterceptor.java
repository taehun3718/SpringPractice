package com.ktds.christof_kim.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MeasuringInterceptor extends HandlerInterceptorAdapter{
	
	private static Logger logger = LoggerFactory.getLogger(MeasuringInterceptor.class);
	
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
		
		/*
		logger.trace("Trace 입니다.");
		logger.debug("Debug 입니다.");
		logger.info("Info 입니다.");
		logger.warn("Warn 입니다.");
		logger.error("Error 입니다.");*/
		
		processedTime = 99;
/*		System.out.println("요청된 URL:" + request.getRequestURI());
		System.out.println("총 처리시간은 : " + getPaddingFormat(processedTime));*/
		logger.info("요청된 URL:" + request.getRequestURI());
		logger.info("총 처리시간은 : " + getPaddingFormat(processedTime));
		//이렇게 하면 웹 페이제에서 요청하는 처리 시간을 구할 수 있음
		
	}
	
	private String getPaddingFormat(long currentTimeMills){
		
		if(currentTimeMills==1000)
			return "1.0";
		else if(currentTimeMills<1000)
			return "0." + currentTimeMills;
		else if(currentTimeMills<100)
			return "0.00" + currentTimeMills;
		else if(currentTimeMills<10)
			return "0.000" + currentTimeMills;
			
		return "n/a";

	}
	
}