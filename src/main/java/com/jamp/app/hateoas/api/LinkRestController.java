package com.jamp.app.hateoas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jamp.app.domain.Link;
import com.jamp.app.hateoas.resource.CreateLink;
import com.jamp.app.hateoas.resource.LinkResource;
import com.jamp.app.hateoas.resource.LinkResourceAssembler;
import com.jamp.app.hateoas.utils.ResourceHandlingUtils;
import com.jamp.app.service.LinkService;

@RestController
@ExposesResourceFor(LinkResource.class)
@RequestMapping(value = "/links")
public class LinkRestController {
	
	@Autowired
	private LinkService linkService;
	@Autowired
	private LinkResourceAssembler linkAssembler;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<LinkResource> getById(@PathVariable Integer id) {
		Link link = ResourceHandlingUtils.entityOrNotFoundException(linkService.getById(id));
		LinkResource resource = linkAssembler.toResource(link);
		return ResponseEntity.ok(resource);		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Resources<LinkResource>> getAll() {
		List<Link> links = linkService.getAll(); 
		Resources<LinkResource> wrapped = linkAssembler.toEmbeddedList(links);
		return ResponseEntity.ok(wrapped);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody CreateLink createLink) {
		Link link = new Link();
		link.setName(createLink.getUrl());
		link.setUrl(createLink.getUrl());
		
		//Link savedLink = linkService.create(link);
		linkService.create(link);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", linkAssembler.linkToSingleResource(link).getHref());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
}
