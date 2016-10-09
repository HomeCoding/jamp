package com.jamp.app.dao.impl;


import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.jamp.app.dao.SpecialityDao;

import com.jamp.app.domain.Speciality;

@Repository
public class SpecialityDaoImpl extends BaseCrudDaoImpl<Speciality> implements SpecialityDao {
	private static final String SELECT_BY_NAME = "select s from Speciality s where s.name = :name";

	public SpecialityDaoImpl(Class<Speciality> clazz) {
		super(clazz);
	}
	
	public SpecialityDaoImpl() {
		this(Speciality.class);
	}

	@Override
	public List<Speciality> getByName(String name) {
		TypedQuery<Speciality> query = em.createQuery(SELECT_BY_NAME, Speciality.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
}
