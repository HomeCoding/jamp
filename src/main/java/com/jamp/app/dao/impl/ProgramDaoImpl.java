package com.jamp.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamp.app.dao.ProgramDao;
import com.jamp.app.domain.Program;

@Repository
@Transactional
public class ProgramDaoImpl extends BaseDaoImpl<Program> implements ProgramDao {

	public ProgramDaoImpl(Class<Program> clazz) {
		super(clazz);
	}

	public ProgramDaoImpl() {
		this(Program.class);
	}

	@Override
	public List<Program> getByName(String name) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	
}