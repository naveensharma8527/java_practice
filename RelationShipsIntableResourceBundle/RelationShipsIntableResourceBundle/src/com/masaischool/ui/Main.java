package com.masaischool.ui;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CategeryUI categoryUI = new CategeryUI(sc);
		
		int choice;
		do {
			System.out.println("1. Add new Category");
			System.out.println("2. View All Categories");
			System.out.println("3. Update a category");
			System.out.println("4. Delete a category");
			System.out.println("5. Search categories by Name");
			System.out.println("6. Search categories by Id");
			System.out.println("0. for Exit");
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					categoryUI.addCategory();
					break;
				case 2:
					
					break;
				case 3:
					
					break;
			}
		}while(choice != 0);
		sc.close();
	}
}
