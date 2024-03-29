package com.edu.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/MyDB";
	private static String un = "root";
	private static String pass = "123456";
	private static Connection conn;
	
	// to get the connection
	public static Connection getConnection() throws SQLException {
		
		if (conn==null)
			conn = DriverManager.getConnection(url, un, pass);
		
		return conn;
		
	}

}
