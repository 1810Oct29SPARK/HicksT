package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.beans.Employee;
import com.revature.service.AuthenticationService;

@WebServlet("/managerlogin")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuthenticationService authService = new AuthenticationService();

    public ManagerLoginServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("managerlogin.html").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("posted");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Employee emp = null;
		emp = authService.authUser(username, password);
		
		if (emp != null) {
			System.out.println("auth");
			request.getRequestDispatcher("managerhomepage.html").forward(request, response);
		}
		else {
			response.sendRedirect("managerlogin");
		}
	}

}
