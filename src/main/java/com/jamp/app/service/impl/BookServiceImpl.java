package com.jamp.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jamp.app.dao.BookDao;
import com.jamp.app.domain.Book;
import com.jamp.app.service.BookService;

@Service
public class BookServiceImpl extends BaseCrudServiceImpl<Book> implements BookService {
	@Autowired
	public BookServiceImpl(BookDao dao) {
		super(dao);
	}
}
