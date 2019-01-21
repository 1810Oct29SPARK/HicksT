package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Account;
import com.revature.beans.Employee;
import com.revature.service.AuthenticationService;

//@WebServlet("/EmployeeLogin")
public class EmployeeLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	AuthenticationService authService = new AuthenticationService();

	// return Login page for GET request	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("employeelogin.html").forward(req, resp);
	}

	// handle POST request from form on Login Page
	// (or anywhere else)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Employee e = null;
		e = authService.authUser(username, password);
		
		if (e != null) {
			session.setAttribute("employeeid", e.getEmployeeId());
			session.setAttribute("firstname", e.getFirstName());
			session.setAttribute("lastname", e.getLastName());
			session.setAttribute("username", e.getUsername());
			session.setAttribute("email", e.getEmail());
			session.setAttribute("password", e.getPassword());
			session.setAttribute("reportsto", e.getReportsTo());
			session.setAttribute("positionid", e.getPositionId());
			session.setAttribute("account", e.getAccount());
			session.setAttribute("problem", null);
			
			
			if (e.getPositionId() == 0) {
				resp.sendRedirect("employeehomepage");
			}
			else {
				session.setAttribute("employeeid", e.getEmployeeId());
				session.setAttribute("firstname", e.getFirstName());
				session.setAttribute("lastname", e.getLastName());
				session.setAttribute("username", e.getUsername());
				session.setAttribute("email", e.getEmail());
				session.setAttribute("password", e.getPassword());
				session.setAttribute("reportsto", e.getReportsTo());
				session.setAttribute("position", e.getPositionId());
				session.setAttribute("problem", null);
				resp.sendRedirect("managerhomepage.html");
			}
		}
		else {
			session.setAttribute("problem", "invalid credentials");
			resp.sendRedirect("employeelogin");
		}

	}
}
