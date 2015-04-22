package com.ktds.christof_kim.bbs.exception;

public class IndexNotAccessException extends RuntimeException{
	
	public IndexNotAccessException(){
		super();
	}
	
	public IndexNotAccessException(String message) {
		super(message);
	}
	
	public IndexNotAccessException(Throwable t) {
		super(t.getMessage());
	}
	
	public IndexNotAccessException(String message, Throwable t) {
		super(message, t);
	}
}
