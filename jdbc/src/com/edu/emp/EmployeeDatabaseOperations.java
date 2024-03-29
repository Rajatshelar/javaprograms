package com.edu.emp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDatabaseOperations {
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;
	private static Scanner sc = new Scanner(System.in);
	private static String sql;
	private static int id;
	private static String name;
	private static int age;
	private static String email;
	private static long ph;
	private static float salary;
	private static int choice;
	private static int i;
	
	
	public static void displayEmployee() throws SQLException {
		conn = DataBaseConnection.getConnection();
		stmt = conn.createStatement();
		String sql = "select * from employee";
		rs = stmt.executeQuery(sql);
		System.out.printf("%-5s | %-10s | %-5s | %-20s | %-15s | %-12s %n","Id","Ename","Age","Email","Phone","Salary");
		System.out.println("-----------------------------------------------------------------------------------------");
		
		while(rs.next()) {
			
			System.out.printf("%-5d | %-10s | %-5d | %-20s | %-15d | %-10.2f %n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getFloat(6));

		}
	}//display emp - admin

	public static void insertEmployee() throws SQLException {
		
		int id;
		String name;
		int age;
		String email;
		long ph;
		float salary;
		
		conn = DataBaseConnection.getConnection();
		stmt = conn.createStatement();
		
		//Execute query
		
		// take data from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id, name, age, email, ph, salary:");
		
		id = sc.nextInt();
		
		// check if id already exists
		String checkId = "select * from employee where eid ="+id;
		
		rs = stmt.executeQuery(checkId);
		
		if (rs.next()) {
			System.out.println("ID already exists. Please enter a unique ID.");
			return;
		}		
		
		name = sc.next();
		age = sc.nextInt();
		email = sc.next();
		
		//check if email already exists
		String checkMail = "select * from employee where eemail = '"+email+"'";
		
		rs= stmt.executeQuery(checkMail);
		
		if(rs.next()) {
			System.out.println("Email already exists. Please enter a different email.");
            return;
		}
		
		ph=sc.nextLong();
		
		// check if phone already exists
		String checkPh = "select * from employee where ephone="+ph;
		rs = stmt.executeQuery(checkPh);
		
		if(rs.next()) {
			System.out.println("Phone number already exists. Please enter a different phone number.");
            return;
		}
		
		
		salary = sc.nextFloat();
		
		if(salary<50000) {
			System.out.println("Salary should be greater than 50,000...");
			return;
		}
		
		String s = "insert into employee values("+id+",'"+name+"',"+age+",'"+email+"',"+ph+","+salary+")"; 
		
		int i = stmt.executeUpdate(s);// i>0 record inserted successfully
		
		if (i>0) {
			System.out.println("Registration done successfully...");
		}
		else {
			System.out.println("Some error occured");
		}
		
	}// insert emp - admin

	public static void deleteEmployee() throws SQLException {
		
		conn = DataBaseConnection.getConnection();
		stmt = conn.createStatement();
		int eid;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id to remove: ");
		eid = sc.nextInt();
		
		String sql = "select * from employee where eid ="+eid;
		rs = stmt.executeQuery(sql);

		if(rs.next()){
			String delsql = "delete from employee where eid="+eid;
			int i = stmt.executeUpdate(delsql);
			if(i>0) {
				System.out.println("Record is deleted");
			}
			else {
				System.out.println("Some error occurred");
			}
		}
		else {
			System.out.println("Employee id not exists");
		}	
		
	}//delete emp - admin

	public static void updateEmployee() throws SQLException {
		conn = DataBaseConnection.getConnection();
		stmt = conn.createStatement();
		
		int eid;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to update the Employee: ");
		eid = sc.nextInt();
		
		//check if id already exists
		String checkId = "select * from employee where eid ="+eid;
				
		rs = stmt.executeQuery(checkId);
		
		if(!rs.next()) {
			System.out.println("Employee Id does not exists. Please enter valid employee Id....");
			return;
		}else {
			while(true) {
				System.out.println("Choose the parameter you want to update:");
				System.out.println("1.Age\n2.Email\n3.Phone\n4.Salary\n5.Exit");
				choice = sc.nextInt();
				
				switch(choice) {
				
				case 1: //update age 
					System.out.println("Enter updated employee age: ");
					int up_age = sc.nextInt();
					String updtAgeSql = "update employee set eage="+up_age+ " where eid="+eid;
					i = stmt.executeUpdate(updtAgeSql);
					if (i>0) {
						System.out.println("Age updated...");
					}else {
						System.out.println("Some error occured... ");
					}
					break;
					
				case 2: //update email
					System.out.println("Enter updated employee Email Id: ");
					String up_mail = sc.next();
					String updtEmailSql = "update employee set eemail='"+up_mail+ "' where eid="+eid;
					i = stmt.executeUpdate(updtEmailSql);
					if (i>0) {
						System.out.println("Email updated...");
					}else {
						System.out.println("Some error occured... ");
					}
					break;
					
				case 3: //update phone
					System.out.println("Enter updated employee phone number: ");
					long up_phone = sc.nextLong();
					String updtphoneSql = "update employee set ephone="+up_phone+ " where eid="+eid;
					i = stmt.executeUpdate(updtphoneSql);
					if (i>0) {
						System.out.println("Phone updated...");
					}else {
						System.out.println("Some error occured... ");
					}
					break;
					
				case 4://update salary
					System.out.println("Enter updated employee salary: ");
					float up_salary = sc.nextFloat();
					if(up_salary < 50000) {
						System.out.println("Salary should be greater than 50,000...");
						return;
					}
					String updtSalarySql = "update employee set esalary="+up_salary+ " where eid="+eid;
					i = stmt.executeUpdate(updtSalarySql);
					if (i>0) {
						System.out.println("Salary updated...");
					}else {
						System.out.println("Some error occured... ");
					}
					break;
				
				case 5:
					System.out.println("Updates completed.....\nExiting the updates....");
					return;
				
				default:
					System.out.println("Invalid choice....");
				}
			}
		}
		
		
	}// update emp - admin

	public static void displayUserById() throws SQLException {
		
		conn = DataBaseConnection.getConnection();
		stmt = conn.createStatement();
		
		System.out.println("Enter your Employee Id: ");
		int id = sc.nextInt();
		
		sql = "select * from employee where eid="+id;
		
		rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			
			System.out.printf("%-5s | %-10s | %-5s | %-20s | %-15s | %-12s %n","Id","Ename","Age","Email","Phone","Salary");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.printf("%-5d | %-10s | %-5d | %-20s | %-15d | %-10.2f %n",rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getFloat(6));

		}else {
			System.out.println("Employee not exist Register first... ");
		}
		
	}// display details - user 

	public static void registerNewUser() throws SQLException {
		
		conn = DataBaseConnection.getConnection();
		stmt = conn.createStatement();
		
		//Execute query
		
		// take data from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id, name, age, email, ph, salary:");
		
		id = sc.nextInt();
		
		// check if id already exists
		String checkId = "select * from employee where eid ="+id;
		
		rs = stmt.executeQuery(checkId);
		
		if (rs.next()) {
			System.out.println("ID already exists. Please enter a unique ID.");
			return;
		}		
		
		name = sc.next();
		age = sc.nextInt();
		email = sc.next();
		
		//check if email already exists
		String checkMail = "select * from employee where eemail = '"+email+"'";
		
		rs= stmt.executeQuery(checkMail);
		
		if(rs.next()) {
			System.out.println("Email already exists. Please enter a different email.");
            return;
		}
		
		ph=sc.nextLong();
		
		// check if phone already exists
		String checkPh = "select * from employee where ephone="+ph;
		rs = stmt.executeQuery(checkPh);
		
		if(rs.next()) {
			System.out.println("Phone number already exists. Please enter a different phone number.");
            return;
		}
		
		
		salary = sc.nextFloat();
		
		if(salary<50000) {
			System.out.println("Salary should be greater than 50,000...");
			return;
		}
		
		String s = "insert into employee values("+id+",'"+name+"',"+age+",'"+email+"',"+ph+","+salary+")"; 
		
		int i = stmt.executeUpdate(s);// i>0 record inserted successfully
		
		if (i>0) {
			System.out.println("Registration done successfully...");
		}
		else {
			System.out.println("Some error occured");
		}
		
	
}// register user - user

	public static void updateUserById() throws SQLException {
		
		System.out.println("Enter id to update the Employee: ");
		id = sc.nextInt();
		
		//check if id already exists
		String checkId = "select * from employee where eid ="+id;
				
		rs = stmt.executeQuery(checkId);
		
		if(!rs.next()) {
			System.out.println("Employee Id does not exists. Please enter valid employee Id....");
			return;
		}else {
			while(true) {
				System.out.println("Choose the parameter you want to update:");
				System.out.println("1.Age\n2.Email\n3.Phone\n4.Exit");
				choice = sc.nextInt();
				
				switch(choice) {
				
				case 1: //update age 
					System.out.println("Enter updated employee age: ");
					int up_age = sc.nextInt();
					String updtAgeSql = "update employee set eage="+up_age+ " where eid="+id;
					i = stmt.executeUpdate(updtAgeSql);
					if (i>0) {
						System.out.println("Age updated...");
					}else {
						System.out.println("Some error occured... ");
					}
					break;
					
				case 2: //update email
					System.out.println("Enter updated employee Email Id: ");
					String up_mail = sc.next();
					String updtEmailSql = "update employee set eemail='"+up_mail+ "' where eid="+id;
					i = stmt.executeUpdate(updtEmailSql);
					if (i>0) {
						System.out.println("Email updated...");
					}else {
						System.out.println("Some error occured... ");
					}
					break;
					
				case 3: //update phone
					System.out.println("Enter updated employee phone number: ");
					long up_phone = sc.nextLong();
					String updtphoneSql = "update employee set ephone="+up_phone+ " where eid="+id;
					i = stmt.executeUpdate(updtphoneSql);
					if (i>0) {
						System.out.println("Phone updated...");
					}else {
						System.out.println("Some error occured... ");
					}
					break;
				
				case 4:
					System.out.println("Updates completed.....\nExiting the updates....");
					return;
				
				default:
					System.out.println("Invalid choice....");
				}
			}// while close
		}//else close
	}// update close - user 

}
