package com.revature.servlet;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeServlet {

	public Employee getEmployeeById(int id);

	public List<Employee> getEmployees();
	
	public List<Employee> getEmployeesByBossId(int id);

	public void createEmployee(String name, String email, String pw, String eBoss, int bossId);

	public void updateEmployee(int id, String name, String email, String pw);

	public void deleteEmployee(int id);

	public Employee loginEmployee(String user, String pass);
}
