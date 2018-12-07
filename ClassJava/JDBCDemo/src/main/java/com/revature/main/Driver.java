package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		try {
			
			Connection con = ConnectionUtil.getConnection("connection.properties");
			System.out.println(con);
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
