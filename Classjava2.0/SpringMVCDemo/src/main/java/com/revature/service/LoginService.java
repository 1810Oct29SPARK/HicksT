package com.revature.service;

import org.springframework.stereotype.Service;

import com.revature.beans.User;

@Service
public class LoginService {
		
	public User validateUser(String username, String password) {
		if (username.equals("Merlins") && password.equals("CAT")) {
			return new User(6, username, "merlin@gmail.com"); 
		} else {
			return null;
		}
	}
}
