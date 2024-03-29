package com.edu.SchoolManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
		private static String uname;
		private static String pass;
		private static String status;
		private static int uid;
		
	
	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------------------------");
		System.out.println("**************Hello, Welcome to Portal****************");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("1. Admin \n 2.Teacher \n 3.Student \n 4.Principal ");
		System.out.println("Enter Your Choice..");
		int ch = sc.nextInt();
		
	switch (ch) {
	case 1 :
		
		{
			System.out.println("**************Hello, Admin****************");
		System.out.println("Enter username and password....");
		System.out.println("Enter Username");
		 uname = sc.next();
		System.out.println("Enter Password");
		 pass = sc.next();
		 status = "admin";
		if(Operations.loginU(uname, pass,status)) {
			System.out.println("Login Successfull...");
			for(;;) {
			System.out.println(" 1. Add Student. \n 2. Add Teacher \n 3. Add Course.\n 4. Enroll Student\n 5. Pay Fees. \n 6. Show Remaining Fees.\n 7.Show Student Status.\n 8. Upadate Student Information \n 9. Change Password.");
			
			int ach = sc.nextInt();
			switch(ach) {
			case 1: {
				Admin.addStudent();
				
			}// internal ach case 1 close
			break;
			case 2:{
				Admin.addTeacher();
			}// internal ach case 2 close
			break;
			case 3:{
				Admin.addCourse();
			}
			break;
			case 4:{
				Admin.enrollStudent();
			}
			break;
			case 5:{
				Operations.payFees();
			}
			break;
			case 6:{
				Operations.showRemainingFees();
			}
			break;
			case 7:{
				System.out.println("Enter the Student ID: ");
				uid = sc.nextInt();
				Operations.showStatus(uid);
			}
			break;
			case 8:{
				{
				    System.out.println("*************Edit Student Information**************!");
				    
				    System.out.println("1. Update Student Name \n2. Update Email  \n3. Update Mobile");
				    
				    System.out.println("Enter your choice:");
				    int choice = sc.nextInt();
				    
				    switch (choice) {
				        case 1:
				            Student.updateStudentName();
				            break;
				        case 2:
				            Student.updateEmail();
				            break;
				        case 3:
				            Student.updateMobile();
				            break;
				        default:
				            System.out.println("Invalid choice!");
				    }
				}
			}
			break;
			case 9:{
				System.out.println("*************Let's change your password**************");
				
				System.out.println("Enter your id: ");
				uid = sc.nextInt();
				
				System.out.println("Enter your old password: ");
				pass = sc.next();
				
				if(Operations.changePass(uid, pass)) {
					System.out.println("Success.... \n Password Changed...");
				}
				else {
					System.out.println("wrong Credentials!! try again.");
					
				}
				
				
			}
			break;
			default:
				System.out.println("Invalid Input.....");
				break;
			} //ach  switch  close
			System.out.println("Do you want to continue, press y, press any other key to exit the system...");
			char c = sc.next().toLowerCase().charAt(0);
			if (c!='y') {
				System.out.println("Thanks for using the application... \nExiting the program....");
				break;
			}
		}// for loop close
		
		}//if close
		else {
			System.out.println("Invalid Credentials!!");
		}
		}  //switch case 1 close
		break;
		
	
		
	case 2: 
		
	{ // switch case 2 start
		System.out.println("**************Hello, Teacher****************");
		System.out.println("Enter username and password....");
		System.out.println("Enter Username");
		 uname = sc.next();
		System.out.println("Enter Password");
		 pass = sc.next();
		 status = "teacher";
		if(Operations.loginU(uname, pass,status)) {
			System.out.println("Login Successfull...");
			for(;;){
			System.out.println("1.  \n 2.  \n 3. \n 4.\n 5. \n 6. \n ");
			int tch =sc.nextInt();
			
			switch(tch) {
			case 1:{
				
				break;
			}// tch case 1 close
			default:
				System.out.println("Invalid Input...");
				break;
			}// switch tch close
			System.out.println("Do you want to continue, press y, press any other key to exit the system...");
			char c = sc.next().toLowerCase().charAt(0);
			if (c!='y') {
				System.out.println("Thanks for using the application... \nExiting the program....");
				break;
			
		}//if close 
			} // switch case 2 for loop close
		}//login if close
		}// switch ch case 2 close
		
	
		break;
	case 3:
		
	{
		System.out.println("**************Hello, Student****************");
	System.out.println("Enter username and password....");
	System.out.println("Enter Username");
	String uname = sc.next();
	System.out.println("Enter Password");
	String pass = sc.next();
	String status = "student";
	if(Operations.loginU(uname, pass,status)) {
		System.out.println("Login Successfull...");
		for(;;) {
		System.out.println("1. \n 2.\n  3. \n 4. \n 5. \n 6.");
		
		int sch = sc.nextInt();
		switch(sch) {
		case 1: {
			
			
		}// internal ach case 1 close
		break;
		case 2:{
			
		}// internal ach case 2 close
		break;
		case 3:{
			
		}
		break;
		case 4:{
			
		}
		break;
		case 5:{
			
		}
		break;
		default:
			System.out.println("Invalid Input.....");
			break;
		} //ach  switch  close
		System.out.println("Do you want to continue, press y, press any other key to exit the system...");
		char c = sc.next().toLowerCase().charAt(0);
		if (c!='y') {
			System.out.println("Thanks for using the application... \nExiting the program....");
			break;
		}
	}// for loop close
	
	}//if close
	else {
		System.out.println("Invalid Credentials!!");
	}
	}  //switch case 1 close
	break;
	

	case 4:
	{ // switch case 2 start
		System.out.println("**************Hello, Principal****************");
		System.out.println("Enter username and password....");
		System.out.println("Enter Username");
		String uname = sc.next();
		System.out.println("Enter Password");
		String pass = sc.next();
		String status = "principal";
		if(Operations.loginU(uname, pass,status)) {
			System.out.println("Login Successfull...");
			for(;;){
			System.out.println("1.  \n 2.  \n 3. \n 4.\n 5. \n 6. \n ");
			int tch =sc.nextInt();
			
			switch(tch) {
			case 1:{
				
				break;
			}// tch case 1 close
			default:
				System.out.println("Invalid Input...");
				break;
			}// switch tch close
			System.out.println("Do you want to continue, press y, press any other key to exit the system...");
			char c = sc.next().toLowerCase().charAt(0);
			if (c!='y') {
				System.out.println("Thanks for using the application... \nExiting the program....");
				break;
			
		}//if close 
			} // switch case 2 for loop close
		}//login if close
		}// switch ch case 2 close
	break;
	}
	
	
	}
}
