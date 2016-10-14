package com.jamp.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.jamp.app.dao.BaseCrudDao;
import com.jamp.app.domain.BaseEntity;

@Transactional
public abstract class BaseCrudDaoImpl<T extends BaseEntity> implements BaseCrudDao<T> {

	protected Class<T> clazz;
	
	@PersistenceContext
	protected EntityManager em;

	public BaseCrudDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public void create(T entity) {
		em.persist(entity);
	}

	@Override
	public void remove(T entity) {
		T updatedEntity = em.find(clazz, entity.getId());
		if(updatedEntity == null) {
			throw new NullPointerException();
		}
		em.remove(updatedEntity);
	}
	
	@Override
	public void remove(Integer id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaDelete<T> query = criteriaBuilder.createCriteriaDelete(clazz);
		Root<T> root = query.from(clazz);
		query.where(root.get("id").in(id));
		int result = em.createQuery(query).executeUpdate();
		if(result == 0) {
			throw new IllegalArgumentException("not found with id: " + id);
		}
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
		return em.find(clazz, id);
	}
}
