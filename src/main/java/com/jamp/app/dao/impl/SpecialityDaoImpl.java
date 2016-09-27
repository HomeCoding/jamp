package com.jamp.app.dao.impl;

import org.springframework.stereotype.Repository;

import com.jamp.app.dao.SpecialityDao;
import com.jamp.app.domain.Speciality;

@Repository
public class SpecialityDaoImpl  extends BaseDaoImpl<Speciality> implements SpecialityDao {

	public SpecialityDaoImpl(Class<Speciality> clazz) {
		super(clazz);
	}
	
	public SpecialityDaoImpl() {
		this(Speciality.class);
	}

}
