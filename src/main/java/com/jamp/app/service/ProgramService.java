package com.jamp.app.service;

import java.util.List;

import com.jamp.app.domain.Program;

public interface ProgramService {
	void create(Program program);
	
	void remove(Program program);
	
	List<Program> getAll();
	
	Program getById(Integer id);
}
