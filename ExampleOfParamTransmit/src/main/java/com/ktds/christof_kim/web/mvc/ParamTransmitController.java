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
	 * �ǹ����� ǥ���� �Ǵ� ���� �Ķ���� ���� ���. <br>
	 * URL�� ���� Id�� ��û�����ν� �Ķ���͸� ������ �� ����<br> 
	 * @param paramId
	 * @return ��
	 */
	@RequestMapping("/params/{paramId}")
	public ModelAndView exampleOf_URIParam(@PathVariable String paramId) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/paramViewOne");
		view.addObject("welcomeMessage", paramId + "�� ȯ���մϴ�.");
		
		return view;
	}
	
	/**
	 * HttpServletRequest�� �׽�Ʈ�ϱ� ���� �ּ�  
	 * transmitDataToParamViewTwo.jsp  
	 * --> paramHttpServletRequest
	 * --> paramViewTwo.jsp
	 * @return �׽��� ��
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
	 * HttpServletRequest �Ķ���͸� �̿��Ͽ� ���� id�� ��� ���. get/post����
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
	 * HttpServletRequest �Ķ���͸� �̿��Ͽ� ���� id�� ��� ���. GET������
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
	 * HttpServletRequest �Ķ���͸� �̿��Ͽ� ���� id�� ��� ���. POST��������
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
	 * RequestParam������̼��� �̿��Ͽ� ���� id�� ��� ���. get/post����
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
	 * RequestParam������̼��� �̿��Ͽ� ���� id pwd�� ��� ���. POST�� ����
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
	 * RequestParam������̼��� �̿��Ͽ� ���� id�� ��� ���. GET�� ����
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
	 * Command ��ü�� �̿��� �� ���� ó��
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
