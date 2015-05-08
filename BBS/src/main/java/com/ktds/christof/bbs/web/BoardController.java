package com.ktds.christof.bbs.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof.bbs.service.BoardService;
import com.ktds.christof.bbs.vo.ArticleVO;
import com.ktds.christof.common.exception.InvalidFileUploadException;
//FIXME:isExist
//FIXME:mkdirs
import com.ktds.christof.commons.FileManager;

@Controller
public class BoardController {

	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
	}

	@RequestMapping("/board/write")
	public ModelAndView write() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/board/write");
		return view;
	}
	
	@RequestMapping("/board/doWrite")
	public ModelAndView doWrite(ArticleVO articleVO) { 
		
		FileManager fm 
			= new FileManager(articleVO.getFileOne()
							, articleVO.getFileTwo()
							, "uploadFile");
		System.out.println("file1:" + articleVO.getFileOne().getOriginalFilename());
		if(articleVO.getFileOne()==null && articleVO.getFileTwo()!=null) {
			System.out.println("?");
			throw new InvalidFileUploadException("ù��° ������ ���ε� �� �ּ���.");
		}
		else if(articleVO.getFileOne()==null && articleVO.getFileTwo()==null) {
			
			//���ε�(fileOne, fileTwo)�� ���� ���� ��� ������ ���ε� ���� �ʴ´�.
			ModelAndView view = new ModelAndView();
			boardService.writeArticle(articleVO);
			view.setViewName("redirect:/board/articleList");
			return view;
		}
		else {
			//������ ���ε� �Ѵ�.
			System.out.println("Upload");
			fm.transfer();
			boardService.writeArticle(articleVO);
			ModelAndView view = new ModelAndView();
			view.setViewName("redirect:/board/articleList");
			return view;
		}
		
	}
	
	@RequestMapping("/board/articleList")
	public ModelAndView articleList() {
		ModelAndView view = new ModelAndView();
		List<ArticleVO> articleList = boardService.articleList();
		System.out.println(articleList);
		view.addObject("articleList", articleList);
		view.setViewName("/board/articleList");
		return view;
	}
	
	@RequestMapping("/board/articleDetail/{boardId}")
	public ModelAndView articleDetail(@PathVariable int boardId) {
		ModelAndView view = new ModelAndView();
		ArticleVO articleVO = boardService.articleDetail(boardId);
		view.addObject("articleVO", articleVO);
		view.setViewName("/board/articleDetail");
		return view;
	}
	
	@RequestMapping("/board/modify/{articleId}")
	public ModelAndView modify(@PathVariable int articleId) {
		ModelAndView view = new ModelAndView();
		ArticleVO articleVO = boardService.articleDetail(articleId);
		view.addObject("articleVO", articleVO);
		view.setViewName("/board/modify");
		return view;
	}
	
	@RequestMapping("/board/doModify")
	public String doModify(ArticleVO articleVO) {
		ModelAndView view = new ModelAndView();
		String boardId  = boardService.modifyArticle(articleVO);
		return "redirect:/board/articleDetail/"+boardId+"";
	}
	
	@RequestMapping("/board/doDelete/{articleId}")
	public ModelAndView doDelete(@PathVariable int articleId) {
		ModelAndView view = new ModelAndView();
		boardService.deleteArticle(articleId);
		
		
		view.setViewName("redirect:/board/articleList");
		return view;
	}
}
