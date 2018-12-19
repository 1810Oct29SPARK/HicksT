package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.User;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// grab current session, if it exist
		HttpSession session = request.getSession(false);
		if(session != null &&  session.getAttribute("username") != null) {
		try {
			int userId = Integer.parseInt(session.getAttribute("userId").toString());
			String username = session.getAttribute("username").toString();
			String firstname = session.getAttribute("firstname").toString();
			String lastname = session.getAttribute("lastname").toString();
			String email = session.getAttribute("email").toString();
			User u = new User(userId, username, firstname, lastname, email);
			
			response.getWriter().write(new ObjectMapper().writeValueAsString(u));
		} catch (Exception e) {
			response.getWriter().write("{\"session\":null}");
		}
	} else {
		response.getWriter().write("{\"session\":null}");
	}
}
}