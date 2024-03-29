package com.edu.jdbc.proj;

import java.sql.SQLException;
import java.util.Scanner;

public class MainAppMentor {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		for(;;) {
		System.out.println("*******************Menu**********************");
		System.out.println("1. Show Mentor-Mentee table. ");
		System.out.println("2. Add Student in Records.");
		System.out.println("3. Delete Student from Records.");
		System.out.println("4. Update Information. ");
		
		System.out.println("Enter Your Choice...");
		int ch = sc.nextInt();
		
		switch(ch) {
		
		case 1:
			Operations.showTable();
			break;
		case 2:
			Operations.addStudent();
			break;
		case 3:
			Operations.deleteStudent();
			break;
		case 4:
			Operations.updateStudent();
			break;
		default:
			System.out.println("Invalid Input!!");
		}
		
		System.out.println("Do you want to continue!! (Press Y)");
		char c = sc.next().toLowerCase().charAt(0);
		
		if(c != 'y') {
			System.out.println("Exited");
			break;
		}
		}
	}

}
