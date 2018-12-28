package com.revature.beans;

public class Account {
	
	public int id;
	public int AccountNum;
	public Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AccountNum;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (AccountNum != other.AccountNum)
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id != other.id)
			return false;
		return true;
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
	public Account(int id, int accountNum) {
		super();
		this.id = id;
		AccountNum = accountNum;
	}
	public Account(int id, int accountNum, Employee employee) {
		super();
		this.id = id;
		AccountNum = accountNum;
		this.employee = employee;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", AccountNum=" + AccountNum + "]";
	}
	
	
}
