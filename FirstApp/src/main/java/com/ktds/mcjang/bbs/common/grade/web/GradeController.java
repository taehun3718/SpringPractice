package com.ktds.mcjang.bbs.common.grade.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.bbs.common.grade.service.GradeService;
import com.ktds.mcjang.bbs.common.grade.vo.GradeInfoVO;

@Controller
public class GradeController {
	
	private GradeService gradeService;
	private static Logger logger = LoggerFactory.getLogger(GradeController.class);
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	@RequestMapping("/grade/listGrade")
	public ModelAndView listGrade() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/grade/listGrade");
		logger.info("listGrade");
		
		List<GradeInfoVO> allGradeList = gradeService.selectAllGrade();
		view.addObject("allGradeList", allGradeList);		
		
		return view;
	}
	
	
	@RequestMapping("/grade/insertGrade")
	public ModelAndView insertGrade() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/grade/insertGrade");
		logger.info("insertGrade");
		return view;
	}
	
	@RequestMapping("/grade/doGrade")
	public @ResponseBody ModelAndView doGrade(
			@Valid GradeInfoVO gradeInfoVO, Errors errors) {
		
		ModelAndView view = new ModelAndView();
		
		//에러 처리
		
		//삽입
		this.gradeService.insertGrade(gradeInfoVO);
		logger.info("doInsert");
		view.setViewName("redirect:/grade/insertGrade");
		return view;
	}
}
