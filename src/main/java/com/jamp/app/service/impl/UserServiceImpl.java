package com.jamp.app.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jamp.app.domain.User;
import com.jamp.app.repository.RoleRepository;
import com.jamp.app.repository.UserRepository;
import com.jamp.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void create(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}

	@Override
	public void remove(User user) {
		userRepository.delete(user);
	}

	@Override
	public void remove(Integer id) {
		userRepository.delete(id);
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
