package com.edu.emp;

import java.sql.SQLException;
import java.util.Scanner;

public class MainAppEmployee {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		int ch, mainCh;
		char c;
		
		System.out.println("**************Main Menu****************");
		System.out.println("Are you Admin or Employee?");
		System.out.println("1.Admin \n2.Employee\n3.Exit");
		mainCh  = sc.nextInt();
		switch(mainCh) {
		case 1:
		for(;;) {// admin menu
			System.out.println("***********MENU**********");
			System.out.println("1. Show all employees");
			System.out.println("2. Add employees");
			System.out.println("3. Remove employees");
			System.out.println("4. Update employees");
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();
			
			switch(ch) {
			case 1: //Display record
				EmployeeDatabaseOperations.displayEmployee();
				break;
			
			case 2:
				EmployeeDatabaseOperations.insertEmployee();
				break;
				
			case 3:
				EmployeeDatabaseOperations.deleteEmployee();
				break;
				
			case 4:
				EmployeeDatabaseOperations.updateEmployee();
				break;
				
			default:
				System.out.println("Invalid Input...");
				break;
			}//switch end
			System.out.println("Do you want to continue, press y, press any other key to exit the system...");
			c = sc.next().toLowerCase().charAt(0);
			if (c!='y') {
				System.out.println("Thanks for using the application... \nExiting the program....");
				break;
			}
		}
		break;
		
		case 2: //user
			// select his details by asking ID 
			// Id not exists ask him to register himself
			//facility to updte his details only
			for(;;) {
				
				System.out.println("***********MENU**********");
				System.out.println("1. Show Details");
				System.out.println("2. Register");
				System.out.println("3. Update Details");
				System.out.println("Enter your choice: ");
				ch = sc.nextInt();
				
				switch(ch) {
				case 1: //display 
					
					EmployeeDatabaseOperations.displayUserById();
					break;
					
				case 2: // register
					EmployeeDatabaseOperations.registerNewUser();
					break;
					
				
				case 3://update
					EmployeeDatabaseOperations.updateUserById();
					break;
				
				default:
					System.out.println("Invalid Input...");
					break;
				}//switch end
				
				System.out.println("Do you want to continue, press y, press any other key to exit the system...");
				c = sc.next().toLowerCase().charAt(0);
				if (c!='y') {
					System.out.println("Thanks for using the application... \nExiting the program....");
					break;
				}	
				
				}
				
			}//user infinite for loop
		
		}// main switch close
	}


