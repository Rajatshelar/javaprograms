package com.edu.encp;

import java.util.Scanner;

class Student {
	int id;
	String fname;
	String lname;
	int rno;
	long prn;
	String college;
	
	void InputData(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id: ");
		id= sc.nextInt();
		 System.out.println("Enter your first name: ");
		 fname = sc.next();
		 System.out.println("Enter your last name: ");
		 lname = sc.next();
		 System.out.println("Enter your Roll number: ");
		 rno = sc.nextInt( );
		 				
	}
	
	void OutputData() {
		System.out.println("id: "+id);
		System.out.println("First Name: "+fname);
		System.out.println("Last Name: "+lname);
		System.out.println("Roll number: "+rno);
		
	}
}

public class MainStudent {

	public static void main(String[] args) {
		Student sobj = new Student();
		sobj.InputData();
		sobj.OutputData();
		

	}

}
