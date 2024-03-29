package com.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MainAppJdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/hospital_manage";
		String un = "root";
		String pass = "123456";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		 //step 1
		Class.forName(driver);
		
		//step 2
		conn = DriverManager.getConnection(url,un,pass);
		
		//step 3
		stmt = conn.createStatement();
		
		//step 4
		String s ="select * from patients";
		
		rs = stmt.executeQuery(s);
		while(rs.next())
		System.out.println(rs.getString("pname"));
	}

}
