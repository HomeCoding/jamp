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
import com.jamp.app.domain.Link;
import com.jamp.app.exception.RestResourceInvalidException;
import com.jamp.app.exception.RestResourceNotFoundException;
import com.jamp.app.service.LinkService;

@RestController
@RequestMapping("/rest/link")
public class LinkRestController {

	@Autowired
	private LinkService linkService;

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Link> getAll() {
		List<Link> links = linkService.getAll();
		return links;
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Link getById(@PathVariable("id") Integer id) {
		Link link = linkService.getById(id);
		if (link == null) {
			throw new RestResourceNotFoundException();
		}
		return link;
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void create(@RequestBody Link link) {
		linkService.create(link);
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void update(@RequestBody Link link) {
		try {
			linkService.update(link);
		} catch (RuntimeException e) {
			throw new RestResourceInvalidException(e);
		}
	}	

	@DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) 
	public void remove(@RequestBody Link link) {
		try {
			linkService.remove(link);
		} catch (RuntimeException e) {
			throw new RestResourceNotFoundException();
		}
	}
	
	@DeleteMapping(value = "/{id}") 
	public void removeById(@PathVariable("id") Integer id) {
		try {
			linkService.remove(id);
		} catch (RuntimeException e) {
			throw new RestResourceNotFoundException();
		}
	}	
}
