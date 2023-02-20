package com.masaischool.ui;

import com.masaischool.dao.CategoryDAO;
import com.masaischool.dao.CategoryDAOImpl;
import com.masaischool.dto.Category;
import com.masaischool.dto.CategoryImpl;
import com.masaischool.exception.SomeThingWrongException;
import java.util.Scanner;

public class CategeryUI {
	CategoryDAO categoryDAO;
	Scanner scanner;
	
	CategeryUI(Scanner scanner){
		categoryDAO = new CategoryDAOImpl();
		this.scanner = scanner;
	}
	
	public void addCategory() {
		System.out.print("Enter categroy id ");
		int cat_id = scanner.nextInt();
		String cat_name = scanner.next();
		Category category = new CategoryImpl(cat_id, cat_name);
		
		System.out.print("Enter categroy name ");
		try {
			categoryDAO.addCategory(category);
			System.out.println("Category added successfully");
		}catch(SomeThingWrongException ex) {
			System.out.println(ex);
		}
	}
}
