package com.ktds.christof_kim.web.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.web.mvc.vo.MemberRegisterRequestVO;

@Controller
public class ParamTransmitController {

	/**
	 * 실무에서 표준이 되다 싶은 파라미터 전송 방법. <br>
	 * URL에 직접 Id를 요청함으로써 파라미터를 전송할 수 있음<br> 
	 * @param paramId
	 * @return 뷰
	 */
	@RequestMapping("/params/{paramId}")
	public ModelAndView exampleOf_URIParam(@PathVariable String paramId) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/paramViewOne");
		view.addObject("welcomeMessage", paramId + "님 환영합니다.");
		
		return view;
	}
	
	/**
	 * HttpServletRequest를 테스트하기 위한 주소  
	 * transmitDataToParamViewTwo.jsp  
	 * --> paramHttpServletRequest
	 * --> paramViewTwo.jsp
	 * @return 테스팅 뷰
	 */
	@RequestMapping("/transmitDataEx01")
	public ModelAndView transmitDataViewOne() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/transmitDataToParamViewOne");
		return view;
	}
	
	@RequestMapping("/transmitDataEx02")
	public ModelAndView transmitDataViewTwo() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/transmitDataToParamViewTwo");
		return view;
	}
	
	@RequestMapping("/transmitDataEx03")
	public ModelAndView transmitDataViewThree() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/transmitDataToCommandObject");
		return view;
	}

	/**
	 * HttpServletRequest 파라미터를 이용하여 직접 id를 얻는 방법. get/post가능
	 * @param request
	 * @return paramViewTwo
	 */
	@RequestMapping("/paramHttpServletRequest")
	public ModelAndView exampleOf_HttpServletRequest(HttpServletRequest request) {

		String id = request.getParameter("id");

		ModelAndView view = new ModelAndView();
		view.setViewName("/paramViewTwo");
		view.addObject("userId", id);
		
		return view;
	}
	/**
	 * HttpServletRequest 파라메터를 이용하여 직접 id를 얻는 방법. GET만가능
	 * @param request
	 * @return paramViewTwo
	 */
	@RequestMapping(value="/paramHttpServletRequestGet", method=RequestMethod.GET)
	public ModelAndView exampleOf_HttpServletRequestGet(HttpServletRequest request) {

		String id = request.getParameter("id");

		ModelAndView view = new ModelAndView();
		view.setViewName("/paramViewTwo");
		view.addObject("userId", id);
		
		return view;
	}
	/**
	 * HttpServletRequest 파라메터를 이용하여 직접 id를 얻는 방법. POST만만가능
	 * @param request
	 * @return paramViewTwo
	 */
	@RequestMapping(value="/exampleOf_HttpServletRequestPOST", method=RequestMethod.POST)
	public ModelAndView exampleOf_HttpServletRequestPOST(HttpServletRequest request) {

		String id = request.getParameter("id");

		ModelAndView view = new ModelAndView();
		view.setViewName("/paramViewTwo");
		view.addObject("userId", id);
		
		return view;
	}
	
	
	/**
	 * RequestParam어노테이션을 이용하여 직접 id를 얻는 방법. get/post가능
	 * @return paramViewTwo
	 */
	@RequestMapping("/exampleOf_RequestParam")
	public ModelAndView exampleOf_RequestParam(@RequestParam("id") String id) {

		ModelAndView view = new ModelAndView();
		view.setViewName("/paramViewTwo");
		view.addObject("userId", id);
		
		return view;
	}
	
	/**
	 * RequestParam어노테이션을 이용하여 직접 id pwd를 얻는 방법. POST만 가능
	 * @return paramViewTwo
	 */
	@RequestMapping(value="/exampleOf_RequestParamPost", method=RequestMethod.POST)
	public ModelAndView exampleOf_RequestParamPost(@RequestParam("id") String id
												,@RequestParam("pwd") String pwd) {

		ModelAndView view = new ModelAndView();
		view.setViewName("/paramViewTwo");
		view.addObject("userId", id);
		view.addObject("pwd", pwd);
		
		return view;
	}
	
	/**
	 * RequestParam어노테이션을 이용하여 직접 id를 얻는 방법. GET만 가능
	 * @return paramViewTwo
	 */
	@RequestMapping(value="/exampleOf_RequestParamGet", method=RequestMethod.POST)
	public ModelAndView exampleOf_RequestParamGet(@RequestParam("id") String id
												,@RequestParam("pwd") String pwd) {

		ModelAndView view = new ModelAndView();
		view.setViewName("/paramViewTwo");
		view.addObject("userId", id);
		view.addObject("pwd", pwd);
		
		return view;
	}
	/**
	 * Command 객체를 이용해 폼 전송 처리
	 * @param id
	 * @return paramViewThree
	 */
	@RequestMapping(value="/paramHttpServletRequest3", method=RequestMethod.POST)
	public ModelAndView exampleOf_CommandParam(MemberRegisterRequestVO memberRegisterVO) {

		ModelAndView view = new ModelAndView();
		view.addObject("memberRegisterVO", memberRegisterVO);
		view.setViewName("/paramViewThree");
		
		return view;
	}
	/**
	 * index.jsp
	 * @return index
	 */
	@RequestMapping("/")
	public ModelAndView mainView() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/index");
		
		return view;
	}
}
