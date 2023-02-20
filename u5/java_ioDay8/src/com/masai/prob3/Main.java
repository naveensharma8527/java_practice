package com.masai.prob3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

//Write a program to create a new file abc.txt and write the Employee name
//and address this file by taking input from the user.




public class Main {

	public static void main(String[] args) throws IOException {
		
		Writer writer = new FileWriter("abc.txt");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Name");
		String name = sc.nextLine();
		
		System.out.println("Enter Employee Address");
		String address = sc.nextLine();
		sc.close();
		
		writer.write(name);
		writer.write(address);
		
		
		
		writer.close();
		
		

	}

}
