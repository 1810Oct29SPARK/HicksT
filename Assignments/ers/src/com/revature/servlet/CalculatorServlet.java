package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1206242231575746111L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// forward the request (passing the request onto another request handler)
		RequestDispatcher rd = req.getRequestDispatcher("Calculator.html");
		rd.forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String paramN1 = req.getParameter("n1");
		String paramN2 = req.getParameter("n2");
		String paramOperation = req.getParameter("operation");
		
		if(n1!=null && paramN2 =! null) {
		
		Double n1 = Double.parseDouble(req.getParameter("n1"));
		Double n2 = Double.parseDouble(req.getParameter("n1"));
		String operation = req.getParameter(operation);
		Double answer = 0;
		switch(operation) {
		case"add":
			answer = n1+n2;
			break;
		case"subtract":
			answer = n1-n2;
			break;
		case"multiply":
			answer = n1*n2;
			break;
		case"divide":
			answer = n1/n2;
			
		
			
			PrintWriter pw = resp.getWriter();
			pw.write("the answer is " + answer);	
			
			
			req.setAttribute("answer", answer);
			req.setAttribute("error", error);
		}
		
		} else {
			
		}
	}

}
