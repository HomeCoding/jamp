package com.jamp.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamp.app.dao.SpecialityDao;

import com.jamp.app.domain.Speciality;
import com.jamp.app.service.SpecialityService;

@Service
public class SpecialityServiceImpl implements SpecialityService {
	
	@Autowired
	private SpecialityDao specialityDao;

	@Override
	public List<Speciality> getAll() {
		return specialityDao.getAll();
	}

}
