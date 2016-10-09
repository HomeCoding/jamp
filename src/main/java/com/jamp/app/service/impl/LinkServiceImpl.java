package com.jamp.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jamp.app.dao.LinkDao;
import com.jamp.app.domain.Link;
import com.jamp.app.service.LinkService;

@Service
public class LinkServiceImpl extends BaseCrudServiceImpl<Link> implements LinkService {

	@Autowired
	public LinkServiceImpl(LinkDao dao) {
		super(dao);
	}
}
