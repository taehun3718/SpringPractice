package com.ktds.mcjang.bbs.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.bbs.board.exception.InvalidAccessException;
import com.ktds.mcjang.bbs.board.exception.NotFoundTableNameException;

@ControllerAdvice("com.ktds.mcjang")
public class ExceptionController {

	@ExceptionHandler(InvalidAccessException.class)
	public ModelAndView invalidAccessException(InvalidAccessException iae) {
		
		ModelAndView view = new ModelAndView();
		
		iae.printStackTrace();
		view.addObject("exception", iae.getMessage());
		if(iae.getCause() != null) {
			view.addObject("cause", iae.getCause().getMessage());
			
		}
		
		view.setViewName("error/runtimeException");
		
		
		return view;
	}
	
	@ExceptionHandler(NotFoundTableNameException.class)
	public ModelAndView notFountTableNameException(NotFoundTableNameException nftne) {
		
		ModelAndView view = new ModelAndView();
		
		nftne.printStackTrace();
		view.addObject("exception", nftne.getMessage());
		if(nftne.getCause() != null) {
			view.addObject("cause", nftne.getCause().getMessage());
			
		}
		
		view.setViewName("error/runtimeException");
		
		
		return view;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView runtimeException(RuntimeException re) {
		ModelAndView view = new ModelAndView();
		re.printStackTrace();
		view.addObject("exception", re.getMessage());
		if(re.getCause() != null) {
			view.addObject("cause", re.getCause().getMessage());
			
		}
		
		view.setViewName("error/runtimeException");
		return view;
	}
}
