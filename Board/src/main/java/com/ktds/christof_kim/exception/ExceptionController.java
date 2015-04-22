package com.ktds.christof_kim.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.bbs.exception.IndexNotAccessException;
import com.ktds.christof_kim.bbs.exception.TableNotFoundException;

@ControllerAdvice("com.ktds.christof_kim")
public class ExceptionController {

	@ExceptionHandler(TableNotFoundException.class)
	public ModelAndView tableNotFoundException(TableNotFoundException tnfe) {
		ModelAndView view = new ModelAndView();
		view.setViewName("error/runtimeException");
		view.addObject("exception", tnfe.getMessage());
		
		if(tnfe.getCause() != null) {
			view.addObject("cause", tnfe.getCause().getMessage());
		}
		return view;
	}
	
	@ExceptionHandler(IndexNotAccessException.class)
	public ModelAndView indexNotAccessException(IndexNotAccessException inae) {
		ModelAndView view = new ModelAndView();
		view.setViewName("error/runtimeException");
		
		view.addObject("exception", inae.getMessage());
		if(inae.getCause() != null) {
			view.addObject("cause", inae.getCause().getMessage());
		}
		
		return view;
	}
}
