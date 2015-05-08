package com.ktds.christof.common.exception;

public class InvalidFileUploadException extends RuntimeException {
	public InvalidFileUploadException() {
		super();
	}

	public InvalidFileUploadException(String message) {
		super(message);
	}
	
	public InvalidFileUploadException(Throwable t) {
		super(t.getMessage());
	}
	
	public InvalidFileUploadException(String message, Throwable t) {
		super(message, t);
	}
}
