package com.ktds.christof_kim.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	//이 URL로 들어오면 내가 처리할께
	@RequestMapping("/test")
	public String test(){
		
		//       PREFIX      | SUFIX
		// /WEB-INF/view/test/test.jsp
		return "test/test";
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2() {
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("test/test2");
		view.addObject("helloMessage", "Hello!");	//Key, Value
		view.addObject("byeMessage", "bye bye");
		
		//뷰를 리턴하면 jsp를 리턴하게 되어 있음
		return view;
		
	}
	
	@RequestMapping(value="/test4", method=RequestMethod.GET)
	public ModelAndView test4() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("test/test2");
		return view;
	}
	
	@RequestMapping(value="/test5", method=RequestMethod.POST)
	public ModelAndView test5() {
		
		ModelAndView view = new ModelAndView();
		return view;
	}
	
	
}
