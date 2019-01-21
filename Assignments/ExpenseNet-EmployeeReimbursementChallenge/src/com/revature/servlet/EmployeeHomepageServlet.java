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

/**
 * Servlet implementation class EmployeeHomepageServlet
 */
//@WebServlet("/EmployeeHomepageServlet")
public class EmployeeHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper om;
	private EmployeeService employeeService;

	public EmployeeHomepageServlet() {
		employeeService = new EmployeeServiceImpl();
		om = new ObjectMapper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("username") != null) {

			request.getRequestDispatcher("employeehomepage.html").forward(request, response);

		} else {

			response.sendRedirect("error.html");

		}
	}

}
