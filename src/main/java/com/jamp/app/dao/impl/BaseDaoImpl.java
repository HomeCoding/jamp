package com.jamp.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import com.jamp.app.dao.BaseDao;
import com.jamp.app.domain.BaseEntity;

@Transactional
public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

	protected Class<T> clazz;
	
	@PersistenceContext
	protected EntityManager em;

	public BaseDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public void create(T entity) {
		em.persist(entity);
	}

	@Override
	public void remove(T entity) {
		em.remove(entity);
	}
	
	@Override
	public void update(T entity) {
		em.merge(entity);
	}

	@Override
	public List<T> getAll() {
		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(clazz);
        cq.select(cq.from(clazz));
        return em.createQuery(cq).getResultList();
	}

	@Override
	public T getById(Integer id) {
		System.out.println("getById = " + em.find(clazz, id));
		
		
		return em.find(clazz, id);
		
		
	}
}
