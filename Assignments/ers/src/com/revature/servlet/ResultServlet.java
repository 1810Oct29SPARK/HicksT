package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultServlet
 */
//@WebServlet("/ResultServlet") removes need to register in web.xml

public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//view attributes of request
		Enumeration<String> atts = request.getAttributeNames();
		while(ats.hasMoreElements()) {
			String s = atts.nextElement();
			System.out.println(s + " : " + request.getAttribute(s));
		}
		
		String error = (String) request.getAttribute("error");
		
		PrintWriter pw = response.getWriter();
		
		if(error!=null &&  !error.equals((""))) {
		Double answer = (Double) request.getAttribute("answer"));
			pw.write("<p style= \"margin:10px\"> The Answer is: "+answer+"</p>");
		} else {
			pw.write("<p style= \"margin:10px\"> Error: "+error+"</p>");
		}
		pw.write("<p style= \"margin:10px\"><a href=\"calculator\">GO BACK</p>");
		
	}

}
