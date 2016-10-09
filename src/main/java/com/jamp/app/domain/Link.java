package com.jamp.app.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("link")
public class Link extends Resource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Link other = (Link) obj;

		return Objects.equals(id, other.id) 
				&& Objects.equals(name, other.name) 
				&& Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
				.add("id = " + id)
				.add("name = " + name)
				.add("url = " + url)
				.toString();
	}
}
