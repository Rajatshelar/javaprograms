package com.edu.switchs;
import java.util.Scanner;
public class Calculator {

	public static void main(String[] args) {
		int ans;
        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        System.out.println("Enter your choice.");
        		System.out.println("Enter add to perform addition.");
        		System.out.println("Enter sub to perform substraction.");
        		
        		String option =sc.next();
        		
        		switch(option) {
        		case ("add"): ans =n1+n2;
        								System.out.println("the sum of "+n1+" and " +n2+ " is " +ans);
        								break;
        		case ("sub"): ans =n1-n2;
										System.out.println("the sub of "+n1+" and " +n2+ " is " +ans);
										break;	
        		case ("mul"): ans =n1*n2;
										System.out.println("the mul of "+n1+" and " +n2+ " is " +ans);
										break;
        		case ("div"):
        						if(n2!=0) {
        							ans =n1/n2;
        						}
        						else {
        							System.out.println("can't divide by zero");
        						}
        								System.out.println("the div of "+n1+" and " +n2+ " is " +ans);
				break;	
				default: System.out.println("invalid input.");
        		}
        }

}
