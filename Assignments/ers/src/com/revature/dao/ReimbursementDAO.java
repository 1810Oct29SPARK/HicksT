package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> getAll();
	public Reimbursement getReimbursementById(int id);
	public List<Reimbursement> getReimbursementByEmployeeId(int id);
	public void createReimbursement();
	public void updateReimbursement();
	public void deleteReimbursement();
}
