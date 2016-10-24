package com.jamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamp.app.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
}
