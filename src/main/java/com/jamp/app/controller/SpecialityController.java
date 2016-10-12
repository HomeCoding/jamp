package com.jamp.app.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.jamp.app.domain.Speciality;
import com.jamp.app.service.SpecialityService;

@Controller
@RequestMapping("/admin/specialities")
@SessionAttributes("speciality")
public class SpecialityController {

	@Autowired
	private SpecialityService specialityService;

	private Validator specialityValidator;

	public SpecialityController() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		specialityValidator = validatorFactory.getValidator();
	}

	@ModelAttribute("allSpecialities")
	public List<Speciality> populateSpecialities() {
		List<Speciality> specialities = specialityService.getAll();
		return specialities;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		Speciality speciality = new Speciality();
		model.addAttribute("speciality", speciality);
		return "admin-specialities";
	}
	
	//TODO: Delete it
	@RequestMapping(method = RequestMethod.GET, value = "json")
	public ResponseEntity<List<Speciality>> getJson() {
		List<Speciality> specialities = specialityService.getAll();
		if(specialities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(specialities, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("speciality") Speciality speciality, BindingResult result, SessionStatus status) {
		Set<ConstraintViolation<Speciality>> violations = specialityValidator.validate(speciality);
		for (ConstraintViolation<Speciality> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			result.addError(new FieldError("speciality", propertyPath, "Invalid " + propertyPath + "(" + message + ")"));
		}

		if (result.hasErrors()) {
			return "admin-specialities";
		}
		specialityService.create(speciality);

		status.setComplete();
		return "redirect:/admin/specialities";
	}
}
