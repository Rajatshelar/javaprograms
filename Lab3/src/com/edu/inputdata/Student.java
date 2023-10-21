package com.edu.inputdata;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Your id: ");
		int id = sc.nextInt();
		System.out.println("Enter Your Name: ");
		String name = sc.next();
		System.out.println("Enter Fees: ");
		float fee =sc.nextFloat();
		System.out.println("Enter Your Gender: ");
		String gender = sc.next();
		
		System.out.println("Name: "+id);
		System.out.println("Name: "+name);
		System.out.println("Name: "+fee);
		System.out.println("Name: "+gender);
	

	}

}
