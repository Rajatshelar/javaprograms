package com.edu.in;
import java.util.Scanner;
public class LargestElement {

	public static void main(String[] args) {
		int a[];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of an array");
		
		int size = sc.nextInt();
		
		a=new int[size];
			
		
		System.out.println("Enter "+size+" elements");
		
		for(int i=0; i<size; i++) {
		   a[i]	= sc.nextInt();
		}
		
		//Largest of an array elements
		// 4 9 1 2 8
		//assume first number is max
		
		int max = a[0];
		
		for(int i=1; i<size; i++) {
			if(a[i] > max) {  //9>4(yes)   1>9(no)  2>9(no)  8>9(no)
				max = a[i];  //max = 9
			}
		}
		
		System.out.println("Maximum of array elements "+max);
		
		//Minimum element
		 int min=a[0];
		 
		 for(int i=1; i<size; i++) {
				if(a[i] < min) {  //9>4(yes)   1>9(no)  2>9(no)  8>9(no)
					min = a[i];  //max = 9
				}
			}
			
			System.out.println("smallest element of array "+min);
			
	}



	}


