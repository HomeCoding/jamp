package com.jamp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jamp.app.domain.User;
import com.jamp.app.service.SecurityService;
import com.jamp.app.service.UserService;
import com.jamp.app.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/registration")
	public String register(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}
	
	@PostMapping("/registration")
    public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		
        if (bindingResult.hasErrors()) {
            return "registration";
        }

		userService.create(userForm);
        securityService.autologin(userForm.getEmail(), userForm.getPasswordConfirm());
        return "redirect:/welcome";
	}
	
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your login/password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
	
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    @GetMapping(value = {"/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}
