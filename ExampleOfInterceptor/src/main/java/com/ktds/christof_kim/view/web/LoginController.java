package com.ktds.christof_kim.view.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.member.service.MemberService;
import com.ktds.christof_kim.member.vo.MemberVO;

@Controller
public class LoginController {

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/requiredLogin")
	public ModelAndView requiredLogin() {
		ModelAndView view  = new ModelAndView();
		view.setViewName("/login/requiredLogin");
		
		return view;
		
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView view  = new ModelAndView();
		view.setViewName("/login/login");
		
		return view;
	}
	
	@RequestMapping("/doLogin")
	public ModelAndView doLogin(@RequestParam ("id") String id
							, @RequestParam ("pwd") String pwd
							, HttpServletRequest request) {
		
		MemberVO memberVO = new MemberVO();

		memberVO.setId(id);
		memberVO.setPassword(pwd);
		
		boolean islogined = memberService.doLogin(memberVO, request);

		ModelAndView view  = new ModelAndView();
		view.setViewName("redirect:/");		
		return view;
	}
	
	@RequestMapping("/doLogout")
	public ModelAndView doLogout(HttpServletRequest request) {
		
		memberService.doLogout(request);
		
		ModelAndView view  = new ModelAndView();
		view.setViewName("redirect:/");		
		return view;
	}

}
