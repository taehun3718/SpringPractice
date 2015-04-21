package com.ktds.ahn.bbs.board.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ahn.bbs.board.exception.InvalidAccessException;
import com.ktds.ahn.bbs.board.service.BoardService;
import com.ktds.ahn.bbs.board.vo.ArticleVO;

@Controller
public class BoardController {

	//private GradeService gradeService 삭제;
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/board/write")
	public ModelAndView writeArticle() {
		
		if ( !this.boardService.isValidAuthorization("qqq") ) {
			throw new InvalidAccessException("접근 권한이 없습니다. 관리자에 문의하세요.");
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/board/view/write");
		return view;
	}
	
	@RequestMapping("/board/doWrite")
	public ModelAndView doWrite(ArticleVO articleVO) {
		
		if ( !this.boardService.isValidAuthorization("qqq") ) {
			throw new InvalidAccessException("접근 권한이 없습니다. 관리자에 문의하세요.");
		}
		
		// 업로드된 파일을 가져온다
		MultipartFile uploadedFile = articleVO.getUploadFile();
		
		if ( uploadedFile != null ) {
			// 파일이 저장될 경로를 지정한다
			String uploadedFileName = uploadedFile.getOriginalFilename();
			String randomFileName = UUID.randomUUID().toString();
			
			articleVO.setRealFileName(uploadedFileName);
			articleVO.setRandomFileName(randomFileName);
			
			File destFileDir = new File("d:\\uploadedFiles");
			if ( !destFileDir.exists() ) {
				destFileDir.mkdirs();
			}
			
			// d:\\uploadedFiles 폴더에 저장한다
			File destFile = new File("d:\\uploadedFiles", randomFileName);
			try {
				uploadedFile.transferTo(destFile);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		articleVO.setMemberId("qqq");
		this.boardService.writeArticle(articleVO);
		
		ModelAndView view = new ModelAndView();
		return view;
	}
	
	@RequestMapping("/board/list")
	public ModelAndView viewArticleList() {
	
	/*	if ( !this.boardService.isValidAuthorization("qqq") ) {
			throw new InvalidAccessException("접근 권한이 없습니다. 관리자에 문의하세요.");
		}
*/		
		ModelAndView view = new ModelAndView();
		
		List<ArticleVO> allArticleList = this.boardService.getAllArticleList();
		view.addObject("allArticleList", allArticleList);
		view.setViewName("board/article/articleList");
		
		return view;
	}
	
	@RequestMapping("/board/download/{articleId}")
	public void fileDownload(@PathVariable int articleId,
								HttpServletRequest requset,
								HttpServletResponse response) {
		
		ArticleVO fileInfo = this.boardService.getFileInfo(articleId);
		
		File downloadFile = new File("d:\\uploadedFiles\\" + fileInfo.getRandomFileName() );
		
		
		try {
				
			if ( downloadFile == null ) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			response.setContentType("applicaton/download; charset=utf-8");
			response.setContentLength((int)downloadFile.length());
			
			// 사용자의 브라우저 종류를 가져온다
			String userAgent = requset.getHeader("User-Agent");
			boolean isMsie = userAgent.indexOf("MSIE") > -1;
			
			String fileName = null;
			
			if ( isMsie ) {
				fileName = URLEncoder.encode(fileInfo.getRealFileName(), "UTF-8");
			}
			
			else {
				fileName = new String(fileInfo.getRealFileName().getBytes("UTF-8"), "ISO-8859-1");
			}
			
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			OutputStream out = response.getOutputStream();
			FileInputStream fis = null;
			
			try { 
				fis = new FileInputStream(downloadFile);
				FileCopyUtils.copy(fis, out);
				out.flush();
			}
			
			finally {
				if ( fis != null ) {
					fis.close();
				}
				if ( out != null ) {
					fis.close();
				}
			}
		}
		
		catch(Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	@RequestMapping("/board/detail/{articleId}")
	public ModelAndView viewArticleDetail(@PathVariable int articleId) {
		
		/*if ( !this.boardService.isValidAuthorization("qqq") ) {
			throw new InvalidAccessException("접근 권한이 없습니다. 관리자에 문의하세요.");
		}
*/		
		ArticleVO article = this.boardService.getArticleInfoById(articleId);
		
		ModelAndView view = new ModelAndView();
		view.addObject("article", article);
		view.setViewName("board/article/detail");
		return view;
	}
	
}
