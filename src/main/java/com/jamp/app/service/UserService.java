package com.jamp.app.service;


import com.jamp.app.domain.User;

public interface UserService extends BaseCrudService<User> {
	User getByEmail(String email);
}
