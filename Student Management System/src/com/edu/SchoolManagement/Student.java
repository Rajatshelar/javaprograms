package com.edu.SchoolManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	private static Connection conn = null;
	private static Scanner sc = new Scanner(System.in);
	private static String query;
	private static PreparedStatement pst;
	
	

	public static void updateStudentName() {
	    try {
	        conn = DataBaseConnection.getConnection();
	        System.out.println("Enter Student ID:");
	        int uid = sc.nextInt();
	        System.out.println("Enter New Student Name:");
	        String newName = sc.next();
	        
	        String query = "UPDATE student SET student_name = ? WHERE uid = ?";
	        pst = conn.prepareStatement(query);
	        pst.setString(1, newName);
	        pst.setInt(2, uid);
	        
	        int rowsAffected = pst.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Student name updated successfully!");
	        } else {
	            System.out.println("Failed to update student name.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void updateEmail() {
	    try {
	        conn = DataBaseConnection.getConnection();
	        System.out.println("Enter Student ID:");
	        int uid = sc.nextInt();
	        System.out.println("Enter New Email:");
	        String newEmail = sc.next();
	        
	        String query = "UPDATE student SET email = ? WHERE uid = ?";
	        pst = conn.prepareStatement(query);
	        pst.setString(1, newEmail);
	        pst.setInt(2, uid);
	        
	        int rowsAffected = pst.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Email updated successfully!");
	        } else {
	            System.out.println("Failed to update email.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void updateMobile() {
	    try {
	        conn = DataBaseConnection.getConnection();
	        System.out.println("Enter Student ID:");
	        int uid = sc.nextInt();
	        System.out.println("Enter New Mobile Number:");
	        String newMobile = sc.next();
	        
	        String query = "UPDATE student SET mobile = ? WHERE uid = ?";
	        pst = conn.prepareStatement(query);
	        pst.setString(1, newMobile);
	        pst.setInt(2, uid);
	        
	        int rowsAffected = pst.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Mobile number updated successfully!");
	        } else {
	            System.out.println("Failed to update mobile number.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}



}
