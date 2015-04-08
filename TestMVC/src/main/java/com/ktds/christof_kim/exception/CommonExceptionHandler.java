package com.ktds.christof_kim.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
//com.ktds 아래에서 발생하는 모든 Exception을 받겠다!!!
@ControllerAdvice("com.ktds")	//이 패키지에서 발생된 예외는 여기서 다 받겠다.
public class CommonExceptionHandler {
	
	//받아온 Exception이 RuntimeException일 때 아래 메소드를 실행하겠다.
	//동작하는 구조는 MVC와 동일하다.
//	@ExceptionHandler(RuntimeException.class)
//	public String getRuntimeExceptionHandler() {
//		return "error/runtimeException";	//뷰
//	}
//	
	//위와 동일한 코드임
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView getRuntimeExceptionHandler(RuntimeException exception) {
		ModelAndView view = new ModelAndView();
		view.setViewName("error/runtimeException");
		view.addObject("message", exception.getMessage());
		
		return view;
	}
}
