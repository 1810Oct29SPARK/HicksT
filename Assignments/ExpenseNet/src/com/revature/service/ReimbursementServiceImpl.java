package com.revature.service;

import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class ReimbursementServiceImpl implements ReimbursementService{

		
	ReimbursementDAO reimb = new ReimbursementDAOImpl();
	
	@Override
	public List<Reimbursement> getAll() {
		// TODO Auto-generated method stub
		return reimb.getAll();
	}

	
	@Override
	public Reimbursement getReimbursementById(int id) {
		// TODO Auto-generated method stub
		return reimb.getReimbursementById(id);
	}

	@Override
	public List<Reimbursement> getReimbursementByEmployeeId(int id) {
		// TODO Auto-generated method stub
		return reimb.getReimbursementByEmployeeId(id);
	}

	@Override
	public Reimbursement createReimbursement(double amount, int employeeid, int resolverid, int statusid, int typeid) {
		return reimb.createReimbursement(amount, employeeid, resolverid, statusid, typeid);
	}

	@Override
	public void updateReimbursement(int amount, int employeeid, int resolverid, int statusid, int typeid,
			int reimbursementid) {
		reimb.updateReimbursement(amount, employeeid, resolverid, statusid, typeid, reimbursementid);
		
	}

	@Override
	public void deleteReimbursement(int id) {
		reimb.deleteReimbursement(id);
	}

}
