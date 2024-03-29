package com.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertWithPrepared {

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
		//stmt = conn.createStatement();
		PreparedStatement pst = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the information of patient (name,mobile,age,gender)");
		String pname = sc.next();
		long pmobile = sc.nextLong();
		int page = sc.nextInt();
		String gender = sc.next();
		
		String s = "insert into patients (pname,pmobile,page,gender) values('"+pname+"',"+pmobile+","+page+",'"+gender+"')";
		//step 4
		int i = stmt.executeUpdate(s);
		if(i>0) {
			System.out.println("Patient registered successfully!!");
		}
		else {
			System.out.println("Something went wrong please try again!!");
		}
	}

}
