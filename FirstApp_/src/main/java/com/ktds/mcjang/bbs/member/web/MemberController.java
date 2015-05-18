package com.ktds.mcjang.bbs.member.web;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.bbs.common.AjaxUtil;
import com.ktds.mcjang.bbs.member.service.MemberService;
import com.ktds.mcjang.bbs.member.vo.MemberInfoVO;

@Controller
public class MemberController {

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/member/join")
	public String viewMemberJoinPage() {
		return "member/join";
	}
	
	@RequestMapping("/member/doJoin")
	public ModelAndView doJoin(
			@Valid MemberInfoVO memberInfoVO, Errors errors) {
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("memberInfoVO", memberInfoVO);
		
		/*
		 * 에러체크한다.
		 */
		if(errors.hasErrors()) {
			view.setViewName("member/join");
		}
		else {
			
			//EmailId + EmailHost 의 길이가 총 50글자가 넘어가는지 확인한다.
			
			if(memberService.isExceed50(memberInfoVO)) {
				
				view.setViewName("member/join");
				view.addObject("emailError", "Email은 50글짜가 넘어갈 수 없습니다.");
				return view;
			}
			
			//ID 중복체크
			
			boolean isDuplicateUserId = 
					this.memberService.checkDuplicateUserId(memberInfoVO.getUsrId());
			
			if(isDuplicateUserId) {
				view.setViewName("member/join");
				view.addObject("duplicateUserId", "이미 사용중인 ID 입니다.");
				
				return view;
			}
			
			view.setViewName("redirect:/list");
			this.memberService.joinMember(memberInfoVO);
		}
		
		return view;
		
	}
	
	@RequestMapping("/member/checkDuplicateUserIDAjax")
	public void checkDuplicateUserID(@RequestParam String userId
			,HttpServletResponse response) {
		boolean isDuplicateUserId = 
				this.memberService.checkDuplicateUserId(userId);
		
		/*
		 * Response로 응답하기 위해서 PrintWriter 객체를 생성한다.
		 */
		
		//Refactoring
		AjaxUtil.sendResponse(response, isDuplicateUserId + "");
	}
}
