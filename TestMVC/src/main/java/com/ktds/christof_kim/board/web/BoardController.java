package com.ktds.christof_kim.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.board.service.BoardService;
import com.ktds.christof_kim.board.vo.ArticleVO;

@Controller
public class BoardController {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public ModelAndView viewWritePage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("board/write");
		return view;
	}
	
	@RequestMapping(value="/doWrite", method=RequestMethod.POST)
	public ModelAndView doWriteArticle(@Valid ArticleVO articleVO, Errors errors) {
		ModelAndView view = new ModelAndView();
		
		if(!errors.hasErrors()){
			int articleId = boardService.writeArticle(articleVO);
			view.setViewName("redirect:/detail/" + articleId);
		}
		else {
			view.setViewName("board/write");
		}
		return view;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView viewListPage() {
		ModelAndView view = new ModelAndView();
		
		List<ArticleVO> allArticleList = boardService.getAllArticleList();
		
		
		view.setViewName("board/list");
		view.addObject("allArticleList", allArticleList);
		
		return view;
	}
	
	@RequestMapping(value="/detail/{articleId}", method=RequestMethod.GET)
	public ModelAndView viewDetailPage(@PathVariable int articleId) {
		ModelAndView view = new ModelAndView();
		
		ArticleVO article = boardService.readArticleById(articleId);
		view.setViewName("board/detail");
		view.addObject("article", article);
		return view;
	}
	
//	//15-04-06
//	@RequestMapping("/test")
//	public ModelAndView test(HttpServletRequest request) {
//		ModelAndView view = new ModelAndView();
//		//세션을 받는 첫 번째 방법
//		HttpSession session = request.getSession();
//		return view;
//	}
//	
//	@RequestMapping("/test")
//	public ModelAndView test2(HttpSession session) {
//		ModelAndView view = new ModelAndView();
//		//세션을 받는 두 번째 방법
//		session.setAttribute("key", "value");
//		return view;
//	}
	
		//15-04-06 테스트를 하기 위해 이름을 바꿈
		@RequestMapping("/exampleSession1")
		public ModelAndView exampleSession(HttpServletRequest request) {
			ModelAndView view = new ModelAndView();
			//세션을 받는 첫 번째 방법
			HttpSession session = request.getSession();
			return view;
		}
		
		@RequestMapping("/exampleSession2")
		public ModelAndView exampleSession2(HttpSession session) {
			ModelAndView view = new ModelAndView();
			//세션을 받는 두 번째 방법
			session.setAttribute("key", "value");
			return view;
		}
}
