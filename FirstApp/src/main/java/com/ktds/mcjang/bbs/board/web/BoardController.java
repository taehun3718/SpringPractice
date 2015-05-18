package com.ktds.mcjang.bbs.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.mcjang.bbs.board.exception.InvalidAccessException;
import com.ktds.mcjang.bbs.board.exception.NotFoundTableNameException;
import com.ktds.mcjang.bbs.board.service.BoardService;
import com.ktds.mcjang.bbs.board.vo.ArticleVO;
import com.ktds.mcjang.bbs.board.vo.BoardVO;
import com.ktds.mcjang.bbs.common.AjaxUtil;
import com.ktds.mcjang.bbs.common.CalendarUtil;
import com.ktds.mcjang.bbs.common.grade.service.GradeService;
import com.ktds.mcjang.bbs.common.grade.vo.GradeInfoVO;

@Controller
public class BoardController {

	private BoardService boardService;
	private GradeService gradeService;
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/board/domake")
	public ModelAndView makeTable(@Valid BoardVO boardVO, Errors errors) {
		
		ModelAndView view = new ModelAndView();
		
		if(errors.hasErrors()) {
			view.setViewName("redirect:/board/make");
		}
		else{
		
			// TableName으로 허용되는 문자들
			String validChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_";
			
			String tableCode = boardVO.getBoardCode();
			tableCode = tableCode.trim().toUpperCase();
			boardVO.setBoardCode(tableCode);
			
			// 받아온 변수를 한글자씩 분리시켜 배열에 넣는다.
			char[] chrs = tableCode.toCharArray();
			
			boolean isValidName = true;
			
			// 떼어낸 글자가 validChar에 있는지 확인한다.
			for(char character : chrs) {
				if(validChar.indexOf(character + "")==-1){				
					isValidName = false;
					break;
				}
			}
			
			if(isValidName){
				this.boardService.createReplyTableWithReplyTable(boardVO);	
				this.boardService.createReplySequenceWithReplySequence(boardVO);
				view.setViewName("redirect:/board/list");
			}
			else {
				view.setViewName("redirect:/board/make");
			}
		}
		return view;
	}	
		
	
	@RequestMapping("/board/make")
	public ModelAndView viewBoardMakePage() {
		
		ModelAndView view  =  new ModelAndView();
		view.setViewName("board/make");
		
		List<GradeInfoVO> gradeList
			= this.gradeService.getDefaultGrade();
		view.addObject("gradeList", gradeList);
		
		List<GradeInfoVO> memberGradeList 
			= this.gradeService.getMemberGradeList();
		view.addObject("memberGradeList", memberGradeList);
		return view;
		
	}
	
	@RequestMapping("/board/{tableName}/write")
	public ModelAndView writeArticle(@PathVariable String tableName) {
		
		if( !this.boardService.isExistTable(tableName)) {
			throw new NotFoundTableNameException(tableName + "을 찾을 수 없습니다.");
		}
		
		if( !this.boardService.isValidAuthorization(tableName, "c_ID") ) {	//* c_id는 현재 새션에 저장되있다고 가정하고 로그인된 id 이름*/
			throw new InvalidAccessException("접근권한이 없습니다. 관리자에게 문의하세요!");
		}
		
		ModelAndView view  =  new ModelAndView();
		view.addObject("tableName", tableName);
		view.setViewName("board/view/write");
		
		return view;
	}
	
