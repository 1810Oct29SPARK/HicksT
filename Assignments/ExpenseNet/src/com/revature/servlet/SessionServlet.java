package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Account;
import com.revature.beans.Employee;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("username") != null) {
			try {

				int employeeid = Integer.parseInt(session.getAttribute("employeeid").toString());
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				String username = session.getAttribute("username").toString();
				String email = session.getAttribute("email").toString();
				String password = session.getAttribute("password").toString();
				int positionid = Integer.parseInt(session.getAttribute("positionid").toString());
				int reportsto = Integer.parseInt(session.getAttribute("reportsto").toString());

				Employee e = new Employee(employeeid, firstname, lastname, username, email, password, positionid, reportsto);
				
				response.getWriter().write((new ObjectMapper()).writeValueAsString(e));
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null2}");
		}
	}
}
