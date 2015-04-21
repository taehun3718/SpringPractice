package com.ktds.ahn.bbs.member.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ahn.bbs.common.grade.service.GradeService;
import com.ktds.ahn.bbs.common.grade.vo.GradeVO;
import com.ktds.ahn.bbs.member.service.MemberService;
import com.ktds.ahn.bbs.member.vo.MemberInfoVO;

@Controller
public class MemberController {

	private MemberService memberService;
	private GradeService gradeService;

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/member/join")
	public String viewMemberJoinPage() {
		return "member/join";
	}
	
	@RequestMapping("member/doJoin")
	public ModelAndView doJoin(@Valid MemberInfoVO memberInfoVO, Errors errors) {
		
		ModelAndView view = new ModelAndView();
		view.addObject("memberInfoVO",memberInfoVO);
		
		/*
		 * 에러 체크
		 */
		if ( errors.hasErrors() ) {
			view.setViewName("member/join");
		}
		else {
			
			/*
			 *  EmailId + EmailHost 의 길이가 총 50 글자가 넘어가는지 확인한다
			 */
			if ( memberService.isExceed50(memberInfoVO) ) {
				view.setViewName("member/join");
				view.addObject("emailError","Email은 50 글자가 넘어갈 수 없습니다.");
				return view;
			}
				
			/*
			 * 아이디 중복 체크
			 */
			
			boolean isDuplicateUserId = this.memberService.checkDuplicateUserId(memberInfoVO.getUsrId());
			
			if (isDuplicateUserId) {
				view.setViewName("member/join");
				view.addObject("duplicateUserId","이미 사용중인 ID입니다.");
				return view;
			}
			
			view.setViewName("redirect:/member/list");
			this.memberService.joinMember(memberInfoVO);
				
		}
		
		return view;
	}
	
	@RequestMapping("member/checkDuplicateUserIdAjax")
	public void checkDuplicateUserId(@RequestParam String usrId, HttpServletResponse response) {
		
		boolean isDuplicateUserId = this.memberService.checkDuplicateUserId(usrId);
		
		//AjaxUtil.sendRespnse(response, isDuplicateUserId+"");
		
	}
	
	@RequestMapping("/member/list")
	public ModelAndView viewMemberList() {
		
		ModelAndView view = new ModelAndView();
		
		List<MemberInfoVO> memberList =  memberService.getAllMemberList();
		view.addObject("memberList", memberList);
		view.setViewName("member/list");
		
		List<GradeVO> gradeList = this.gradeService.getDefaultGrade();
		view.addObject("gradeList", gradeList);
		
		return view;
		
	}
	
	@RequestMapping(value="/member/detail/{usrId}", method=RequestMethod.GET)
	public ModelAndView viewDatailPage(@PathVariable String usrId) {
		ModelAndView view = new ModelAndView();

		MemberInfoVO member = new MemberInfoVO();
		member = memberService.getMemberInfoById(usrId);
		
		view.addObject("member", member);
		view.setViewName("member/detail");
		
		return view;
	}
	
	@RequestMapping("/member/grade/injection")
	public ModelAndView memberGradeInjection(
					@RequestParam List<String> checkedId, 
					@RequestParam String grade
			) {
		ModelAndView view = new ModelAndView();
		
		this.memberService.injectiionGradeToMember(checkedId, grade);
		view.setViewName("redirect:/member/list");
		
		return view;
	}
	
}
