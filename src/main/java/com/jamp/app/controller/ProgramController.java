package com.jamp.app.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jamp.app.domain.Program;
import com.jamp.app.domain.Speciality;
import com.jamp.app.editor.SpecialityEditor;
import com.jamp.app.service.ProgramService;
import com.jamp.app.service.SpecialityService;

@Controller
@RequestMapping("/program-module")
@SessionAttributes("program")
public class ProgramController {
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private SpecialityService specialityService;
	
	private Validator programValidator;
	
	public ProgramController() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		programValidator = validatorFactory.getValidator();
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Speciality.class, new SpecialityEditor());
    }
	
	@ModelAttribute("allSpecialities")
    public List<Speciality> populateSpecialities() 
    {
        List<Speciality> specialities = specialityService.getAll();
        return specialities;
    }
	
	@ModelAttribute("allPrograms")
    public List<Program> populatePrograms() 
    {
        List<Program> programs = programService.getAll();
        return programs;
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) 
	{
		Program program = new Program();
		model.addAttribute("program", program);
		return "programs";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("program") Program program,
			BindingResult result, SessionStatus status) {

		Set<ConstraintViolation<Program>> violations = programValidator.validate(program);
		
		for (ConstraintViolation<Program> violation : violations) 
		{
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            // Add JSR-303 errors to BindingResult
            // This allows Spring to display them in view via a FieldError
            result.addError(new FieldError("program", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
        }

		if (result.hasErrors()) {
			return "programs";
		}
		// Store the employee information in database
		programService.create(program);
		
		// Mark Session Complete and redirect to URL so that page refresh do not re-submit the form
		status.setComplete();
		return "redirect:program-module";
	}
}
