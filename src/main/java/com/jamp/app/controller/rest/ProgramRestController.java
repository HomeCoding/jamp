package com.jamp.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jamp.app.domain.Program;
import com.jamp.app.exception.RestResourceInvalidException;
import com.jamp.app.exception.RestResourceNotFoundException;
import com.jamp.app.service.ProgramService;

@RestController
@RequestMapping("/rest/program")
public class ProgramRestController {
	
	@Autowired
	private ProgramService programService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Program> getAll() {
		List<Program> programs = programService.getAll();
		return programs;
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Program getById(@PathVariable("id") Integer id) {
		Program program = programService.getById(id);
		if (program == null) {
			throw new RestResourceNotFoundException();
		}
		return program;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Program program) {
		programService.create(program);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Program program) {
		try {
			programService.update(program);
		} catch (RuntimeException e) {
			e.printStackTrace();
			
			throw new RestResourceInvalidException(e);
		}
	}	
	
	@DeleteMapping(value = "/{id}") 
	public void removeById(@PathVariable("id") Integer id) {
		try {
			programService.remove(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new RestResourceNotFoundException();
		}
	}	
}
