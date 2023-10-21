package com.edu.oper;

import java.util.Scanner;

public class CheckDivisible {

	public static void main(String[] args) {

     int a;
		
		Scanner scanner = new Scanner(System.in);
		   System.out.println("Enter the number.");
		   a= scanner.nextInt();
		   
		   if((a%3==0)&&(a%5)==0)
		   {
			   System.out.println("The number is divisible by 3 and 5.");
		   }
		   else if(a%3==0)
		   {
			   System.out.println("The number is divisible by only 3.");
		   }
		   else if(a%5==0)
		   {
			   System.out.println("The number is divisible by only 5.");
		   }
		   else 
		   {
			   System.out.println("The number is not divisible by  5 or 3.");
		   }

	}

}
