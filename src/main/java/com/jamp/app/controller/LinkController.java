package com.jamp.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jamp.app.domain.Link;
import com.jamp.app.service.LinkService;

@RestController
@RequestMapping("/rest/link")
public class LinkController {
	
	@Autowired
	private LinkService linkService;
	
	@GetMapping(produces={"application/json", "application/xml"})
	public List<Link> getAll() {
		List<Link> links = linkService.getAll();
		return links;
	}
	
	@GetMapping(value = "/{id}", produces={"application/json", "application/xml"})
	public Link getById(@PathVariable("id") Integer id) {
		Link link = linkService.getById(id);
		return link;
	}

}
