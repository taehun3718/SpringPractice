package com.ktds.christof_kim.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	//이 URL로 들어오면 내가 처리할께
	@RequestMapping("/test")
	public String test(){
		
		//       PREFIX      | SUFIX
		// /WEB-INF/view/test/test.jsp
		return "test/test";
	}
	
}
