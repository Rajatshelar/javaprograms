package com.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatePatient {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		String driver = "com.mysql.cj.jdbc.Driver";
		
		String url = "";
		String un = "root";
		String pass = "123456";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url,un,pass);
		
		stmt = conn.createStatement();
		
		String s =""
	}

}
