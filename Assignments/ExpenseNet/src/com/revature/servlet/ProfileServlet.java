package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.EmployeeService;
import com.revature.service.EmployeeServiceImpl;

//@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper om;
	private EmployeeService employeeService;

	public ProfileServlet() {
		employeeService = new EmployeeServiceImpl();
		om = new ObjectMapper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("profile.html").forward(request, response);;
		
		System.out.println(request.getRequestURI());
		
		HttpSession session = request.getSession(false);
		
		
		int employeeid = Integer.parseInt(session.getAttribute("employeeid").toString());
		
		response.getWriter().write(om.writeValueAsString(employeeService.getEmployeeById(employeeid)));

	}

}
