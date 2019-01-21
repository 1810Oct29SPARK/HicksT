package com.revature.beans;

public class Employee {

	public int employeeId;
	public String firstName;
	public String lastName;
	public String email;
	public String username;
	public String password;
	public int positionId;
	public Account account;
	public int reportsTo;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + positionId;
		result = prime * result + reportsTo;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Employee other = (Employee) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (positionId != other.positionId)
			return false;
		if (reportsTo != other.reportsTo)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	public Employee(int employeeId, String firstName, String lastName, String email, String username, String password,
			int positionId, Account account, int reportsTo) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.positionId = positionId;
		this.account = account;
		this.reportsTo = reportsTo;
	}

	public Employee(int employeeId, String firstName, String lastName, String email, int positionId, Account account,
			int reportsTo) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.positionId = positionId;
		this.account = account;
		this.reportsTo = reportsTo;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeid) {
		super();
		this.employeeId = employeeid;
	}

	public Employee(int resolverid, String fname2, String lname2, String email2) {
		super();
		this.employeeId = resolverid;
		this.firstName = fname2;
		this.lastName = lname2;
		this.email = email2;
	}

	

	public Employee(String firstName, String lastName, String email, String username, String password, int reportsTo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.reportsTo = reportsTo;
	}
	
	public Employee(String firstName, String lastName, String emailfirss, int reportsTo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.reportsTo = reportsTo;
	}
	
	
	public Employee(int employeeid, String firstName, String lastName, String email, String username, String password, int positionid, int reportsTo) {
		super();
		this.employeeId = employeeid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.positionId = positionid;
		this.reportsTo = reportsTo;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", username=" + username + ", password=" + password + ", positionId=" + positionId
				+ ", account=" + account + ", reportsTo=" + reportsTo + "]";
	}

}
