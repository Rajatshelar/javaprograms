package com.edu.switchs; 
import java.util.Scanner;

public class SwitchCaseExample {

	public static void main(String[] args) {
		int day;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number between 1 to 7.");
		day=sc.nextInt();
		
		switch(day){
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thrusday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
		default	:
				System.out.println("invalid");
				break;
		}

	}

}
