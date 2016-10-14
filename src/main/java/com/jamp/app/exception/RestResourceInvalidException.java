package com.jamp.app.exception;

public class RestResourceInvalidException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public RestResourceInvalidException() {
	}
	
	public RestResourceInvalidException(Throwable e) {
		super(e);
	}
}
