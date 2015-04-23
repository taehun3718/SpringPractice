package com.ktds.christof_kim.view.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.member.vo.MemberVO;
@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("_MEMBER_");

		ModelAndView view = new ModelAndView();
		view.addObject("memberVO",memberVO);
		view.setViewName("/index");
		return view;
	}
}
	
