/**
 * 
 */
package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAll();
	public Employee getEmployeeById(int id);
	
	public Employee getEmployeeByUsername(String username);

	public Employee getEmployeeByUandP(String username, String password);
	public Employee getEmployeeByUPandD(String username, String password);
	
	public List<Employee> getEmployeesByManagerId(int id);
	
	public Employee createEmployee(String firstname, String lastname, String email, String username, String password, int reportsto);
	public void updateEmployee(int employeeid, String firstname, String lastname, String email, String username, String password);
	public void deleteEmployee(int id);
	
}
