package com.revature.service;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;

public class AuthenticationService {
	public AuthenticationService() {

	}

	public Employee isValidUser(Credentials credentials) {

		Employee e = null;
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		// this is AUTHENTICATION (does the user exist in the system?)
		// not AUTHORIZATION (what can the user access within the system?)(user roles)
		// take credentials and return the USer to which they belong if it exists
		if (username != null && password != null) {
			// for now... this is fake!!
			if (username.equals("Merlin") && password.equals("wizard")) {
				e = new Employee(5, username, "Merlin", "Cat", "wizcat@tampa.com", password, 0, null, 0);
			}

		}
		return e;
	}
}
