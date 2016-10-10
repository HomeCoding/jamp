package com.jamp.app.hateoas.utils;

import org.springframework.data.domain.Persistable;

import com.jamp.app.hateoas.exception.ResourceNotFoundException;

public class ResourceHandlingUtils {
	public static <T extends Persistable<?>> T entityOrNotFoundException(T entity) {
		if (entity == null) {
			throw new ResourceNotFoundException();
		}
		return entity;
	}
}
