package com.ktds.mcjang.bbs.board.exception;

public class NotFoundTableNameException extends RuntimeException{
	
	
	public NotFoundTableNameException() {
		super();
		
	}
	
	public NotFoundTableNameException(String message) {
		super(message);
		
	}
	
	public NotFoundTableNameException(Throwable t) {
		super(t);
	}
	
	public NotFoundTableNameException(String message, Throwable t) {
		super(message, t);
	}
}
