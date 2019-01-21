package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.beans.User;
import com.revature.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	private LoginService loginService;
	

	//deliver static resources from an endpoint "/login"
	@GetMapping(value="/login")
	public String getStaticLoginPage() {
		return "forward:/SpringMVCDemo/static/staticLogin.html";
	}
	
	//handle form data sent to "/login"
	@PostMapping(value="/auth", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String handleFormRequest(@RequestBody MultiValueMap<String, String> formParams) {
		System.out.println("form params recieved: " + formParams);
		
		// process form data
		User u = loginService.validateUser(formParams.getFirst("username"), formParams.getFirst("password"));
		/// pass user information into the Model
		if (u == null) {
			//show error
			return "forward:/static/error.html";
		}
		//// render result as a JSP using InternalResourceViewResolver
		
		/////return view name to be interpreted by IRVR
		
		return "profile";
	}
	
	
}
