package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter - writes to the response
		PrintWriter pw = response.getWriter();
		pw.write("Hello, World!");
		//access Servlet Config - params unique to this servlet
		ServletConfig config = getServletConfig();
		pw.println(getInitParameter("servletMessage"));
		//access Servlet context - params shared by all servlets
		pw.println(config.getServletContext().getInitParameter("applicationMessage"));
	}
}
