package com.ktds.mcjang.bbs.member.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.bbs.common.AjaxUtil;
import com.ktds.mcjang.bbs.common.grade.service.GradeService;
import com.ktds.mcjang.bbs.common.grade.vo.GradeInfoVO;
import com.ktds.mcjang.bbs.member.service.MemberService;
import com.ktds.mcjang.bbs.member.vo.MemberInfoVO;

@Controller
public class MemberController {

	private MemberService memberService;
	private GradeService gradeService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
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
			
			view.setViewName("redirect:/member/listMember");
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
	
	@RequestMapping("/member/{memberId}")
	public ModelAndView memberDetail(@PathVariable String memberId) {
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("/member/memberDetail");
		MemberInfoVO memberInfoVO = memberService.getMemberInfoById(memberId);
		view.addObject("memberInfoVO", memberInfoVO);
		
		return view;
	}
	
	/**
	 * 전체 회원 리스트를 가져오는 뷰
	 * @return ModelAndView
	 */
	@RequestMapping("/member/listMember")
	public ModelAndView listMember() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/member/list");
		
		List<MemberInfoVO> memberList = memberService.selectAllMember();
		view.addObject("memberList", memberList);
		
		//this.gradeService.
		List<GradeInfoVO> gradeList = this.gradeService.getDefaultGrade();
		view.addObject("gradeList", gradeList);
		
		List<GradeInfoVO> memberGradeList = this.gradeService.getMemberGradeList();
		view.addObject("memberGradeList", memberGradeList);
		return view;
	}
	
	@RequestMapping("/member/grade/injection")
	public ModelAndView memberGradeInjection(
			@RequestParam List<String> selectedId
			,@RequestParam String grade) {
		ModelAndView view = new ModelAndView();
		
		
		this.memberService.injectionGradeToMember(selectedId, grade);
		view.setViewName("redirect:/member/listMember");
		
		return view;
	}
	
	@RequestMapping("/member/grade/injectionSnd")
	public ModelAndView memberGradeInjectionSnd(
			@RequestParam List<String> selectedId
			,@RequestParam String sndGrade) {
		
		ModelAndView view = new ModelAndView();
		this.memberService.injectionSndGradeToMember(selectedId, sndGrade);
		
		view.setViewName("redirect:/member/listMember");
		
		return view;
	}
}
