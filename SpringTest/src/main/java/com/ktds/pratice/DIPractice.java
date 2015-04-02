package com.ktds.pratice;

import com.ktds.pratice.biz.DIPracticeBiz;
import com.ktds.pratice.biz.DIPracticeBizImpl;
import com.ktds.pratice.dao.DIPracticeDao;
import com.ktds.pratice.dao.DIPracticeDaoImpl;

public class DIPractice {
	
	public static void main(String[] args){
		
		//�������̽��� ����� ������� ����
		//����� ȣ������� �˰� ���� == > ���� ����.(�������������� �־�.)
		DIPracticeDao diPracticeDao = new DIPracticeDaoImpl();
		DIPracticeBiz diPraticeBiz  = new DIPracticeBizImpl();
		
		//new Ű���带 ���� ��(������ ����)
		
		diPraticeBiz.setDiPracticeDao(diPracticeDao);
		
		String someString = diPraticeBiz.getSomeString();
		System.out.println(someString);
	}
}
