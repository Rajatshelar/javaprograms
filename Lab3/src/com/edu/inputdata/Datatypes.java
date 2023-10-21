//Program to input different data type values and display
package com.edu.inputdata;

import java.util.Scanner;

 public class Datatypes {
   public static void main(String[] args) {
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	String word;
	String line;
Scanner scanner = new Scanner(System.in);
   System.out.println("Enter full name");
   line = scanner.nextLine();
   
   System.out.println("Enter your First Name");
   word  = scanner.next();
   
   System.out.println("enter byte value");
   b=scanner.nextByte();
   
   System.out.println("Enter short int");
   s= scanner.nextShort();
   
   System.out.println("Enter integer value");
   i= scanner.nextInt();
   
   
   System.out.println("Enter long value");
   l= scanner.nextLong();
   
   
   System.out.println("Enter float value ");
   f = scanner.nextFloat();
   
   System.out.println("Enter double value ");
   d = scanner.nextDouble();
//output
   System.out.println("Your Full Name="+line);
   System.out.println("Your first Name ="+word);
   System.out.println("byte value b="+b);
   System.out.println("short value s="+s);
   System.out.println("int value i="+i);
   System.out.println("Long value l="+l);
   System.out.println("Float value f ="+f);
   System.out.println("Double value d="+d);
   
   
   scanner.close();
   
  }
}