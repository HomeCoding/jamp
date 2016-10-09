package com.jamp.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamp.app.dao.WebResourceDao;
import com.jamp.app.domain.WebResource;
import com.jamp.app.service.WebResourceService;

@Service
public class WebResourceServiceImpl implements WebResourceService {

	@Autowired
	private WebResourceDao webResourceDao;
	
	@Override
	public void create(WebResource webResource) {
		webResourceDao.create(webResource);
	}

	@Override
	public void remove(WebResource webResource) {
		webResourceDao.remove(webResource);
	}

	@Override
	public void update(WebResource webResource) {
		webResourceDao.update(webResource);
	}

	@Override
	public List<WebResource> getAll() {
		return webResourceDao.getAll();
	}

	@Override
	public WebResource getById(Integer id) {
		return webResourceDao.getById(id);
	}
}
