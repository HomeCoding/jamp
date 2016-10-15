package com.jamp.app.dao.impl;

import org.springframework.stereotype.Repository;

import com.jamp.app.dao.BookDao;
import com.jamp.app.domain.Book;

@Repository
public class BookDaoImpl extends BaseCrudDaoImpl<Book> implements BookDao {
	
	public BookDaoImpl(Class<Book> clazz) {
		super(clazz);
	}
	
	public BookDaoImpl() {
		this(Book.class);
	}
}
