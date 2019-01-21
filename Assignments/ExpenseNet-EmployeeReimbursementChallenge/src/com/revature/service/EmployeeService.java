package com.revature.service;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public List<Employee> getEmployeesByManagerId(int id);
	public Employee createEmployee(String firstname, String lastname, String email, String username, String password, int reportsto);
	public void updateEmployee(int employeeid, String firstname, String lastname, String email, String username, String password);
	public void deleteEmployee(int id);
}
