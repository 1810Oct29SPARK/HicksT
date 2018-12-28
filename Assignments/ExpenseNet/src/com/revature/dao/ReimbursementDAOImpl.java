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
import com.revature.beans.ReimbStatus;
import com.revature.beans.ReimbType;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO{
	public static final String filename = "connection.properties";
	
	
//	public Reimbursement insertReimb(Employee emp, Employee man, double amount, ReimbType type, ReimbStatus status,
//			String description){
//		Reimbursement r = null;
//
//		try(Connection conn = ConnectionUtil.getConnection(filename)){
//		String sql = "INSERT INTO REIMBURSEMENT(" + "AMOUNT, EMPLOYEEID, " + "RESOLVERID, STATUSID, " + "TYPEID) "
//				+ "VALUES(?,?,?,?,?)";
//		PreparedStatement stmt = conn.prepareStatement(sql, new String[] { "REIMB_ID" });
//
//		stmt.setDouble(1, amount);
//		stmt.setInt(2, emp.getEmployeeId());
//		stmt.setInt(3, man.getReportsTo());
//		stmt.setInt(4, 1);
//		stmt.setInt(5, type.getTypeId());
//		stmt.executeQuery();
//
//		ResultSet rs = stmt.getGeneratedKeys();
//		rs.next();
//		int pk = rs.getInt(1);
//
//		Reimbursement reimb = new Reimbursement(pk, amount, null, emp, man, status, type);
//		System.out.println("ReimbDao: insertReimb(): " + reimb);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return r;
//	}


	@Override
	public List<Reimbursement> getAll() {
		List<Reimbursement> r = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection(filename)){
			//rEIMBURSEMENTID, EMPLOYEEID, AMOUNT, RESOLVERID, STATUSID, TYPEID
			String sql = "SELECT  R.REIMBURSEMENTID, R.EMPLOYEEID, R.AMOUNT, R.RESOLVERID, R.STATUSID, R.TYPEID, "
					+ "E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.POSITIONID, E.ACCOUNTID, E.REPORTSTO, A.ACCOUNTNUM, "
					+ "E2.EMPLOYEEID AS MANID, E2.FIRSTNAME AS MANFNAME, E2.LASTNAME AS MANLNAME, E2.EMAIL AS MANEMAIL \r\n" + 
					"FROM REIMBURSEMENTS R \r\n" + 
					"INNER JOIN EMPLOYEE E ON \r\n" + 
					"R.EMPLOYEEID = E.EMPLOYEEID \r\n" + 
					"INNER JOIN REIMBURSEMENTSTATUS RS ON \r\n" + 
					"RS.STATUSID = R.STATUSID \r\n" + 
					"INNER JOIN REIMBURSEMENTTYPE RT ON \r\n" + 
					"RT.TYPEID = R.TYPEID\r\n" + 
					"INNER JOIN ACCOUNT A ON\r\n" + 
					"E.EMPLOYEEID = A.EMPLOYEEID\r\n" + 
					"INNER JOIN EMPLOYEE E2 ON\r\n" + 
					"E2.EMPLOYEEID = E.REPORTSTO\r\n";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int reimbursementid = rs.getInt("REIMBURSEMENTID");
				int employeeid = rs.getInt("EMPLOYEEID");
				double amount = rs.getDouble("AMOUNT");
				int resolverid = rs.getInt("RESOLVERID");
				int statusid = rs.getInt("STATUSID");
				int typeid = rs.getInt("TYPEID");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String email = rs.getString("email");
				int position = rs.getInt("positionid");
				int accountid = rs.getInt("accountid");
				int reportsto = rs.getInt("reportsto");
				int accountnum = rs.getInt("accountnum");
				String fname2 = rs.getString("MANFNAME");
				String lname2 = rs.getString("MANLNAME");
				String email2 = rs.getString("MANEMAIL");
				r.add( new Reimbursement(reimbursementid, amount, new Employee(employeeid, fname, lname, email, position, new Account(accountid, accountnum), reportsto), new Employee(resolverid, fname2, lname2, email2), new ReimbStatus(statusid), new ReimbType(typeid)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}


	@Override
	public Reimbursement getReimbursementById(int id) {
		Reimbursement r = null;
		try(Connection conn = ConnectionUtil.getConnection(filename)){
			//rEIMBURSEMENTID, EMPLOYEEID, AMOUNT, RESOLVERID, STATUSID, TYPEID
			String sql = "SELECT  R.REIMBURSEMENTID, R.EMPLOYEEID, R.AMOUNT, R.RESOLVERID, R.STATUSID, R.TYPEID, "
					+ "E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.POSITIONID, E.ACCOUNTID, E.REPORTSTO, A.ACCOUNTNUM, "
					+ "E2.EMPLOYEEID AS MANID, E2.FIRSTNAME AS MANFNAME, E2.LASTNAME AS MANLNAME, E2.EMAIL AS MANEMAIL \r\n" + 
					"FROM REIMBURSEMENTS R \r\n" + 
					"INNER JOIN EMPLOYEE E ON \r\n" + 
					"R.EMPLOYEEID = E.EMPLOYEEID \r\n" + 
					"INNER JOIN REIMBURSEMENTSTATUS RS ON \r\n" + 
					"RS.STATUSID = R.STATUSID \r\n" + 
					"INNER JOIN REIMBURSEMENTTYPE RT ON \r\n" + 
					"RT.TYPEID = R.TYPEID\r\n" + 
					"INNER JOIN ACCOUNT A ON\r\n" + 
					"E.EMPLOYEEID = A.EMPLOYEEID\r\n" + 
					"INNER JOIN EMPLOYEE E2 ON\r\n" + 
					"E2.EMPLOYEEID = E.REPORTSTO\r\n" + 
					"WHERE R.EMPLOYEEID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				int reimbursementid = rs.getInt("REIMBURSEMENTID");
				int employeeid = rs.getInt("EMPLOYEEID");
				double amount = rs.getDouble("AMOUNT");
				int resolverid = rs.getInt("RESOLVERID");
				int statusid = rs.getInt("STATUSID");
				int typeid = rs.getInt("TYPEID");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String email = rs.getString("email");
				int position = rs.getInt("positionid");
				int accountid = rs.getInt("accountid");
				int reportsto = rs.getInt("reportsto");
				int accountnum = rs.getInt("accountnum");
				String fname2 = rs.getString("MANFNAME");
				String lname2 = rs.getString("MANLNAME");
				String email2 = rs.getString("MANEMAIL");
				r = new Reimbursement(reimbursementid, amount, new Employee(employeeid, fname, lname, email, position, new Account(accountid, accountnum), reportsto), new Employee(resolverid, fname2, lname2, email2), new ReimbStatus(statusid), new ReimbType(typeid));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	@Override
	public List<Reimbursement> getReimbursementByEmployeeId(int id) {
		List<Reimbursement> r = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection(filename)){
			//rEIMBURSEMENTID, EMPLOYEEID, AMOUNT, RESOLVERID, STATUSID, TYPEID
			String sql = "SELECT  R.REIMBURSEMENTID, R.EMPLOYEEID, R.AMOUNT, R.RESOLVERID, R.STATUSID, R.TYPEID, "
					+ "E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.POSITIONID, E.ACCOUNTID, E.REPORTSTO, A.ACCOUNTNUM, "
					+ "E2.EMPLOYEEID AS MANID, E2.FIRSTNAME AS MANFNAME, E2.LASTNAME AS MANLNAME, E2.EMAIL AS MANEMAIL \r\n" + 
					"FROM REIMBURSEMENTS R \r\n" + 
					"INNER JOIN EMPLOYEE E ON \r\n" + 
					"R.EMPLOYEEID = E.EMPLOYEEID \r\n" + 
					"INNER JOIN REIMBURSEMENTSTATUS RS ON \r\n" + 
					"RS.STATUSID = R.STATUSID \r\n" + 
					"INNER JOIN REIMBURSEMENTTYPE RT ON \r\n" + 
					"RT.TYPEID = R.TYPEID\r\n" + 
					"INNER JOIN ACCOUNT A ON\r\n" + 
					"E.EMPLOYEEID = A.EMPLOYEEID\r\n" + 
					"INNER JOIN EMPLOYEE E2 ON\r\n" + 
					"E2.EMPLOYEEID = E.REPORTSTO\r\n" + 
					"WHERE R.EMPLOYEEID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int reimbursementid = rs.getInt("REIMBURSEMENTID");
				int employeeid = rs.getInt("EMPLOYEEID");
				double amount = rs.getDouble("AMOUNT");
				int resolverid = rs.getInt("RESOLVERID");
				int statusid = rs.getInt("STATUSID");
				int typeid = rs.getInt("TYPEID");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String email = rs.getString("email");
				int position = rs.getInt("positionid");
				int accountid = rs.getInt("accountid");
				int reportsto = rs.getInt("reportsto");
				int accountnum = rs.getInt("accountnum");
				String fname2 = rs.getString("MANFNAME");
				String lname2 = rs.getString("MANLNAME");
				String email2 = rs.getString("MANEMAIL");
				r.add( new Reimbursement(reimbursementid, amount, new Employee(employeeid, fname, lname, email, position, new Account(accountid, accountnum), reportsto), new Employee(resolverid, fname2, lname2, email2), new ReimbStatus(statusid), new ReimbType(typeid)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}



	//TEST WHEN YOU GET BACK TO INTERNET
	@Override
	public Reimbursement createReimbursement(double amount, int employeeid, int resolverid, int statusid, int typeid) {
			Reimbursement e = new Reimbursement();
			try (Connection con = ConnectionUtil.getConnection(filename)) {
				String sql = "INSERT INTO REIMBURSEMENT(AMOUNT, EMPLOYEEID, RESOLVERID, STATUSID, TYPEID)\r\n"
						+ "VALUES(?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setDouble(1, amount);
				pstmt.setInt(2, employeeid);
				pstmt.setInt(3, resolverid);
				pstmt.setInt(4, statusid);
				pstmt.setInt(5, typeid);
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
	public void updateReimbursement(int amount, int employeeid, int resolverid, int statusid, int typeid, int reimbursementid) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE REIMBURSEMENT SET AMOUNT = ?, EMPLOYEEID= ?, RESOLVERID= ?,STATUSID= ?, TYPEID= ?"
					+ "WHERE REIMBURSEMENTID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, employeeid);
			pstmt.setInt(3, resolverid);
			pstmt.setInt(4, statusid);
			pstmt.setInt(5, typeid);
			pstmt.setInt(6,reimbursementid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void deleteReimbursement(int id) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "DELETE FROM REIMBURSEMENT WHERE REIMBURSEMENTID = ?";
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
	public List<Reimbursement> getEmployeeRbyManId(int id) {
		List<Reimbursement> r = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection(filename)){
			//rEIMBURSEMENTID, EMPLOYEEID, AMOUNT, RESOLVERID, STATUSID, TYPEID
			String sql = "SELECT  R.REIMBURSEMENTID, R.EMPLOYEEID, R.AMOUNT, R.RESOLVERID, R.STATUSID, R.TYPEID, "
					+ "E.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, E.EMAIL, E.POSITIONID, E.ACCOUNTID, E.REPORTSTO, A.ACCOUNTNUM, "
					+ "E2.EMPLOYEEID AS MANID, E2.FIRSTNAME AS MANFNAME, E2.LASTNAME AS MANLNAME, E2.EMAIL AS MANEMAIL \r\n" + 
					"FROM REIMBURSEMENTS R \r\n" + 
					"INNER JOIN EMPLOYEE E ON \r\n" + 
					"R.EMPLOYEEID = E.EMPLOYEEID \r\n" + 
					"INNER JOIN REIMBURSEMENTSTATUS RS ON \r\n" + 
					"RS.STATUSID = R.STATUSID \r\n" + 
					"INNER JOIN REIMBURSEMENTTYPE RT ON \r\n" + 
					"RT.TYPEID = R.TYPEID\r\n" + 
					"INNER JOIN ACCOUNT A ON\r\n" + 
					"E.EMPLOYEEID = A.EMPLOYEEID\r\n" + 
					"INNER JOIN EMPLOYEE E2 ON\r\n" + 
					"E2.EMPLOYEEID = E.REPORTSTO\r\n"
					+ "WHERE E.REPORTSTO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int reimbursementid = rs.getInt("REIMBURSEMENTID");
				int employeeid = rs.getInt("EMPLOYEEID");
				double amount = rs.getDouble("AMOUNT");
				int resolverid = rs.getInt("RESOLVERID");
				int statusid = rs.getInt("STATUSID");
				int typeid = rs.getInt("TYPEID");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String email = rs.getString("email");
				int position = rs.getInt("positionid");
				int accountid = rs.getInt("accountid");
				int reportsto = rs.getInt("reportsto");
				int accountnum = rs.getInt("accountnum");
				String fname2 = rs.getString("MANFNAME");
				String lname2 = rs.getString("MANLNAME");
				String email2 = rs.getString("MANEMAIL");
				r.add( new Reimbursement(reimbursementid, amount, new Employee(employeeid, fname, lname, email, position, new Account(accountid, accountnum), reportsto), new Employee(resolverid, fname2, lname2, email2), new ReimbStatus(statusid), new ReimbType(typeid)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
}

