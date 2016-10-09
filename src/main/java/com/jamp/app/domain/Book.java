package com.jamp.app.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("book")
public class Book extends Resource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, author);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Book other = (Book) obj;

		return Objects.equals(id, other.id) 
				&& Objects.equals(name, other.name) 
				&& Objects.equals(author, other.author);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
				.add("id = " + id)
				.add("name = " + name)
				.add("author = " + author)
				.toString();
	}
}
