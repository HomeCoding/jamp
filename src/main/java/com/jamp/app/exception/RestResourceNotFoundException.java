package com.jamp.app.exception;

public class RestResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public RestResourceNotFoundException() {
	}
	
	public RestResourceNotFoundException(String message) {
		super(message);
	}

}
