package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final String filename = "connection.properties";

	@Override
	public List<Employee> getAll() {
		List<Employee> e1 = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection(filename)) {

			String sql = "SELECT E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.POSITIONID, E.ACCOUNTID, A.ACCOUNTNUM, E.REPORTSTO "
					+ "FROM EMPLOYEE E " + "INNER JOIN ACCOUNT A ON " + "E.EMPLOYEEID = A.EMPLOYEEID";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int employeeid = rs.getInt("employeeid");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String email = rs.getString("email");
				int position = rs.getInt("positionid");
				int accountid = rs.getInt("accountid");
				int reportsto = rs.getInt("reportsto");
				int accountnum = rs.getInt("accountnum");
				e1.add(new Employee(employeeid, fname, lname, email, position, new Account(accountid, accountnum),
						reportsto));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return e1;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.POSITIONID, E.ACCOUNTID, A.ACCOUNTNUM, E.REPORTSTO "
					+ "FROM EMPLOYEE E\r\n" + "INNER JOIN ACCOUNT A ON\r\n" + "E.EMPLOYEEID = A.EMPLOYEEID\r\n"
					+ "WHERE E.EMPLOYEEID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEEID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				int positionid = rs.getInt("POSITIONID");
				int accountid = rs.getInt("ACCOUNTID");
				int reportsto = rs.getInt("REPORTSTO");
				int accountnum = rs.getInt("accountnum");
				e = new Employee(employeeId, firstname, lastname, email, positionid, new Account(accountid, accountnum),
						reportsto);
//			System.out.println(e);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee e = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME,E.USERNAME, E.PASSWORD, E.EMAIL, E.POSITIONID, E.ACCOUNTID, A.ACCOUNTNUM, E.REPORTSTO "
					+ "FROM EMPLOYEE E\r\n" + "INNER JOIN ACCOUNT A ON\r\n" + "E.EMPLOYEEID = A.EMPLOYEEID\r\n"
					+ "WHERE E.USERNAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEEID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String uname = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int positionid = rs.getInt("POSITIONID");
				int accountid = rs.getInt("ACCOUNTID");
				int reportsto = rs.getInt("REPORTSTO");
				int accountnum = rs.getInt("accountnum");
				e = new Employee(employeeId, firstname, lastname, email, uname, password, positionid,
						new Account(accountid, accountnum), reportsto);
//			System.out.println(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public Employee createEmployee(String firstname, String lastname, String email, String username, String password,
			int reportsto) {
		Employee e = new Employee();

		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "INSERT INTO EMPLOYEE(FIRSTNAME, LASTNAME, EMAIL, USERNAME, PASSWORD, REPORTSTO)\r\n"
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstname);
			pstmt.setString(2, lastname);
			pstmt.setString(3, email);
			pstmt.setString(4, username);
			pstmt.setString(5, password);
			pstmt.setInt(6, reportsto);
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public void updateEmployee(int employeeid, String firstname, String lastname, String email, String username,
			String password) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE EMPLOYEE SET, FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PASSWORD = ?"
					+ "WHERE EMPLOYEEID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, firstname);
			pstmt.setString(2, lastname);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setInt(5, employeeid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEEID = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmployeeByUandP(String username, String password) {
		Employee e1 = null;
		// TODO Auto-generated method stub
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT *\r\n" 
					+ "FROM EMPLOYEE E " 
					+ "INNER JOIN ACCOUNT A ON "
					+ "A.EMPLOYEEID = E.EMPLOYEEID " 
					+ "WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, username);
			p.setString(2, password);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEEID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String uname = rs.getString("USERNAME");
				String pword = rs.getString("PASSWORD");
				int positionid = rs.getInt("POSITIONID");
				int accountid = rs.getInt("ACCOUNTID");
				int reportsto = rs.getInt("REPORTSTO");
				int accountnum = rs.getInt("accountnum");
				e1 = new Employee(employeeId, firstname, lastname, email, uname, pword, positionid,
						new Account(accountid, accountnum), reportsto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return e1;
	}

	@Override
	public Employee getEmployeeByUPandD(String username, String password) {
		Employee e1 = null;
		// TODO Auto-generated method stub
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT *\r\n" + "FROM EMPLOYEE E " + "INNER JOIN ACCOUNT A ON "
					+ "A.EMPLOYEEID = E.EMPLOYEEID \r\n" + "WHERE USERNAME = ? AND PASSWORD = ? ";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, username);
			p.setString(2, password);
			ResultSet rs = p.executeQuery();
			if (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEEID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String uname = rs.getString("USERNAME");
				String pword = rs.getString("PASSWORD");
				int accountid = rs.getInt("ACCOUNTID");
				int reportsto = rs.getInt("REPORTSTO");
				int accountnum = rs.getInt("accountnum");

				int positionid = rs.getInt("POSITIONID");

				if (positionid == 0) {
					return null;
				}
				e1 = new Employee(employeeId, firstname, lastname, email, uname, pword, positionid,
						new Account(accountid, accountnum), reportsto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return e1;
	}

	// E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.POSITIONID,
	// E.ACCOUNTID, A.ACCOUNTNUM, E.REPORTSTO "
	public List<Employee> getEmployeesByManagerId(int id) {
		List<Employee> e = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.POSITIONID, E.ACCOUNTID, A.ACCOUNTNUM, E.REPORTSTO "
					+ "FROM EMPLOYEE E\r\n" + "INNER JOIN ACCOUNT A ON\r\n" + "E.EMPLOYEEID = A.EMPLOYEEID\r\n"
					+ "WHERE E.REPORTSTO = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int employeeid = rs.getInt("EMPLOYEEID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				int positionid = rs.getInt("POSITiONID");
				int accountid = rs.getInt("ACCOUNTID");
				int accountnum = rs.getInt("ACCOUNTNUM");
				int reportsto = rs.getInt("REPORTSTO");
				e.add(new Employee(employeeid, firstname, lastname, email, positionid, new Account(accountid, accountnum),
						reportsto));
			}

			return e;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

}
