package com.edu.switchs;
import java.util.Scanner;
public class Area {

	public static void main(String[] args) {
		double area;
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your choice");
	     System.out.println("Enter tri if you want to find area of triangle");
	     System.out.println("Enter rect if you want to find area of rectangle");
	     System.out.println("Enter sq if you want to find area of square");
	     System.out.println("Enter cir if you want to find area of circle");
	     
	     String option = sc.next();
	     switch(option) {
	     case "tri" :
	    	 System.out.println("enter base.");
	    	 float base =sc.nextFloat();
	    	 System.out.println("enter base height.");
	    	 float height =sc.nextFloat();
	    	 area=1/2*base*height;
	    	 System.out.println("The area of trianle is: "+area);
	    	 break;
	     case "rect" :
	    	 System.out.println("enter length .");
	    	 float length =sc.nextFloat();
	    	 System.out.println("enter width .");
	    	 float width =sc.nextFloat();
	    	 area=length*width;
	    	 System.out.println("The area of rectangle is: "+area);
	    	 break;
	     case "sq" :
	    	 System.out.println("enter side of square.");
	    	 float side =sc.nextFloat();
	    	 area=side*side;
	    	 System.out.println("The area of square is: "+area);
	    	 break;
	     case "cir" :
	    	 System.out.println("enter radius.");
	    	 float radius =sc.nextFloat();
	    	 area=3.24*radius*radius;
	    	 System.out.println("The area of trianle is: "+area);
	    	 break;
	     default : System.out.println("Invalid input");
	    	 
	     }
	     
		

	}

}
