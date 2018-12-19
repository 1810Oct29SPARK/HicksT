package com.revature.service;

import com.revature.model.Credentials;
import com.revature.model.User;

public class AuthenticationService {
	
	public AuthenticationService() {
	}
	
	public User isValidUser(Credentials credentials) {
		
		User u = null;
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		//this is AUTHENTICATION (does the user exist in the system?)
		//not AUTHORIZATION (what can the user access within the system?)(user roles)
		//take credentials and return the USer to which they belong if it exists
		if(username != null && password != null) {
			//for now... this is fake!!
			if (username.equals("Merlin") && password.equals("wizard")) {
				u = new User(5,username, "Merlin", "Cat", "wizcat@tampa.com");
			}
			
		}
		
		return u;
	}
}
