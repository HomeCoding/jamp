package com.jamp.app.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "resource")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Resource extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
