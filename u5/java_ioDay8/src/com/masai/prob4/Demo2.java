package com.masai.prob4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Demo2 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("studentdata.txt"));
		
		while(true) {
			Student st = (Student) ois.readObject();
			if(st == null) {
				break;
			}
			System.out.println(st +"hello");
		}
		ois.close();
		
	}
}