	@RequestMapping("/board/{tableName}/doWrite")
	public ModelAndView doWrite(
			@PathVariable String tableName, ArticleVO articleVO) {
		
		if( !this.boardService.isExistTable(tableName)) {
			throw new NotFoundTableNameException(tableName + "을 찾을 수 없습니다.");
		}
		
		
		if( !this.boardService.isValidAuthorization(tableName, "c_ID") ) {	//* c_id는 현재 새션에 저장되있다고 가정하고 로그인된 id 이름*/
			throw new InvalidAccessException("접근권한이 없습니다. 관리자에게 문의하세요!");
		}
		
		//업로드된 파일을 가져온댜.
		MultipartFile uploadedFile = articleVO.getUploadFile();

		if(uploadedFile !=null) {
			//파일이 저장될 경로를 지정한다.
			String uploadedFileName = uploadedFile.getOriginalFilename();
			String randomFileName = UUID.randomUUID().toString();
			
			articleVO.setRealFileName(uploadedFileName);
			articleVO.setRandomFileName(randomFileName);
			
			CalendarUtil cal = CalendarUtil.getInstance();
			String dirFormat = "d:\\uploadedFiles_" + cal.getCurrentDateFormat();
			File destFileDir = new File(dirFormat);
			
			if(!destFileDir.exists()) {
				destFileDir.mkdirs();
			}
			
			
			//D:\\uploadedFiles 폴더에 저장한다.
			File destFile= new File(dirFormat, articleVO.getRandomFileName());
			try {
				uploadedFile.transferTo(destFile);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		articleVO.setMemberId("u_ID");
		this.boardService.writeArticle(tableName, articleVO);
		
		ModelAndView view = new ModelAndView();
		return view;
	}
	
	
	@RequestMapping("/board/isDuplicateTable")
	public void isDuplicateTable(@RequestParam String tableCode, 
			HttpServletResponse response) {
		boolean isDuplicateTable = this.boardService.isExistTable(tableCode);
		AjaxUtil.sendResponse(response, isDuplicateTable + "");
	}
	
	@RequestMapping("/board/{tableName}/list")
	public ModelAndView tableList(@PathVariable String tableName, 
			HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		
		boolean isDuplicateTable = this.boardService.isExistTable(tableName);
		
		if(!isDuplicateTable) {
			//테이블이 존재하지 않을때 처리
			throw new NotFoundTableNameException();
		}
		//TODO: tableName에 대한 리스트를 받게 해주세염.
		List<BoardVO> articleList = this.boardService.getTableList(tableName);
		
		view.addObject("articleList", articleList);
		view.setViewName("/board/view/articleList");
		
		return view;
	}
	
	@RequestMapping("/board/{tableName}/list/{articleId}")
	public void tableDetail(
			@PathVariable String tableName
			, @PathVariable int articleId) {
		boolean isDuplicateTable = this.boardService.isExistTable(tableName);
		
		if(!isDuplicateTable) {
			//테이블이 존재하지 않을때 처리
			throw new NotFoundTableNameException();
		}
		
		//TODO: tableName의 게시물의 세부정보를 받게 해주세염.
		BoardVO boardVO = this.boardService.getArticleById(tableName, articleId);
	}
	
	@RequestMapping("/doUpload")
	public ModelAndView doUpload() {
		return null;
	}
	
	@RequestMapping("/board/{tableName}/download/{articleId}/{date}")
	public void fileDownload(@PathVariable String tableName,
							@PathVariable int articleId,
							@PathVariable String date,
							HttpServletRequest request,
							HttpServletResponse response) {
		ArticleVO fileInfo = this.boardService
								.getFileInfo(tableName,articleId);
		System.out.println("fileInfo.getRandomFileName() :" + fileInfo.getRandomFileName() + "/" + fileInfo.getRealFileName());
		File downloadFile = new File("d:\\uploadedFiles_" + date + "\\" + fileInfo.getRandomFileName());
		logger.info("tableName{} articleId{} downloadFile{}"
				, tableName
				, articleId
				, downloadFile);
		try{
			if(downloadFile==null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
				
			}
			
			response
				.setContentType("application/download; charset=UTF-8");
			response.setContentLength((int)downloadFile.length());
			//사용자의 브라우저 종류를 가져온다.
			String userAgent = request.getHeader("User-Agent");
			//Microsoft Internet Explorer
			boolean isMsie = userAgent.indexOf("MSIE") > -1;
			String fileName = null;
			if(isMsie) {
				fileName = URLEncoder.encode(
						fileInfo.getRealFileName(), "utf-8");
			}
			else {
				fileName = new String(fileInfo.getRealFileName().getBytes("UTF-8")
						, "ISO-8859-1");
			}
			response.setHeader("Content-Disposition", 
					"attachment; fileName=\"" + fileName + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			OutputStream out = response.getOutputStream();
			FileInputStream fis = null;
			
			try {
				fis = new FileInputStream(downloadFile);
				FileCopyUtils.copy(fis, out);
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
		catch(FileNotFoundException fnfe) {
			throw new RuntimeException(fnfe.getMessage(), fnfe);
		}
		catch(UnsupportedEncodingException uee) {
			throw new RuntimeException(uee.getMessage(),uee);
		}
		catch(IOException ie){
			throw new RuntimeException(ie.getMessage(), ie);
		}
	}
}
