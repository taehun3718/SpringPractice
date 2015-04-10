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
		
		//�쁽�옱 �떆媛꾩쓣 媛��졇�삩�떎.
		long currentTime = System.currentTimeMillis();
		
		//�쁽�옱 �떆媛꾩쓣 紐⑤뜽�뿉 �꽔�뒗�떎.
		request.setAttribute("bTime", currentTime);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//View瑜� 由ы꽩�븯湲� 吏곸쟾 �떎�뻾�맖
		
		//�쁽�옱 �떆媛꾩쓣 援ы븳�떎.
		
		long currentTime = System.currentTimeMillis();
		
		//�슂泥��씠 �떆�옉�맂 �떆媛꾩쓣 媛��졇�삩�떎.
		long beginTime = (long)request.getAttribute("bTime");
		
		//�쁽�옱 �떆媛꾩뿉�꽌 �슂泥��씠 �떆媛곷맂 �떆媛꾩쓣 類몃떎.
		//--> 珥� 泥섎━�떆媛꾩쓣 援ы븳�떎.
			
		long processedTime = currentTime - beginTime;
		
		/*
		logger.trace("Trace �엯�땲�떎.");
		logger.debug("Debug �엯�땲�떎.");
		logger.info("Info �엯�땲�떎.");
		logger.warn("Warn �엯�땲�떎.");
		logger.error("Error �엯�땲�떎.");*/
		
		processedTime = 99;
/*		System.out.println("�슂泥��맂 URL:" + request.getRequestURI());
		System.out.println("珥� 泥섎━�떆媛꾩� : " + getPaddingFormat(processedTime));*/
		logger.info("URL:" + request.getRequestURI());
		logger.info("처리시간: " + getPaddingFormat(processedTime));
		//�씠�젃寃� �븯硫� �쎒 �럹�씠�젣�뿉�꽌 �슂泥��븯�뒗 泥섎━ �떆媛꾩쓣 援ы븷 �닔 �엳�쓬
		
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