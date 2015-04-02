package com.ktds.pratice;

import com.ktds.pratice.biz.DIPracticeBiz;
import com.ktds.pratice.biz.DIPracticeBizImpl;
import com.ktds.pratice.dao.DIPracticeDao;
import com.ktds.pratice.dao.DIPracticeDaoImpl;

public class DIPractice {
	
	public static void main(String[] args){
		
		//인터페이스를 만들고 써먹지를 않음
		//어떤것이 호출될지를 알고 있음 == > 강한 결합.(유지보수에서는 최악.)
		DIPracticeDao diPracticeDao = new DIPracticeDaoImpl();
		DIPracticeBiz diPraticeBiz  = new DIPracticeBizImpl();
		
		//new 키워드를 빼야 됨(의존성 관계)
		
		diPraticeBiz.setDiPracticeDao(diPracticeDao);
		
		String someString = diPraticeBiz.getSomeString();
		System.out.println(someString);
	}
}
