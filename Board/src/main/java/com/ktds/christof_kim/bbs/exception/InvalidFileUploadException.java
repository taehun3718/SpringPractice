package com.ktds.christof_kim.bbs.exception;

public class InvalidFileUploadException extends RuntimeException{
	
	public InvalidFileUploadException() {
		super();
	}
	
	public InvalidFileUploadException(String msg) {
		super(msg);
	}
	
	public InvalidFileUploadException(Throwable t) {
		super(t.getMessage());
	}
	
	public InvalidFileUploadException(String msg, Throwable t) {
		super(msg, t);
	}
}
