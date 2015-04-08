package com.ktds.christof_kim.board.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		/*throw new RuntimeException("페이지를 보여주기 싫어요!");*/
		return view;
	}
	
	/*@RequestMapping(value="/doWrite", method=RequestMethod.POST)
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
	}*/
	
	@RequestMapping(value="/doWrite", method=RequestMethod.POST)
	public ModelAndView doWriteArticle(@Valid ArticleVO articleVO
										, Errors errors
										, HttpSession session) {
		ModelAndView view = new ModelAndView();
		
		if(!errors.hasErrors()){
			int articleId = boardService.writeArticle(articleVO);
			view.setViewName("redirect:/detail/" + articleId);
			session.setAttribute("_MEMBER_", "1");
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
			
			return view;
		}
		
		@RequestMapping("/login")
		public ModelAndView viewLogin() {
			ModelAndView view = new ModelAndView();
			view.setViewName("board/login");
			return view;
		}
		
		@RequestMapping(value="/login/doLogin")
		public ModelAndView doLogin(
				@RequestParam(value="pwd") String pwd, HttpSession session) {
			
			ModelAndView view = new ModelAndView();
			
			if(pwd.equals("1234")){
				session.setAttribute("_MEMBER_", "1");
				view.setViewName("redirect:/list/");
			}
			return view;
		}
		
		/**
		 * void 타입의 메소드
		 * RequestMapping에 의해서 요청을 받았으므로
		 * 반드시 응답을 해주어야 한다.
		 * @param response
		 * @throws IOException
		 */
		@RequestMapping("/hello")
		public void helloAjax(HttpServletResponse response) throws IOException {
			
			//순수 text로 응답을 해주겠다.
			response.setContentType("text/plain");
			//응답하는 Text의 인코딩을 설정한다.
			response.setCharacterEncoding("UTF-8");
			
			//Respons Bodye에 응답을 싣기 위해서 Writer 객체를 하나 가져온다.
			PrintWriter writer = response.getWriter();
			
			//가져온 Write 객체에 응답할 Text를 작성한다.
			writer.write("안녕하세요!");
			
			writer.flush();
			writer.close();
		}
}
