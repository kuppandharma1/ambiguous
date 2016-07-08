package com.manga42.ambiguous.core;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String []args){
		System.out.println("Welcome to Ambiguous Service");
		while(true){
			System.out.print("Enter Search String: ");
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("I guess: " + new MainGuessor().guess(scanner.nextLine()));
			
		}
	}
}
