package com.jamp.app.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("link")
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"id", "name", "url"} )
public class Link extends Resource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@XmlElement
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	//inherited setters/getters need to be defined 
	//to be compatible with xml serialization
	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	@XmlElement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
