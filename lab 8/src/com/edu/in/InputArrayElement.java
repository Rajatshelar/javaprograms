package com.edu.in;

import java.util.Scanner;

public class InputArrayElement {


		public static void main(String[] args) {
			float a[];
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter size of an array");
			
			int size = sc.nextInt();
			
			a=new float[size];
			
			System.out.println("Enter "+size+" elements");
			
			for(int i=0; i<size; i++) {
			   a[i]	= sc.nextFloat();
			}
			
			System.out.println("Array elements are ");
//			for(int i=0; i<size; i++) {
//				   System.out.print(a[i]+" ");
//			}
			
			//for-each enhanced for loop
			
			for(float i:a) {
				System.out.print(i+ " ");
			}
			
			
		}

	}
	


