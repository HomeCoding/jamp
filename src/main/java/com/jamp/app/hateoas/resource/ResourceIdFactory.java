package com.jamp.app.hateoas.resource;

import com.jamp.app.domain.Link;

//Encapsulate the logic to get the resource ID out of the domain entity
public abstract class ResourceIdFactory {
	
	public static String getId(Link link) {
		return link.getId().toString();
	}
}
