//electricity bill payment

package com.edu.oper;

import java.util.Scanner;

public class ElectricityBill {
	public static void main(String[] args) {
		int u;
		double r; 
		double a;
		double b;
		double c;
		
		Scanner scanner = new Scanner(System.in);
		   System.out.println("Enter The Units.");
		   u= scanner.nextInt();
	
	
	
	if (u>300)
	{	a=(u-300)*4.00;
	    b=200*3.00;
	    c=100*2.00;
	    r=a+b+c;
	   }
	else if (u>100)
	{	
		a=(u-100)*3.00;
        b=100*2.00;
        r=a+b;
	}
	else 
	{	
		a=u*2.00;
        r=a;
	}
	
		
	
	
	
		  System.out.println("Your electricity bill is Rs."+r);
	}


		
		
		
		

	

}
