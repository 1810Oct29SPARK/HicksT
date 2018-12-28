package com.revature.service;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDAO ed = new EmployeeDAOImpl();

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return ed.getAll();
	}

	@Override
	public List<Employee> getEmployeesByManagerId(int id) {
		return ed.getEmployeesByManagerId(id);
	}
	@Override
	public Employee getEmployeeById(int id) {
		return ed.getEmployeeById(id);
	}
	
	@Override
	public Employee createEmployee(String firstname, String lastname, String email, String username, String password, int reportsto) {
		return ed.createEmployee(firstname, lastname, email, username, password, reportsto);
	}

	@Override
	public void updateEmployee(int employeeid, String firstname, String lastname, String email, String username, String password) {
		ed.updateEmployee(employeeid, firstname, lastname, email, username, password);
	}
	
	@Override
	public void deleteEmployee(int id) {
		ed.deleteEmployee(id);
		
	}

}
