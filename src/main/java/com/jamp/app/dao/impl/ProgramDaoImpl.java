package com.jamp.app.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jamp.app.dao.ProgramDao;
import com.jamp.app.domain.Program;

@Repository
@Transactional
public class ProgramDaoImpl extends BaseCrudDaoImpl<Program> implements ProgramDao {

	public ProgramDaoImpl(Class<Program> clazz) {
		super(clazz);
	}

	public ProgramDaoImpl() {
		this(Program.class);
	}

	@Override
	public List<Program> getByName(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Program> criteriaQuery = builder.createQuery(Program.class);
		Root<Program> program = criteriaQuery.from(Program.class);
		criteriaQuery.select(program);
		criteriaQuery.where(builder.equal(program.get("name"), name));
		TypedQuery<Program> query = em.createQuery(criteriaQuery);
		List<Program> programs = query.getResultList();
		return programs;
	}
}