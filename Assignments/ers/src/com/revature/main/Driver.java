package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		ReimbursementDAO reimbDAO = new ReimbursementDAOImpl();
		Employee e = new Employee("james", "baldwin", "jbald1@email.com","jbald1", "jbjb1", 7);
		// get All Employees
//		List<Employee> emp = empDAO.getAll();
//		for(Employee e : emp) {
//			System.out.println(e);
//		}

		// get Employee by Id
//		System.out.println(empDAO.getEmployeeById(3));

		// get Employee by Username
//		System.out.println(empDAO.getEmployeeByUsername("sdruhang"));

		// get All Reimbursement
//		List<Reimbursement> reimb = reimbDAO.getAll();
//		for(Reimbursement r : reimb) {
//			System.out.println(r);
//		}

		// get reimbursement by id
//		System.out.println(reimbDAO.getReimbursementById(3));

		// get all reimbursements for an employee
//		List<Reimbursement> reimb = reimbDAO.getReimbursementByEmployeeId(32);
//		for(Reimbursement r : reimb) {
//			System.out.println(r);
//		}

		empDAO.createEmployee("RICK", "FLAIR", "RICKFLAIR@email.com","RFWHOO", "DIAMONDS", 7);
	}

	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
