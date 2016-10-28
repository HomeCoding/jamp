package com.jamp.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jamp.app.domain.User;
import com.jamp.app.service.UserService;

public class UserValidator implements Validator {
	private static final int PASSWORD_MAX_LENGTH = 32;
	private static final int PASSWORD_MIN_LENGTH = 3;
	private static final int EMAIL_MAX_LENGTH = 32;
	private static final int EMAIL_MIN_LENGTH = 6;
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (user.getEmail().length() < EMAIL_MIN_LENGTH || user.getEmail().length() > EMAIL_MAX_LENGTH) {
            errors.rejectValue("email", "Size.userForm.email");
        }
        if (userService.getByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }        
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < PASSWORD_MIN_LENGTH || user.getPassword().length() > PASSWORD_MAX_LENGTH) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
	}
}
