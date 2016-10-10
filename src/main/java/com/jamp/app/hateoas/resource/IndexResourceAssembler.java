package com.jamp.app.hateoas.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

@Service
public class IndexResourceAssembler {
	private final RelProvider relProvider;
	private final EntityLinks entityLinks;

	@Autowired
	public IndexResourceAssembler(RelProvider relProvider, EntityLinks entityLinks) {
		this.relProvider = relProvider;
		this.entityLinks = entityLinks;
	}
	
	public IndexResource buildIndex() {
		List<org.springframework.hateoas.Link> links = Arrays.asList(
			entityLinks.linkToCollectionResource(LinkResource.class).withRel(relProvider.getCollectionResourceRelFor(LinkResource.class))
		);
		IndexResource resource = new IndexResource("rest", "A Jamp HATEOAS Rest API");
		resource.add(links);
		return resource;
	}
}
