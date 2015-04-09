package com.ktds.christof_kim;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class Main {
	
	public static void main(String[] args) {
		
	/*	Hello hello = new Hello();
		Bye bye = new Bye();
		
		hello.hello();
		hello.hello("KIN");
		
		bye.bye();
		bye.bye("KIN");
	 */	
	
		String contextLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(contextLocation);
		
		Hello hello = ctx.getBean("hello", Hello.class);
		Bye bye = ctx.getBean("bye", Bye.class);
		
		hello.hello();
		bye.bye();
	}

}
