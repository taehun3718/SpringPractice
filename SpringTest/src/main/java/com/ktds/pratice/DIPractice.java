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
		
		//�������̽��� ����� ������� ����
		//����� ȣ������� �˰� ���� == > ���� ����.(�������������� �־�.)
		
//		DIPracticeDaoImpl diPracticeDao = new DIPracticeDaoImpl();
//		DIPracticeBizImpl diPracticeBiz = new DIPracticeBizImpl();
		

//		new Ű���带 ���� ��(������ ����)
//		DIPracticeDao diPracticeDao = new DIPracticeDaoImpl();
//		DIPracticeBiz diPracticeBiz  = new DIPracticeBizImpl();
//		diPraticeBiz.setDiPracticeDao(diPracticeDao);
		
//		Factory�� �̿��ؼ� ������� ��. �ٴ� ���� �Ⱦ�
//		DIPracticeBiz diPracticeBiz = DIPracticeBizFactory.getDIPracticeBizFactory();
//		
//		String someString = diPracticeBiz.getSomeString();
//		System.out.println(someString);
		
		//�������� ������ ���� Code
		String configLocation = "classpath:spring/applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		DIPracticeBiz diPracticeBiz = ctx.getBean("diPracticeBiz", DIPracticeBiz.class); //diPracticeBiz�� DIPractice�� ��� ���� ���� �ϳ��̴�.
		//bean�� Ŭ�����̴�.
		String someString = diPracticeBiz.getSomeString();
		System.out.println(someString);
		
	
	}
}
