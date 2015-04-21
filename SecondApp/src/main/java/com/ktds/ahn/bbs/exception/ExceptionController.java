package com.ktds.ahn.bbs.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.ktds.ahn")
public class ExceptionController {
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView runtimeException(RuntimeException re) {
		ModelAndView view = new ModelAndView();
		re.printStackTrace();
		view.addObject("exception", re.getMessage());
		if ( re.getCause() != null ) {
			view.addObject("cause", re.getCause().getMessage());
		}
		view.setViewName("error/runtimeException");
		return view;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e) {
		ModelAndView view = new ModelAndView();
		view.addObject("exception", e);
		if ( e.getCause() != null ) {
			view.addObject("cause", e.getCause());
		}
		view.setViewName("error/runtimeException");
		return view;
	}
}
