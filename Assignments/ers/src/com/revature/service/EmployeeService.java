package com.revature.service;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeService {
	public List<Employee> getAll();
	public Employee getEmployeeById(int id);
	public void createEmployee();
	public void updateEmployee();
	public void deleteEmployee();
}
