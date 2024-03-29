package com.edu.jdbc.proj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Operations {
	public static Connection conn;
	public static Statement stmt;
	public static ResultSet rs;
	public static PreparedStatement ps;
	
	private static String query;
	
	static Scanner sc = new Scanner(System.in);

	private static String name;
	private static int id;
	private static int age;
	private static String teacher;
	private static String sclass;
	
	public static void showTable() throws SQLException {
		System.out.println("**************Showing Table******************");
		conn = DatabaseConnection.getConnection();
		 query = "select * from students";
		 ps = conn.prepareStatement(query);
		 rs = ps.executeQuery();
		 
		 System.out.println("Id \t Name \t Age \t Class \t Teacher");
		 System.out.println("---------------------------------------------------------------");
		 
		 while(rs.next()) {
			 id = rs.getInt("sid");
			 name = rs.getString("sname");
			 age = rs.getInt("sage");
			 sclass = rs.getString("sclass");
			 teacher = rs.getString("teacher");
			 
			 System.out.println(id+"\t"+name+"\t"+age+"\t"+sclass+"\t"+teacher);
			 System.out.println("---------------------------------------------------------------");
			 
		 }
		}

	public static void addStudent() throws SQLException {
		System.out.println("**************Adding Student******************");
		conn = DatabaseConnection.getConnection();
		System.out.println("Enter the name: ");
		name = sc.next();
		System.out.println("Enter the age: ");
		age = sc.nextInt();
		System.out.println("Enter the class: ");
		sclass = sc.next();
		System.out.println("Enter your teacher name: ");
		teacher = sc.next();
		
		query = "insert into students (sname,sage,sclass,teacher) values(? ,?, ?, ?)";
		ps = conn.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2,age);
		ps.setString(3, sclass);
		ps.setString(4, teacher);
		
		int i = ps.executeUpdate();
		if(i>0) {
			  System.out.println("Student Registered Successfully");
		  }else {
			  System.out.println("Not registered !!");
		  }
		
	}

	public static void deleteStudent() throws SQLException {
	    System.out.println("**************Delete Student******************");
	    conn = DatabaseConnection.getConnection();
	    System.out.println("Enter id of student to delete the record.");
	    int did = sc.nextInt();
	    
	    String checkId = "SELECT COUNT(sid) FROM students WHERE sid = ?";
	    ps = conn.prepareStatement(checkId);
	    ps.setInt(1, did);
	    rs = ps.executeQuery();
	    rs.next(); // Move the cursor to the first row
	    int count = rs.getInt(1); // Get the count from the result set
	    
	    if (count > 0) {
	        // Student with the given id exists, proceed with deletion
	        String deleteQuery = "DELETE FROM students WHERE sid = ?";
	        ps = conn.prepareStatement(deleteQuery);
	        ps.setInt(1, did);
	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Student record deleted successfully.");
	        } else {
	            System.out.println("Failed to delete student record.");
	        }
	    } else {
	        System.out.println("Student with id " + did + " does not exist.");
	    }
	}


	public static void updateStudent() throws SQLException {
		System.out.println("**************Update Student******************");
		conn = DatabaseConnection.getConnection();
		System.out.println("Enter your id to update the information: ");
		int updateId = sc.nextInt();
		query = "select count(updateId) from students";
		
		ps = conn.prepareStatement(query);
		
		
	}

}
