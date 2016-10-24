package com.jamp.app.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Role other = (Role) obj;

		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
				.add("id = " + id)
				.add("name = " + name)
				.toString();
	}
}
