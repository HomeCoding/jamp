package com.jamp.app.dao.impl;

import org.springframework.stereotype.Repository;
import com.jamp.app.dao.LinkDao;
import com.jamp.app.domain.Link;

@Repository
public class LinkDaoImpl extends BaseCrudDaoImpl<Link> implements LinkDao {

	public LinkDaoImpl(Class<Link> clazz) {
		super(clazz);
	}
	
	public LinkDaoImpl() {
		this(Link.class);
	}
}
