package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.service.AuthenticationService;
@WebServlet("/Project1/HTML/EmployeeLogin")
public class EmployeeLoginServlet extends HttpServlet{
	AuthenticationService authService = new AuthenticationService();

	// return Login page for GET request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Project1/HTML/EmployeeLogin").forward(req, resp);
	}

	// handle POST request from form on Login Page
	// (or anywhere else)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Handling request...");
		// checks whether a session exist otherwise creates a new one.
		// overloaded version takes a boolean create param, if false it returns
		// null if no session exist for the current request
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		// grab params from request

		Credentials cred = new Credentials(req.getParameter("username"), req.getParameter("password"));
		//attempting to authenticate the user
		
		Employee u = authService.isValidUser(cred);
		//set user information as session attributes
		if (u != null) {
			session.setAttribute("userId", u.getEmployeeId());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("firstname", u.getFirstName());
			session.setAttribute("lastname", u.getLastName());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("problem", null);
			
			//redirect user to profile page if authenticated
			resp.sendRedirect("profile");
		} else {
			session.setAttribute("problem","invalid credentials");
			//redirect user to login page is authentication fails
			resp.sendRedirect("/Project1/HTML/EmployeeLogin");
		}
		

	}
}
