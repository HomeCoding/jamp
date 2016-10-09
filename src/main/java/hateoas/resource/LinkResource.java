package hateoas.resource;

import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Relation(value="link", collectionRelation="links")
public class LinkResource extends ResourceWithEmbeddeds {
	private final String url;
	
	@JsonCreator
	public LinkResource(@JsonProperty("url") String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
