package com.jamp.app.service;

import java.util.List;

import com.jamp.app.domain.BaseEntity;

public interface BaseCrudService<T extends BaseEntity> {
	
	void create(T t);

	void remove(T t);
	
	void update(T t);

	List<T> getAll();
	
	T getById(Integer id);
}
