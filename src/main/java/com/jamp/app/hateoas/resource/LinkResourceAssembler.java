package com.jamp.app.hateoas.resource;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.RelProvider;
import org.springframework.stereotype.Service;

import com.jamp.app.domain.Link;
import com.jamp.app.hateoas.api.LinkRestController;

@Service
public class LinkResourceAssembler extends EmbeddableResourceAssemblerSupport<Link, LinkResource, LinkRestController>{

	public LinkResourceAssembler(EntityLinks entityLinks, RelProvider relProvider) {
		super(entityLinks, relProvider, LinkRestController.class, LinkResource.class);
	}

	@Override
	public LinkResource toResource(Link link) {
		LinkResource resource = createResourceWithId(ResourceIdFactory.getId(link), link);
		return resource;
	}

	@Override
	public org.springframework.hateoas.Link linkToSingleResource(Link link) {
		return entityLinks.linkToSingleResource(LinkResource.class, ResourceIdFactory.getId(link));
	}

	@Override
	protected LinkResource instantiateResource(Link link) {
		return new LinkResource(link.getName());
	}
}
