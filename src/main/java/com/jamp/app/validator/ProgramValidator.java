package com.jamp.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jamp.app.domain.Program;


public class ProgramValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Program.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", "Name is required.");
	}
}
