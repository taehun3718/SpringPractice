package com.ktds.pratice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ktds.pratice.biz.DIPracticeBiz;
import com.ktds.pratice.biz.DIPracticeBizImpl;
//import com.ktds.pratice.biz.factory.DIPracticeBizFactory;
import com.ktds.pratice.dao.DIPracticeDao;
import com.ktds.pratice.dao.DIPracticeDaoImpl;

public class DIPractice {
	
	public static void main(String[] args){
		
		//인터페이스를 만들고 써먹지를 않음
		//어떤것이 호출될지를 알고 있음 == > 강한 결합.(유지보수에서는 최악.)
		
//		DIPracticeDaoImpl diPracticeDao = new DIPracticeDaoImpl();
//		DIPracticeBizImpl diPracticeBiz = new DIPracticeBizImpl();
		

//		new 키워드를 빼야 됨(의존성 관계)
//		DIPracticeDao diPracticeDao = new DIPracticeDaoImpl();
//		DIPracticeBiz diPracticeBiz  = new DIPracticeBizImpl();
//		diPraticeBiz.setDiPracticeDao(diPracticeDao);
		
//		Factory를 이용해서 만들었을 때. 근대 이제 안씀
//		DIPracticeBiz diPracticeBiz = DIPracticeBizFactory.getDIPracticeBizFactory();
//		
//		String someString = diPracticeBiz.getSomeString();
//		System.out.println(someString);
		
		//의존성을 가지고 오는 Code
		String configLocation = "classpath:spring/applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		DIPracticeBiz diPracticeBiz = ctx.getBean("diPracticeBiz", DIPracticeBiz.class); //diPracticeBiz는 DIPractice를 상속 받은 놈중 하나이다.
		//bean은 클래스이다.
		String someString = diPracticeBiz.getSomeString();
		System.out.println(someString);
		
	
	}
}
