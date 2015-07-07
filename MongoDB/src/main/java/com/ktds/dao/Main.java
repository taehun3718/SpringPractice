package com.ktds.dao;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
	
		String url = "mongodbContext.xml";
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(url);
		
		MongoDAO dao = ctx.getBean("mongoDAO", MongoDAO.class);
		
		if(dao == null) {
			System.out.println("NULL");
		}
		else {
			System.out.println("NOT NULL");
		}
		
		dao.insertTextVO();
		
	}
}
