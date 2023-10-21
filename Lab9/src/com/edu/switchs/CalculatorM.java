
//Menu Based Calculator
package com.edu.switchs;

import java.util.Scanner;

public class CalculatorM {

	public static void main(String[] args) {
		int ans=0;
     Scanner scanner = new Scanner(System.in);
     
     System.out.println("Enter 2 numbers");
     int n1=scanner.nextInt();
     int n2=scanner.nextInt();
     
     System.out.println("Enter your choice");
     System.out.println("Enter add to perform addition");
     System.out.println("Enter sub to perform subtraction");
     System.out.println("Enter mul to perform Multiplication");
     System.out.println("Enter div to perform Division");
String option = scanner.next();
     
     switch(option) {
     case "add": ans = n1+n2;
       			System.out.println("The sum of "+n1+" and "+n2+" is "+ans);
                 break;
     case "sub": ans = n1-n2;
     				System.out.println("The Difference of "+n1+" and "+n2+" is "+ans);
     				break;
     case "mul": ans = n1*n2;
     			System.out.println("The Product of "+n1+" and "+n2+" is "+ans);
     			break;
     case "div": 
  	          if(n2!=0) {
  	        	  ans = n1/n2;
  	        		System.out.println("The Quotient of "+n1+" and "+n2+" is "+ans);
  	          }
  	        else {
  	       	  System.out.println("Divide by zero error");
  	        }
		
			break;
		default : System.out.println("Invalid input");
     
                 
     }
     System.out.println("After switch");
     
     }
	
}