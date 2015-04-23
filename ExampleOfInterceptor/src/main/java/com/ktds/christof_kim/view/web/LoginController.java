package com.ktds.christof_kim.view.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.member.vo.MemberVO;

@Controller
public class LoginController {

	
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
		
		HttpSession session  = request.getSession();
		session.setAttribute("_MEMBER_", memberVO);
		
		ModelAndView view  = new ModelAndView();
		view.setViewName("redirect:/");		
		return view;
	}
	
	@RequestMapping("/doLogout")
	public ModelAndView doLogout(HttpServletRequest request) {
		
		HttpSession session  = request.getSession();
		session.invalidate();
		
		ModelAndView view  = new ModelAndView();
		view.setViewName("redirect:/");		
		return view;
	}

}
