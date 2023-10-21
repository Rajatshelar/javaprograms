
package com.edu.switchs;
import java.util.Scanner;

public class VowelCheckSwitchh {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter character.");
		char ch =sc.next().toUpperCase().charAt(0);
		
		switch(ch){
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
		System.out.println("vowel.");
		break;
		
		default	:
				System.out.println("consonent");
				break;
		}

	}

	private static void charAt(int i) {
		// TODO Auto-generated method stub
		
	}

}
