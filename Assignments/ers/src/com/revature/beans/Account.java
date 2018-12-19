package com.revature.beans;

public class Account {
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", AccountNum=" + AccountNum + ", employee=" + employee + "]";
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int id, int accountNum, Employee employee) {
		super();
		this.id = id;
		AccountNum = accountNum;
		this.employee = employee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountNum() {
		return AccountNum;
	}
	public void setAccountNum(int accountNum) {
		AccountNum = accountNum;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int id;
	public int AccountNum;
	public Employee employee;
}
