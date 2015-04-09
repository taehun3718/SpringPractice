package com.ktds.christof_kim.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.board.service.BoardService;
import com.ktds.christof_kim.board.vo.ArticleVO;
import com.ktds.christof_kim.board.vo.MemberInfoVO;
import com.ktds.christof_kim.board.vo.UploadVO;
import com.ktds.christof_kim.intercept.LoginInterceptor;

@Controller
public class BoardController {

	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
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
		
		@RequestMapping("/getJson")
		@ResponseBody
		public MemberInfoVO getJson() {
			
			MemberInfoVO memberInfo = new MemberInfoVO();
			
			memberInfo.setResult(true);
			
			memberInfo.setName("김태훈");
			memberInfo.setPhoneNumber("010-2227-XXXX");
			
			return memberInfo;
		}
		
		/**
		 * MultipartHttpServletRequest : 
		 *  multipart/form-data를 전달받는 Request 객체 <br/>
		 *  
		 *  multipart/form-data를 전달 받기 위해서는 CommonsMultipartResolver가 bean으로 등록이 되어 있어야 한다.
		 * @param request
		 * @return
		 * @throws IOException 
		 * @throws IllegalStateException 
		 */
		@RequestMapping("/doUpload")
		public ModelAndView doUpload(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
			
			// MultipartHttpServletRequest에서 업로드된 파일을 가져온다.
			// 가져온 파일의 타입은 MultipartFile 이다.
			MultipartFile uploadedFile = request.getFile("file");	//보내준 이름이 file이라 file
			
			//name 파라미터를 가져온다.
			String name = request.getParameter("name");
			//업로드된 파일이 있는지 체크
			//ifEmpty는 null을 체크 해주는 메소드이다.
			if(!uploadedFile.isEmpty()) {
				//파일이 있다면, 업로드된 파일이 저장될 경로를 지정한다.
				//getOriginalFilename() 은 업로드된 파일의 이름과 확장자를 가지고 있다.
				//교제안 169페이지 참고.
				File file = new File("D:\\", uploadedFile.getOriginalFilename());
				//uploadedFile을 file로 저장한다.
				//물리적인 공간에 저장한다.
				
				uploadedFile.transferTo(file);
	
			}
			
			ModelAndView view = new ModelAndView();
			view.setViewName("test/test2");
			return view;
		}
		
		@RequestMapping("/doUpload2")
		public ModelAndView doUpload2(@Valid UploadVO uploadVO, Errors error) throws IllegalStateException, IOException {
			MultipartFile uploadedFile = uploadVO.getFile();

			//업로드된 파일이 있는지 체크
			//ifEmpty는 null을 체크 해주는 메소드이다.
			if(!uploadedFile.isEmpty()) {
				//파일이 있다면, 업로드된 파일이 저장될 경로를 지정한다.
				//getOriginalFilename() 은 업로드된 파일의 이름과 확장자를 가지고 있다.
				//교제안 169페이지 참고.
				File file = new File("D:\\", uploadedFile.getOriginalFilename());
				//uploadedFile을 file로 저장한다.
				//물리적인 공간에 저장한다.
				uploadedFile.transferTo(file);
			}
			
			ModelAndView view = new ModelAndView();
			view.setViewName("test/test2");
			return view;
		}
		
		@RequestMapping("/fileDownload/{fileNumber}")
		public void fileDownload(@PathVariable String fileNumber
								, HttpServletResponse response
								, HttpServletRequest request) throws IOException {
				
			File downloadFile = getFile(fileNumber);
			
			logger.info("다운로드!");
			if(downloadFile==null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
			
			response.setContentType("application/download; charset=utf-8");
			response.setContentLengthLong((int)downloadFile.length());
			
			String userAgent = request.getHeader("User-Agent");//
			
			boolean internetExplorer = userAgent.indexOf("MSIE") > -1;
			
			String fileName = null;
			
			if(internetExplorer) {
				fileName = URLEncoder.encode(downloadFile.getName(), "UTF-8");
				
			}
			else {
				fileName = new String(downloadFile.getName().getBytes("UTF-8"), "ISO-8859-1");
			}
			
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			//java.io.OutputStream
			OutputStream out = response.getOutputStream();
			//java.io.FileInputStream
			FileInputStream fis = null;
			
			try{
				fis = new FileInputStream(downloadFile);
				FileCopyUtils.copy(fis, out);
				out.flush();
			}
			finally {
				if(fis!=null) {
					fis.close();
				}
				if(out!=null) {
					out.close();
				}
			}
		}
		
		private File getFile(String fileField) {
			if(fileField.equals("1")) {	//db한테 원래 줘야 되는데 db연동 없이 하드코딩하게 간다.
				return new File("d:\\testRollingFile.log");
			}
			return null;
		}
}
