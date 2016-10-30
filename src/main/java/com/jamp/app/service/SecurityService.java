package com.jamp.app.service;

public interface SecurityService {
	String getLoggedInEmail();
	
	void autologin(String email, String password);
}
