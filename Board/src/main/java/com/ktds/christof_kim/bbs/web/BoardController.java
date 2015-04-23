package com.ktds.christof_kim.bbs.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger logger = LoggerFactory.getLogger(BoardController.class);	
	
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
		view.setViewName("/board/boardDetail");
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
			view.setViewName("/board/write");
		}
		
		return view;
	}
	
	@RequestMapping("/board/modify/{id}")
	public ModelAndView boardModify(@PathVariable String id) {
		
		ModelAndView view = new ModelAndView();
		
		BoardVO boardVO = boardService.getBoardDetail(id);
		
		view.addObject("boardVO", boardVO);
		view.setViewName("/board/modify");
		
		return view;
	}
	
	@RequestMapping("/board/doModify")
	public String boardDoModify(BoardVO boardVO) {
		
		int updatedBoardId = boardService.updateBoard(boardVO);
		logger.info("updatedId={}", updatedBoardId );
		if(updatedBoardId!=0){
			return "redirect:/board/detail/" + updatedBoardId+"/";
		}
		else{
			return "redirect:/board/modify/" + boardVO.getId();
		}
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
