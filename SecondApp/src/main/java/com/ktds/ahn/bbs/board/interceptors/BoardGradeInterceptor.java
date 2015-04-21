package com.ktds.ahn.bbs.board.interceptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.ahn.bbs.board.interceptors.util.PathVariableUtil;
import com.ktds.ahn.bbs.board.service.BoardService;
import com.ktds.ahn.bbs.common.grade.service.GradeService;
import com.ktds.ahn.bbs.member.service.MemberService;

public class BoardGradeInterceptor extends HandlerInterceptorAdapter {

	public String value = "";
	private String requestURI;
	private String classAndMethod;
	
	
	private Logger logger= LoggerFactory.getLogger(BoardGradeInterceptor.class);
	private BoardService boardService;
	private MemberService memberService;
	private GradeService gradeService;
	

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}
	/**
	 * preHandle : Controller를 실행하기 전에 실행됨<br/>
	 * 인가(권한 처리)를 처리하기 위한 준비 과정 중 하나
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//logger.info("인터셉터가 실행되었음.");
		
		/*this.requestURI = request.getRequestURI();*/
		this.requestURI = PathVariableUtil.getFullURI(request);
		classAndMethod = handler.toString();
		
		logger.info(this.requestURI);
		logger.info(this.classAndMethod);
		List<String> writeList = new ArrayList<String>();
		writeList.add("/SecondApp/board/write");
		writeList.add("/SecondApp/board/doWrite");

		List<String> viewList = new ArrayList<String>();
		viewList.add("/SecondApp/board/list");
		viewList.add("/SecondApp/board/detail/{articleId}");
		viewList.add("/SecondApp/board/detail/download/{articleId}");
		
		List<String> uriList = new ArrayList<String>();
		uriList.addAll(viewList);
		uriList.addAll(writeList);
		
		
		boolean isValidGrade = false;
		
		if(uriList.contains(requestURI)) {
			if(writeList.contains(requestURI)) {
				//쓰기 권한 체크
											//isValidGradeByGradeIdx("테이블 접근권한", "현재 사용자 권한");
				isValidGrade = gradeService.isValidGradeByGradeIdx("2", "7");
			}
			else {
				//읽기 권한 체크
				isValidGrade = gradeService.isValidGradeByGradeIdx("7", "7");
				
				if(isValidGrade) {
					if(requestURI.equals("/SecondApp/board/list")) {
						//이 게시물을 읽을 수 있는 권한이 있는지 확인한다.
						isValidGrade = gradeService.isValidGradeByGradeIdx("6", "7");
					}
				}
			}
		}
		/*
		 * PathVariable Data를 가져온다.
		 */
		
		Map<String, Object> pathVariables = 
				(Map<String, Object>)request.getAttribute(
						HandlerMapping
						.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		if(!isValidGrade) {
			//response.sendRedirect("http:///www.naver.com");
			response.sendError(403);
			return false;
		}
		
		/*
		 * 
		 * Request Param Data를 가져온다.
		 */
		
		/*Map<String, String[]> params = 
				request.getParameterMap();
		
		if(pathVariables != null) {
			Set<String> keySet = params.keySet();
			Iterator<String> keys = params.keySet().iterator();
			
			String key = "";
			String value = "";
			
			while(keys.hasNext()) {
				key = keys.next();
				value = params.get(key)[0].toString();
				
				logger.info("ParamKey:{}", key);
				logger.info("ParamValue:{}", value);
				
				if(uriList.contains(requestURI)) {
					
				}
			}
		
		}*/
		
		return true;	//true를 해야 만 다음으로 이어짐
	}
}
