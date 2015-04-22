package com.ktds.christof_kim.bbs.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.bbs.exception.IndexNotAccessException;
import com.ktds.christof_kim.bbs.service.BoardService;
import com.ktds.christof_kim.bbs.vo.BoardVO;

@Controller
public class BoardController {
	
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board/list")
	public ModelAndView boardList() {
		ModelAndView view = new ModelAndView();
		
		List<BoardVO> boardList = boardService.boardAllList();
		view.addObject("boardList",boardList);
		view.setViewName("/board/boardList");
		
		return view;
	}
	
	@RequestMapping("/board/detail/{boardId}")
	public ModelAndView boardDetail(
			@PathVariable String boardId) {
		
		ModelAndView view = new ModelAndView();
		BoardVO boardVO = boardService.getBoardDetail(boardId);
		
		view.addObject("boardVO", boardVO);
		view.setViewName("board/boardDetail");
		return view;
	}
	
	@RequestMapping("/board/write")
	public ModelAndView boardWrite() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/board/write");
		return view;
	}
	
	@RequestMapping("/board/doWrite")
	public ModelAndView boardDoWrite(BoardVO boardVO) {
		ModelAndView view = new ModelAndView();
	
		boolean isWriteSuccess = boardService.writeBoard(boardVO);
		
		if(isWriteSuccess){
			view.setViewName("redirect:/board/list");
		}
		else{
			view.setViewName("board/write");
		}
		
		return view;
	}
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		if(true) {
			throw new IndexNotAccessException("Index는 허용하지 않아여 ㅋㅋㅋ");
			
		}
		return view;
	}
}
