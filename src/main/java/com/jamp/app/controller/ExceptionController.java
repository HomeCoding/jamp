package com.jamp.app.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import com.jamp.app.exception.RestResourceNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handle(Exception e, HttpServletResponse response) {
		response.setStatus(500);
		ModelAndView mav = new ModelAndView("exception");
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());
		
		return mav;
	}
	
	@ExceptionHandler(RestResourceNotFoundException.class)
	public ResponseEntity<Void> handleRestNotFound() {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Void> handleValidationErrors() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
