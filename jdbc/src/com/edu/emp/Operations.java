package com.edu.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operations {
	private static Statement st;
	private static Connection conn;
	private static ResultSet  rs;
	private static String query;
	private static PreparedStatement pst;
	
	public static void showCredentials(String status) throws SQLException {
		conn =DataBaseConnection.getConnection();
		query = "select * from Credentials where status = ?";
		pst  = conn.prepareStatement(query);
		pst.setString(1, status);
		rs = pst.executeQuery();
		System.out.println("| uid  | uname | pass  | status |");
		if(rs.next()) {
			System.out.println(rs.getInt(1));
		}
	}
}
