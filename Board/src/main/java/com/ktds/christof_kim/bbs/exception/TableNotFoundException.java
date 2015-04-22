package com.ktds.christof_kim.bbs.exception;

public class TableNotFoundException extends RuntimeException{
	
	public TableNotFoundException(){
		super();
	}
	
	public TableNotFoundException(String message) {
		super(message);
	}
	
	public TableNotFoundException(Throwable t) {
		super(t.getMessage());
	}
	
	public TableNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
