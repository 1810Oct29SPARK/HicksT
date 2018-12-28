//package com.revature.servlet;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.revature.beans.Employee;
//import com.revature.beans.ReimbStatus;
//import com.revature.beans.ReimbType;
//import com.revature.beans.Reimbursement;
//import com.revature.dao.ReimbursementDAO;
//import com.revature.dao.ReimbursementDAOImpl;
//import com.revature.service.AuthenticationService;
//
///**
// * Servlet implementation class ReimbursementSession
// */
//@WebServlet("/reimbursementsession")
//public class ReimbursementSession extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	ReimbursementDAO reimb = new ReimbursementDAOImpl();
//	AuthenticationService authService = new AuthenticationService();
//
//	
//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		List<Reimbursement> rl = new ArrayList<>();
//	
//		HttpSession session = req.getSession();
//		resp.setContentType("text/html");
//		
//		int id = Integer.parseInt(req.getParameter("employeeid"));
//		
//		
//		Reimbursement r = null;
//		Employee e1 = new Employee();
//		Employee e2 = new Employee();
//		ReimbStatus rs = new ReimbStatus();
//		ReimbType rt = new ReimbType();
//		
//		List<Reimbursement> reimb2 = authService.authReimb(id);
//		
//		if (r3 != null) {
//				
//			session.setAttribute("id", r.getId());
//			session.setAttribute("amount", r.getAmount());
//			
//			session.setAttribute("employeeid", e1.getEmployeeId());
//			session.setAttribute("eFname", e1.getFirstName());
//			session.setAttribute("eLname", e1.getLastName());
//			session.setAttribute("email", e1.getEmail());
//			session.setAttribute("reportsto", e1.getReportsTo());
//			
//
//			session.setAttribute("employeeid", e2.getEmployeeId());
//			session.setAttribute("mFname", e2.getFirstName());
//			session.setAttribute("mLname", e2.getLastName());
//			session.setAttribute("mEmail", e2.getEmail());
//			
//			session.setAttribute("statusid", rs.getStatusId());
//			session.setAttribute("typeid", rt.getTypeId());
//			session.setAttribute("problem", null);	
//			
//		}
//		else {
//			session.setAttribute("problem", "invalid credentials");
//			resp.sendRedirect("employeelogin");
//		}
//
//	}
//	
//	
//}
