package com.ktds.mcjang.bbs.index.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	//forTesting
	@RequestMapping("/test")
	public String viewTest() {
		return "/member/list";
	}
	
}
