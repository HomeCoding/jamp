package com.jamp.app.dao.impl;

import org.springframework.stereotype.Repository;
import com.jamp.app.dao.WebResourceDao;
import com.jamp.app.domain.WebResource;

@Repository
public class WebResourceDaoImpl extends BaseCrudDaoImpl<WebResource> implements WebResourceDao {

	public WebResourceDaoImpl(Class<WebResource> clazz) {
		super(clazz);
	}
	
	public WebResourceDaoImpl() {
		this(WebResource.class);
	}
}
