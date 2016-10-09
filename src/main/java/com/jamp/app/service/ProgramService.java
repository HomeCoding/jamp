package com.jamp.app.service;

import java.util.List;

import com.jamp.app.domain.Program;

public interface ProgramService extends BaseCrudService<Program> {
	List<Program> getByName(String name);
}
