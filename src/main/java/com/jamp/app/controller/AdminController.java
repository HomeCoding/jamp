package com.jamp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//comment 1
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String adminPanel() {
		return "admin";
	}	
}
