package com.jamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamp.app.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
