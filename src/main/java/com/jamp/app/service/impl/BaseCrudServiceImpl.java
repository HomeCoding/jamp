package com.jamp.app.service.impl;

import java.util.List;

import com.jamp.app.dao.BaseCrudDao;
import com.jamp.app.domain.BaseEntity;
import com.jamp.app.service.BaseCrudService;

public abstract class BaseCrudServiceImpl<T extends BaseEntity> implements BaseCrudService<T> {
	protected final BaseCrudDao<T> dao;
	
	public BaseCrudServiceImpl(BaseCrudDao<T> dao) {
		this.dao = dao;
	}
	
	@Override
	public void create(T entity) {
		dao.create(entity);
	}

	@Override
	public void remove(T entity) {
		dao.remove(entity);
	}
	
	@Override
	public void remove(Integer id) {
		dao.remove(id);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

	
	@Override
	public List<T> getAll() {
		return dao.getAll();
	}

	@Override
	public T getById(Integer id) {
		return dao.getById(id);
	}
}
