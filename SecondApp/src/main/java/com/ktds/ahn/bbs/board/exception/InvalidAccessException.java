package com.ktds.ahn.bbs.board.exception;

public class InvalidAccessException extends RuntimeException{

	public InvalidAccessException() {
		super();
	}
	
	public InvalidAccessException(String message) {
		super(message);
	}
	
	public InvalidAccessException(Throwable t) {
		super(t);
	}
	
	public InvalidAccessException(String message, Throwable t) {
		super(message, t);
	}
}
