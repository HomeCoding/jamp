package com.jamp.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jamp.app.domain.Book;
import com.jamp.app.exception.RestResourceInvalidException;
import com.jamp.app.exception.RestResourceNotFoundException;
import com.jamp.app.service.BookService;


@RestController
@RequestMapping("/rest/book")
public class BookRestController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAll() {
		List<Book> books = bookService.getAll();
		return books;
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getById(@PathVariable("id") Integer id) {
		Book book = bookService.getById(id);
		if (book == null) {
			throw new RestResourceNotFoundException();
		}
		return book;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Book book) {
		bookService.create(book);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Book book) {
		try {
			bookService.update(book);
		} catch (RuntimeException e) {
			throw new RestResourceInvalidException(e);
		}
	}	

	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE) 
	public void remove(@RequestBody Book book) {
		try {
			bookService.remove(book);
		} catch (RuntimeException e) {
			throw new RestResourceNotFoundException();
		}
	}
	
	@DeleteMapping(value = "/{id}") 
	public void removeById(@PathVariable("id") Integer id) {
		try {
			bookService.remove(id);
		} catch (RuntimeException e) {
			throw new RestResourceNotFoundException();
		}
	}	
}
