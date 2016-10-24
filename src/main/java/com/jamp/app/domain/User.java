package com.jamp.app.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String name;
    
    private String email;
    
    @Transient
    private String password;
    
    @Transient
    private String passwordConfirm;
    
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
    
	@Override
	public int hashCode() {
		return Objects.hash(id, name, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;

		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
				.add("id = " + id)
				.add("name = " + name)
				.add("email = " + email)
				.toString();
	}
    
    
}
