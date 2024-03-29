package com.edu.SchoolManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Admin {
	private static Statement st;
	private static Connection conn;
	private static ResultSet  rs;
	private static String query;
	private static PreparedStatement pst;
	
	private static String student_name;
	private static String uname;
	private static String status;
	private static String email;
	private static String mobile;
	private static String teacher_name;
	
	private static int course_id;
	private static String course_name;
	private static int fees;
	private static int uid;
	
	
	static Random random = new Random();
	static Scanner sc = new Scanner(System.in);
	
	public static void addStudent() throws SQLException {
		
		System.out.println("Let's add student...............");
		
		System.out.println("Enter Student Name: ");
		student_name =sc.next();
		
		System.out.println("Enter Email: ");
		email = sc.next();
		
		System.out.println("Enter Mobile No. :");
		mobile = sc.next();
		
		int min =10000;
		int max =99999;
		int uid = random.nextInt(max - min + 1) + min;
		
		conn = DataBaseConnection.getConnection();
		
		query = "insert into student values( ? , ? , ? , ? )";
		
		pst = conn.prepareStatement(query);
		
		pst.setInt(1, uid);
		pst.setString(2, student_name);
		pst.setString(3, email);
		pst.setString(4, mobile);
		
		int rows_affected = pst.executeUpdate();
		
		if(rows_affected == 1) {
			System.out.println("Student Added successfully....");
			int minn =100000;
			int maxx =999999;
			int passs = random.nextInt(max - min + 1) + min;
			String pass = Integer.toString(passs);
			status = "student";
			
			query = " insert into Credentials (uid,uname,pass,status) values(?,?,?,?)";
			pst = conn.prepareStatement(query);
			pst.setInt(1, uid);
			pst.setString(2, student_name);
			pst.setString(3,pass );
			pst.setString(4, status);
			
			int u = pst.executeUpdate();
		}
		else {
			System.out.println("Something went wrong!!!!!!");
		}
	}
	
	public static void addTeacher() throws SQLException {
		
		System.out.println("Let's add Teacher...............");
		
		System.out.println("Enter Teacher Name: ");
		teacher_name =sc.next();
		
		System.out.println("Enter Email: ");
		email = sc.next();
		
		System.out.println("Enter Mobile No. :");
		mobile = sc.next();
		
		int min =10000;
		int max =99999;
		int uid = random.nextInt(max - min + 1) + min;
		
		conn = DataBaseConnection.getConnection();
		
		query = "insert into teacher values( ? , ? , ? , ? )";
		
		pst = conn.prepareStatement(query);
		
		pst.setInt(1, uid);
		pst.setString(2, teacher_name);
		pst.setString(3, email);
		pst.setString(4, mobile);
		
		int rows_affected = pst.executeUpdate();
		
		if(rows_affected == 1) {
			System.out.println("Teacher Added successfully....");
			
			int minn =100000;
			int maxx =999999;
			int passs = random.nextInt(max - min + 1) + min;
			String pass = Integer.toString(passs);
			status = "teacher";
			
			query = " insert into Credentials (uid,uname,pass,status) values(?,?,?,?)";
			pst = conn.prepareStatement(query);
			pst.setInt(1, uid);
			pst.setString(2, teacher_name);
			pst.setString(3,pass );
			pst.setString(4, status);
			
			int u = pst.executeUpdate();
		}
		else {
			System.out.println("Something went wrong!!!!!!");
		}
		
	}

	public static void addCourse() throws SQLException {
	    System.out.println("Let's add a New Course...............");
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter Course Id:");
	    int course_id = sc.nextInt();
	    
	    System.out.println("Enter Course Name:");
	    String course_name = sc.next();
	    
	    System.out.println("Enter course fees:");
	    int fees = sc.nextInt();
	    
	    System.out.println("Enter the teacher id for assigning to this course:");
	    int uid = sc.nextInt();
	    
	   
	    Connection conn = DataBaseConnection.getConnection();
	    
	    // Check if the provided teacher id exists
	    String squery = "SELECT COUNT(uid) FROM teacher WHERE uid = ?";
	    PreparedStatement pst = conn.prepareStatement(squery);
	    pst.setInt(1, uid);
	    ResultSet rs = pst.executeQuery();
	    
	    if (rs.next()) {
	        int count = rs.getInt(1);
	        
	        if (count == 1) { // If teacher id exists, proceed with course insertion
	            String query = "INSERT INTO course VALUES (?, ?, ?, ?)";
	            
	            pst = conn.prepareStatement(query);
	            
	            pst.setInt(1, course_id);
	            pst.setString(2, course_name);
	            pst.setInt(3, fees);
	            pst.setInt(4, uid); // Assign the teacher id to the course
	            
	            int rowsAffected = pst.executeUpdate();
	            
	            if (rowsAffected == 1) {
	                System.out.println("Course Added successfully....");
	            } else {
	                System.out.println("Something went wrong while adding the course.");
	            }
	        } else {
	            System.out.println("Invalid teacher id. Please enter a valid teacher id.");
	        }
	    }
	   
	}

	
	public static void enrollStudent() throws SQLException {
		System.out.println("*******************Enroll Students*****************");
		
		System.out.println("Enter the student id");
		uid = sc.nextInt();
		
		int min =10000;
		int max =99999;
		int eid = random.nextInt(max - min + 1) + min;
		
		conn = DataBaseConnection.getConnection();
		query = "select * from student where uid = ?";
		
		pst = conn.prepareStatement(query);
		pst.setInt(1, uid);
		rs = pst.executeQuery();
		if(rs.next()) {
			

		System.out.println("Enter the course id");
		int course_id = sc.nextInt();
		
		String query1 = "select * from course where course_id = ?";
		
		pst = conn.prepareStatement(query1);
		pst.setInt(1, course_id);
		rs = pst.executeQuery();
		if(rs.next()) {

		String query3 = "insert into enrollment (enid,uid,course_id) values(?,?,?)";
		
		pst = conn.prepareStatement(query3);
		pst.setInt(1, eid);
		pst.setInt(2, uid);
		pst.setInt(3, course_id);
		
		int affected = pst.executeUpdate();
		if(affected == 1) {
			System.out.println("Student Enrolled Successfully..");
			
			int fees = 0;
			String query4 = "select fees from course where course_id = ?";
			pst = conn.prepareStatement(query4);
			pst.setInt(1, course_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				fees = rs.getInt("fees");
			}
			String query5 = "UPDATE total_payment SET total_to_be_pay = total_to_be_pay + ? WHERE uid = ?";
			pst = conn.prepareStatement(query5);
			pst.setInt(1, fees);
			pst.setInt(2,uid );
			int a = pst.executeUpdate();
		}
		else {
			System.out.println("Something went wrong try again!!");
		}
		
		
		}
		else {
			System.out.println("Invalid Course id!! Enter valid Course id");
			enrollStudent();
		}
		
		}
		else {
			System.out.println("Invalid Student id!! Enter valid student id");
			enrollStudent();
		}
	}
	
	public static void payFees() {
		
	}
	
	public static void showRemainingFees() {
		
	}
	
	public static void showStudentStatus() {
		
	}
	
	public static void updateStudentInfo() {
		
	}
	
	public static void changePass() {
		
	}
	}
