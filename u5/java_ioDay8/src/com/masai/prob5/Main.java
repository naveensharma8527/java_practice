package com.masai.prob5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Write a program to create the file abc.txt and add 10 mobile numbers to the file. 
//
//- find those numbers from the file which is starting with 9,8,7, 6 and
//
//       they must be 10 in the length.
//
//- Add these filtered numbers to another file.
//
//**Note:** Print both files.





public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> numbers = new ArrayList<>();
		numbers.add("1234567899");
		numbers.add("5234567899");
		numbers.add("8234567899");
		numbers.add("7234567899");
		numbers.add("9234567899");
		
//		since abc.txt is already exist because of question 1 i will use pqr.txt
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("pqr.txt"));
		
		for(String num : numbers) {
			bw.write(num +"\n");
		}
		bw.close();
		
		ArrayList<String> Filterednumbers = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader("pqr.txt"));
		
		while(true) {
			String num = br.readLine();
			if(num == null) {
				break;
			}
			Filterednumbers.add(num);
		}
		System.out.println(Filterednumbers);
		
		br.close();
		
		BufferedWriter bwFil = new BufferedWriter(new FileWriter("filterNum.txt"));
		

		for(String num : numbers) {
			
			if(num.startsWith("9")||num.startsWith("8")||num.startsWith("7")||num.startsWith("6") && num.length() == 10 ) {
				bwFil.write(num +"\n");
			}
		}
		
		bwFil.close();
		
		
		
		
		
		
	}

}
