package com.revature.service;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class AuthenticationService {
	public AuthenticationService() {

	}
	
	public Employee authUser(String username, String password) {
		EmployeeDAO ed = new EmployeeDAOImpl();
		return ed.getEmployeeByUandP(username, password);	
	}
	public List authReimb(int id) {
		ReimbursementDAO rd = new ReimbursementDAOImpl();
		return rd.getReimbursementByEmployeeId(id);
	}
	
}
