package com.edu.SchoolManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBaseConnection {
		private static String driver = "com.cj.mysql.jdbc.Driver";
		private static String  url = "jdbc:mysql://localhost:3306/StudentManagementSystem";
		private static String pass ="123456";
		private static String un = "root";
		private static Connection conn;
                      
	public static Connection getConnection() throws SQLException {
		
		if(conn == null) 
			
			conn = DriverManager.getConnection(url, un, pass);
			return conn;
		}
		
	}
