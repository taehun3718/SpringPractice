package com.ktds.mcjang.bbs.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.ktds.mcjang")
public class ExceptionController {

	@ExceptionHandler(RuntimeException.class)
	public ModelAndView runtimeException(RuntimeException re) {
		ModelAndView view = new ModelAndView();
		
		view.addObject("exception", re);
		if(re.getCause() != null) {
			view.addObject("cause", re.getCause());
			
		}
		
		view.setViewName("error/runtimeException");
		return view;
	}
}
