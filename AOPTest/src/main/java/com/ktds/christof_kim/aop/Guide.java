package com.ktds.christof_kim.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Guide {
	
	public Object guide(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// ClassName.MethodName 을 가져온다.
		String classAndMethod 
			= joinPoint.getSignature().toShortString();
		
		//ClassName.MethodName을 출력한다.
		System.out.println(classAndMethod);
		
		//Method 실행 전에 수행해야 할 공통 기능을 작성한다.
		System.out.println("반갑게 인사합니다.");
		
		try{
			// 원래 실행될 Method를 실행시킨다.
			Object result = joinPoint.proceed();
			return result;
		}
		finally{
			// Method 실행 후에 수행해야 할 공통기능을 작성한다.
			System.out.println("Good Bye:반갑게 인사합니다.");
		}
		
	}
	
}
