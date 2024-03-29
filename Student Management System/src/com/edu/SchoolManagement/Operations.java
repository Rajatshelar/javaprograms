package com.edu.SchoolManagement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Operations {
	private static int uid;
	private static int fees;
	
	
	private static Statement st;
	private static Connection conn;
	private static ResultSet  rs;
	private static String query;
	private static PreparedStatement pst;
	private static Scanner sc = new Scanner(System.in);
	
	public static void showCredentials(String status) throws SQLException {
		conn =DataBaseConnection.getConnection();
		query = "select * from Credentials where status = ?";
		pst  = conn.prepareStatement(query);
		pst.setString(1, status);
		rs = pst.executeQuery();
		System.out.println("| uid  | uname | pass  | status |");
		if(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
	}
	
	public static boolean loginU(String uname, String pass, String status) throws SQLException {
	    Connection conn = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = DataBaseConnection.getConnection();
	        String query = "SELECT * FROM Credentials WHERE uname = ? AND pass = ? AND status = ?";
	        pst = conn.prepareStatement(query);
	        pst.setString(1, uname);
	        pst.setString(2, pass);
	        pst.setString(3, status);
	        rs = pst.executeQuery();
	        
	        if (rs.next()) { // Move the cursor to the first row
	            int count = rs.getInt(1);
	            return count == 1; // If count is 1, return true; otherwise, return false
	        }
	        
	        return false; // If there are no rows, return false
	    } finally {
	        
	    }
	}
	
	public static boolean changePass(int uid, String pass) throws SQLException {
		
		conn = DataBaseConnection.getConnection();
		
		query = "select * from Credentials where uid = ? and pass = ?";
		pst = conn.prepareStatement(query);
		pst.setInt(1, uid);
		pst.setString(2, pass);
		rs = pst.executeQuery();
		
		if(rs.next()) {
			System.out.println("Enter new password: ");
			String new_pass = sc.next();
			
			query = "update  Credentials set pass = ? where uid = ?";
			
			pst = conn.prepareStatement(query);
			pst.setString(1, new_pass);
			pst.setInt(2, uid);
			
			int change = pst.executeUpdate();
			if(change == 1) {
				//System.out.println("Password updated successfully...");
			return true;
		}
		
		}
		return false;
	}
	
	public static void payFees() {
	    try {
	        System.out.println("************Fees Payment**************");
	        System.out.println("Enter your Student id: ");
	        int uid = sc.nextInt();

	        conn = DataBaseConnection.getConnection();

	        String query = "SELECT * FROM student WHERE uid = ?";
	        pst = conn.prepareStatement(query);
	        pst.setInt(1, uid);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            int fees = 0;
	            String query1 = "SELECT total_to_be_pay from total_payment WHERE uid = ?";
	            pst = conn.prepareStatement(query1);
	            pst.setInt(1, uid);
	            rs = pst.executeQuery();
	            if (rs.next()) {
	                fees = rs.getInt("total_to_be_pay");
	            }
	            System.out.println("Your total remaining fees are: " + fees);

	            System.out.println("How much are you paying now? Enter the amount: ");
	            int paying = sc.nextInt();

	            if (paying <= fees && paying >= 0) {
	                query = "UPDATE total_payment SET total_to_be_pay = total_to_be_pay - ? WHERE uid = ?";
	                pst = conn.prepareStatement(query);
	                pst.setInt(1, paying);
	                pst.setInt(2, uid);

	                int affectedRows = pst.executeUpdate();
	                if (affectedRows == 1) {
	                    System.out.println("Fees paid successfully!");
	                } else {
	                    System.out.println("Failed to update payment.");
	                }
	            } else {
	                System.out.println("Enter an amount less than or equal to the remaining fees and greater than or equal to 0.");
	            }
	        } else {
	            System.out.println("Enter a valid Student Id!!");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void showRemainingFees() throws SQLException {
		
		 System.out.println("************Fees Payment**************");
	        System.out.println("Enter your Student id: ");
	        int uid = sc.nextInt();

	        conn = DataBaseConnection.getConnection();

	        String query = "SELECT * FROM student WHERE uid = ?";
	        pst = conn.prepareStatement(query);
	        pst.setInt(1, uid);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            int fees = 0;
	            String query1 = "SELECT total_to_be_pay from total_payment WHERE uid = ?";
	            pst = conn.prepareStatement(query1);
	            pst.setInt(1, uid);
	            rs = pst.executeQuery();
	            if (rs.next()) {
	                fees = rs.getInt("total_to_be_pay");
	            }
	            System.out.println("Your total remaining fees are: " + fees);
	}
	        else {
	        	System.out.println("Enter valid Student id!!");
	        	showRemainingFees();
	        }

	}
	public static void showStatus(int uid) {
	    try {
	        conn = DataBaseConnection.getConnection();
	        
	        String query = "SELECT s.uid, s.student_name, c.course_name, p.total_to_be_pay " +
	                       "FROM student s " +
	                       "LEFT JOIN enrollment e ON s.uid = e.uid " +
	                       "LEFT JOIN course c ON e.course_id = c.course_id " +
	                       "LEFT JOIN total_payment p ON s.uid = p.uid " +
	                       "WHERE s.uid = ?";
	        pst = conn.prepareStatement(query);
	        pst.setInt(1, uid);
	        ResultSet rs = pst.executeQuery();
	        
	        if (rs.next()) {
	            System.out.println("Student Status:");
	            System.out.println("+------+----------------------+----------------------+------------------+");
	            System.out.printf("| ID   | Name                 | Course               | Balance          |\n");
	            System.out.println("+------+----------------------+----------------------+------------------+");
	            System.out.printf("| %-4d | %-20s | %-20s | %-16d |\n", 
	                                  rs.getInt("uid"), rs.getString("student_name"), rs.getString("course_name"), rs.getInt("total_to_be_pay"));
	            while (rs.next()) {
	                System.out.printf("|      |                      | %-20s |                  |\n", rs.getString("course_name"));
	            }
	            System.out.println("+------+----------------------+----------------------+------------------+");
	        } else {
	            System.out.println("Student not found or no status available.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}




}
