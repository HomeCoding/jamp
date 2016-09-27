package com.jamp.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamp.app.dao.ProgramDao;
import com.jamp.app.domain.Program;
import com.jamp.app.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {
	
	@Autowired
	private ProgramDao programDao;

	@Override
	public void create(Program program) {
		programDao.create(program);
	}

	@Override
	public void remove(Program program) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Program> getAll() {
		return programDao.getAll();
	}

	@Override
	public Program getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
