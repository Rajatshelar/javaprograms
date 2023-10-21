package com.edu.oper;

public class UnaryMainApp {

	public static void main(String[] args) {
		int i =10, j=10,k;
		
	//	System.out.println("+i="+ ++i);
    //k=i++ + ++i;
		k=++i + ++i;
    System.out.println("k="+k);//22,23
    System.out.println("i="+i);//12,12
	}

}
