package com.masai.prob2;

import java.io.File;
import java.io.IOException;


//Write a program to create a new File “students.txt” inside the current
//directory, if the file is already there then print “File is already present”
//otherwise, Print “File created successfully”.

public class Main {

	public static void main(String[] args) throws IOException {
		File f = new File("students.txt");
		
		if(f.exists()) {
			System.out.println( "File is already present");
		}else {
			f.createNewFile();
			System.out.println("File created successfully");
		}
		

	}

}
