package com.jamp.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jamp.app.dao.SpecialityDao;
import com.jamp.app.domain.Speciality;
import com.jamp.app.service.SpecialityService;

@Service
public class SpecialityServiceImpl extends BaseCrudServiceImpl<Speciality> implements SpecialityService {

	@Autowired
	public SpecialityServiceImpl(SpecialityDao dao) {
		super(dao);
	}
	
	public SpecialityDao getDao() {
		return (SpecialityDao) dao;
	}

	@Override
	public List<Speciality> getByName(String name) {
		return getDao().getByName(name);
	}
}
