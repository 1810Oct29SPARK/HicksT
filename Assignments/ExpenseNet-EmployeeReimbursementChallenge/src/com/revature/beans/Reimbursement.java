package com.revature.beans;

public class Reimbursement {

	private int id;
	private double amount;
	private Employee employee;
	private Employee resolver;
	private ReimbStatus statusId;
	private ReimbType typeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getResolver() {
		return resolver;
	}
	public void setResolver(Employee resolver) {
		this.resolver = resolver;
	}
	public ReimbStatus getStatusId() {
		return statusId;
	}
	public void setStatusId(ReimbStatus statusId) {
		this.statusId = statusId;
	}
	public ReimbType getTypeId() {
		return typeId;
	}
	public void setTypeId(ReimbType typeId) {
		this.typeId = typeId;
	}
	public Reimbursement(int id, double amount, Employee employee, Employee resolver,
			ReimbStatus statusId, ReimbType typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.employee = employee;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", employee="
				+ employee + ", resolver=" + resolver + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}
	
	
}
