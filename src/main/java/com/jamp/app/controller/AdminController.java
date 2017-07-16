package com.jamp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//comment 1
//comment 2
//comment 3

//co 1
//co 2
//co 3
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String adminPanel() {
		return "admin";
	}	
}
