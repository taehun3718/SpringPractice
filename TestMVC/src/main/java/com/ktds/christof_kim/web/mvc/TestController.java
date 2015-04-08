package com.ktds.christof_kim.web.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof_kim.web.mvc.vo.MemberRegisterRequestVO;

@Controller
public class TestController {
	
	//이 URL로 들어오면 내가 처리할께
	@RequestMapping("/helloWorld")//hello 메세지를 출력하는 URI
	public String test(){
		
		//       PREFIX      | SUFIX
		// /WEB-INF/view/test/test.jsp
		return "test/hello";
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2() {
		
		ModelAndView view = new ModelAndView();
		
		view.setViewName("test/test2");
		view.addObject("helloMessage", "Hello!");	//Key, Value
		view.addObject("byeMessage", "bye bye");
		
		//뷰를 리턴하면 jsp를 리턴하게 되어 있음
		return view;
		
	}
	
	@RequestMapping(value="/test4", method=RequestMethod.GET)
	public ModelAndView test4() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("test/test2");
		return view;
	}
	
	@RequestMapping(value="/test5", method=RequestMethod.POST)
	public ModelAndView test5() {
		
		ModelAndView view = new ModelAndView();
		return view;
	}
	
	
	@RequestMapping("/members/{memberId}")
	public ModelAndView test6(@PathVariable String memberId){
		ModelAndView view = new ModelAndView();
		
		view.setViewName("test/test6");
		view.addObject("welcomeMessage", memberId + "님 환영합니다.!");
		
		return view;
		
	}
	
	
	
//	public ModelAndView test7(@RequestParam("id") String id) {
//	public ModelAndView test7(@RequestParam(value="id", required=false, defaultValue="파라미터가 없습니다.") String id) {
	@RequestMapping("/test7")
	public ModelAndView test7(@RequestParam(value="id", required=false)String id) {	
		//요청되는 Param이 id인데 파라미터가 없을 때 그리고 required=false일 때 defaultValue를 지정할 수 있음
		//defaultValue가 있으면 그걸로 주기때문에 에러는 없심
		//
		//요청되는 Param이 id인데 파라미터가 없을 때 그리고 required=true일 때 이것만큼은 보내줘! 라고 강제로..(안보내주면 에러뜸..ㅋㅋ)
		//defaultValue가 있으면 그걸로 주기때문에 에러는 없심
		ModelAndView view = new ModelAndView();
		view.setViewName("test/test7");
		view.addObject("userId", id);
		
		return view;
	}
	/*public ModelAndView test7(HttpServletRequest request){
		
		ModelAndView view = new ModelAndView();
		view.setViewName("test/test7");
		
		String id = request.getParameter("id");
		view.addObject("userId", id);
		
		return view;
	}*/
	
	/*@RequestMapping(value="/test9", method=RequestMethod.POST)
	public ModelAndView test9(MemberRegisterRequestVO memberRegister){
		ModelAndView view = new ModelAndView();
		view.setViewName("test/test9");
		
		System.out.println("이름" + memberRegister.getName());
		System.out.println("비번" + memberRegister.getPassword());
		System.out.println("이메일" + memberRegister.getEmail());
		
		System.out.println(memberRegister.isCheck());
		
		List<String> names = memberRegister.getNames();
		for(String name: names){
			System.out.println("LIST:" + name);
		}
		return view;
		
	}*/
	@RequestMapping(value="/test9", method=RequestMethod.POST)
	public ModelAndView test9(
			@Valid MemberRegisterRequestVO memberRegisterVO, Errors errors){
		ModelAndView view = new ModelAndView();
		view.setViewName("test/test2");
		view.addObject("memberRegisterVO", memberRegisterVO);
		
		System.out.println("이름" + memberRegisterVO.getName());
		System.out.println("비번" + memberRegisterVO.getPassword());
		System.out.println("이메일" + memberRegisterVO.getEmail());
		
		System.out.println(memberRegisterVO.isCheck());
		
		if(errors.hasErrors()){
			System.out.println("에러가 존재합니다.");
		}
		else {
			System.out.println("에러가 존재하지 않습니다.");
		}
		
		List<String> names = memberRegisterVO.getNames();
		for(String name: names){
			System.out.println("LIST:" + name);
		}
		return view;
		
	}
}
