package com.ktds.ahn.bbs.common.grade.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ahn.bbs.common.grade.service.GradeService;
import com.ktds.ahn.bbs.common.grade.vo.GradeVO;

@Controller
public class GradeController {

	private GradeService gradeService;

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}
	
	@RequestMapping("/grade/list")
	public ModelAndView viewGradePage() {
		
		ModelAndView view = new ModelAndView();
		
		List<GradeVO> allGradeList = gradeService.getAllGradeList();
		
		view.setViewName("grade/viewGradeList");
		view.addObject("allGradeList", allGradeList);
		return view;
		
	}
	
	@RequestMapping("/grade/write")
	public ModelAndView viewWriteGradePage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("grade/writeGrade");
		return view;
	}
	
	@RequestMapping("grade/doWrite")
	public ModelAndView doWrite(GradeVO gradeVO) {
		
		ModelAndView view = new ModelAndView();
		gradeService.writeGrade(gradeVO);
		view.setViewName("redirect:/grade/list");
		
		return view;
	}
	
	@RequestMapping("grade/doModify")
	public ModelAndView doModify(GradeVO gradeVO) {
		
		ModelAndView view = new ModelAndView();
		gradeService.modifyGrade(gradeVO);
		view.setViewName("redirect:/grade/list");
		
		return view;
	}
	
	@RequestMapping(value="/grade/{gradeIndex}", method=RequestMethod.GET)
	public ModelAndView viewDatailPage(@PathVariable int gradeIndex) {
		ModelAndView view = new ModelAndView();
		
		gradeService.deleteGrade(gradeIndex);
		view.setViewName("redirect:/grade/list");
		
		return view;
	}
	
	@RequestMapping(value="/grade/modify/{gradeIndex}", method=RequestMethod.GET)
	public ModelAndView viewModifyPage(@PathVariable int gradeIndex) {
		ModelAndView view = new ModelAndView();
		
		GradeVO gradeVO = new GradeVO();
		gradeVO = gradeService.selectGradeInfoById(gradeIndex);
		view.addObject("gradeVO", gradeVO);
		view.setViewName("grade/writeGrade");
		return view;
	}
	
	
	
}
