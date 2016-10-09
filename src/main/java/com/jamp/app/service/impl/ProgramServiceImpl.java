package com.jamp.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jamp.app.dao.ProgramDao;
import com.jamp.app.domain.Program;
import com.jamp.app.service.ProgramService;

@Service
public class ProgramServiceImpl  extends BaseCrudServiceImpl<Program> implements ProgramService {

	@Autowired
	public ProgramServiceImpl(ProgramDao dao) {
		super(dao);
	}
	
	public ProgramDao getDao() {
		return (ProgramDao) dao;
	}

	@Override
	public List<Program> getByName(String name) {
		return getDao().getByName(name);
	}
}
