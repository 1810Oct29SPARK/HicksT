package com.revature.dao;

import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> getAll();
	public Reimbursement getReimbursementById(int id);
	public List<Reimbursement> getReimbursementByEmployeeId(int id);
	public Reimbursement createReimbursement(double amount, int employeeid, int resolverid, int statusid, int typeid);
	public void updateReimbursement(int amount, int employeeid, int resolverid, int statusid, int typeid, int reiimbursementid);
	public void deleteReimbursement(int id);
	List<Reimbursement> getEmployeeRbyManId(int id);
}
