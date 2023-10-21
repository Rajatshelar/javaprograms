package com.edu.oper;

public class BooleanMain {
	public static void main(String[] args) {
	int i=100, j=20, k=40;
	boolean b= i>j;// true or false
	System.out.println("b="+b);
	//Logical &&,
	
	//boolean b1=(i>j && i>k);
	
	int large = (i>j && i>k && i>l)?i:(j>i && j>k && j>l)?j:(k>i && k>j && k>l)?k:l;
	
	System.out.println("The largest of "+i+" , "+j+" and "+k+" is "+large);
	}
}
