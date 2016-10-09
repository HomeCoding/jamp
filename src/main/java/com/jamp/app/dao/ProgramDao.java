package com.jamp.app.dao;

import java.util.List;

import com.jamp.app.domain.Program;

public interface ProgramDao extends BaseCrudDao<Program> {
	List<Program> getByName(String name);
}
