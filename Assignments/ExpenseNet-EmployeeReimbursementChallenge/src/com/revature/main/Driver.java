package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
	ReimbursementDAO reimbDAO = new ReimbursementDAOImpl();	
	EmployeeDAO empDAO= new EmployeeDAOImpl();
//	
	System.out.println(empDAO.getEmployeeByUandP("bmackett6","6DX3r4BPUbMz"));
	
/*/
 * @Annotations ??
 * DBL 
 * ----------------------------
 * Reimbursement
 * reimbId, EmpId, Amt, ResId, StatId, TypeId
 * 
 * (Bean)
 * Reimbursement
 * id, amount, employee, resolver, statusId, typeid
 * 
 * Employee 
 * empid, fName, lName, email, uName, pass, repTo, actId, typeId
 * 
 * (Bean)
 * employeeId, firstname, lastname, password, positionId, Account, reportsto
 * 
 */
	
		// get All Reimbursement
//		List<Reimbursement> reimb = reimbDAO.getAll();
//		for(Reimbursement r : reimb) {
//			System.out.println(r);
//		}

		// get reimbursement by id
//		System.out.println(reimbDAO.getReimbursementById(3));

//		 get all reimbursements for an employee
//		List<Reimbursement> reimb2 = reimbDAO.getReimbursementByEmployeeId(32);
//		for(Reimbursement r : reimb2) {
//			System.out.println(r);
//		}
//		List<Reimbursement> reimb3 = reimbDAO.getEmployeeRbyManId(4);
//		for(Reimbursement r : reimb3) {
//			System.out.println(r);
//		}
		

	}

	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("connection1.properties");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
