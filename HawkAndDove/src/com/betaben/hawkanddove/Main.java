package com.betaben.hawkanddove;

import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		System.out.println("Hawk or Dove?");
		String answer = scanner.next();
		System.out.println(answer);
		if(answer == "Hawk"){
			System.out.println("You answered hawk.");
		}
		if(answer == "Dove"){
			System.out.println("You answered dove.");
		} else {
			System.out.println("Wrong.");
		}
		scanner.close();
	}

}
