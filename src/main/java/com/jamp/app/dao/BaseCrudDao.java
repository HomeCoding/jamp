package com.jamp.app.dao;

import java.util.List;

import com.jamp.app.domain.BaseEntity;

public interface BaseCrudDao<T extends BaseEntity> {
	
	void create(T t);

	void remove(T t);
	
	void remove(Integer id);
	
	void update(T t);

	List<T> getAll();
	
	T getById(Integer id);
}
