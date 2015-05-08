package com.ktds.christof_kim.bbs.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.bbs.exception.IndexNotAccessException;
import com.ktds.christof_kim.bbs.exception.InvalidFileUploadException;
import com.ktds.christof_kim.bbs.service.BoardService;
import com.ktds.christof_kim.bbs.vo.BoardVO;

@Controller
public class BoardController {
	
	private BoardService boardService;
	private Logger logger = LoggerFactory.getLogger(BoardController.class);	
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board/list")
	public ModelAndView articleList() {
		ModelAndView view = new ModelAndView();
		
		List<BoardVO> boardList = boardService.articleAllList();
		view.addObject("boardList",boardList);
		view.setViewName("/board/boardList");
		
		return view;
	}
	
	@RequestMapping("/board/detail/{boardId}")
	public ModelAndView articleDetail(
			@PathVariable String boardId) {
		
		ModelAndView view = new ModelAndView();
		BoardVO boardVO = boardService.getArticleDetailById(boardId);
		System.out.println(boardVO.getUUIDFileOne());
		System.out.println(boardVO.getUUIDFileTwo());
		view.addObject("boardVO", boardVO);
		view.setViewName("/board/boardDetail");
		return view;
	}
	
	@RequestMapping("/board/write")
	public ModelAndView articleWrite() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/board/write");
		return view;
	}
	
	@RequestMapping("/board/doWrite")
	public ModelAndView articleDoWrite(BoardVO boardVO) {
		
		MultipartFile uploadFileOne = boardVO.getFileOne();
		MultipartFile uploadFileTwo = boardVO.getFileTwo();
		
		logger.info("Upload file:{} {}"
				, uploadFileOne
				, uploadFileTwo);
		
		File fileOne = null;
		File fileTwo = null;
		
		try {
			
			if(uploadFileOne==null) {
				throw new InvalidFileUploadException("첫번째 업로드 파일은 필수입니다.");
			}
			else if(uploadFileOne !=null && uploadFileTwo == null){
				fileOne = new File("D:\\Upload\\" + boardVO.getUUIDFileOne());
				uploadFileOne.transferTo(fileOne);
			}
			else {
				fileOne = new File("D:\\Upload\\" +  boardVO.getUUIDFileOne());
				fileTwo = new File("D:\\Upload\\" +  boardVO.getUUIDFileTwo());
				
				uploadFileOne.transferTo(fileOne);
				uploadFileTwo.transferTo(fileTwo);
			}
		} 
		catch (IllegalStateException e) {
			throw new RuntimeException(e);
		} 
		catch (IOException ie) {
			throw new RuntimeException(ie);
		}
		
		ModelAndView view = new ModelAndView();
		
		boolean isWriteSuccess = boardService.writeArticle(boardVO);
		
		if(isWriteSuccess){
			view.setViewName("redirect:/board/list");
		}
		else{
			view.setViewName("/board/write");
		}
		
		return view;
	}
	
	@RequestMapping("/board/modify/{id}")
	public ModelAndView articleModify(@PathVariable String id) {
		
		ModelAndView view = new ModelAndView();
		
		BoardVO boardVO = boardService.getArticleDetailById(id);
		
		view.addObject("boardVO", boardVO);
		view.setViewName("/board/modify");
		
		return view;
	}
	
	@RequestMapping("/board/doModify")
	public String articleDoModify(BoardVO boardVO) {
		
		int updatedBoardId = boardService.updateBoard(boardVO);
		if(updatedBoardId!=0){
			return "redirect:/board/detail/" + updatedBoardId+"/";
		}
		else{
			return "redirect:/board/modify/" + boardVO.getId();
		}
	}
	
	@RequestMapping("/board/doDelete/{articleId}")
	public String articleDoDelete(@PathVariable int articleId) {
		
		boolean isDeleted = boardService.deleteArticle(articleId);
		logger.info("deletedYN={}", isDeleted);
		if(isDeleted){
			return "redirect:/board/list";
		}
		else{
			return "redirect:/board/detail/" + articleId;
		}
	}
	
	//FIXME: DAO 파일 다운로드 구현 안됨
	@RequestMapping("/board/download/{articleId}/{fileIndex}")
	public void fileDownload(@PathVariable String articleId,
							 @PathVariable String fileIndex,
								HttpServletRequest requset,
								HttpServletResponse response) {
		
		BoardVO fileInfo;
		String originalFileName = null;;
		String UUIDFileName = null;
		if(fileIndex.equals("0")){
			fileInfo = this.boardService.getFileInfo(articleId);
			originalFileName = fileInfo.getOriginalFileOne();
			UUIDFileName = fileInfo.getUUIDFileOne();
		}
		
		else if(fileIndex.equals("1")){
			fileInfo = this.boardService.getFileInfo(articleId);
			originalFileName = fileInfo.getOriginalFileTwo();
			UUIDFileName = fileInfo.getUUIDFileTwo();
		}
		
		File downloadFile = new File("d:\\Upload\\" + UUIDFileName);
		
		
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
				fileName = URLEncoder.encode(originalFileName, "UTF-8");
			}
			
			else {
				fileName = new String(originalFileName.getBytes("UTF-8"), "ISO-8859-1");
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
	
	@RequestMapping("/file/fileList")
	public ModelAndView fileList() {
		ModelAndView view = new ModelAndView();

		List<BoardVO> boardList = boardService.articleAllList();
		
		view.addObject("boardList",boardList);
		view.setViewName("/file/fileList");
		
		return view;
	}
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		if(true) {
			throw new IndexNotAccessException("Index는 허용하지 않아여 ㅋㅋㅋ");
		}
		else {
			return view;
		}
	}
}
