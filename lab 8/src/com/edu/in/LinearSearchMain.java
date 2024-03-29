package com.edu.in;


import java.util.Scanner;

class LinearSearch{
	int a[], size, keyelement;
	int pos;
	
	void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size");
		size = sc.nextInt();
		
		a = new int[size];
		System.out.println("Enter "+a.length+" elements ");
		
		for(int i=0;i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println("Enter search element");
		keyelement = sc.nextInt(); //keyelement =1 
		
	}
void searchElement() {
		//3  2  1  9  8  5  1
		
				for(int i=0;i<a.length;i++) {
					if(a[i] == keyelement) { //3 == 1 (no)  2 == 1(no) 1==1
						pos=i+1; //pos=2
						break;
					}
				}
				if(pos>0) {
					System.out.println("Successful search , ");
					System.out.println(keyelement+" present at position "+pos);
				}else {
					System.out.println("Unsuccessful search");
					System.out.println(keyelement+" not presesnt");
				}
		}
}

public class LinearSearchMain {

	public static void main(String[] args) {
		LinearSearch lob = new LinearSearch();
		lob.inputData();
		lob.searchElement();
	}

}
