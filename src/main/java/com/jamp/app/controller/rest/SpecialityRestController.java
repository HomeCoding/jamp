package com.jamp.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.jamp.app.domain.Speciality;
import com.jamp.app.exception.RestResourceNotFoundException;
import com.jamp.app.service.SpecialityService;

@RestController
@RequestMapping("/rest/speciality")
public class SpecialityRestController {
	@Autowired
	private SpecialityService specialityService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Speciality> getAll(@RequestParam(value="expanded", required = false, defaultValue = "false") boolean expanded) {
		List<Speciality> specialities =  expanded ? specialityService.getAllWithPrograms() :  specialityService.getAll();
		return specialities;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Speciality getById(@PathVariable("id") Integer id) {
		Speciality speciality = specialityService.getById(id);
		if (speciality == null) {
			throw new RestResourceNotFoundException();
		}
		return speciality;
	}

}
