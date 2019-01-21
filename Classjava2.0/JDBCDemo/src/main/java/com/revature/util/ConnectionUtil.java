package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	
	//this is terrible, dont do it
	public static Connection getConnection() throws SQLException{
		String url = "";
		String user = "";
		String pass = "";
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static Connection getConnection(String filename) throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		//character stream if FILEINPUTSTREAM
		
		prop.load(in);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	}
}
