package com.masai.prob2;

import java.util.ArrayList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		1. Create a List of 5 product objects.
//		2. From the product list filter the products whose quantity is more than 10 in a
//		separate List of Products.
//		3. Sort the Filtered List of Products by the price in ascending order.
//		4. Print all the products one by one from both Lists (original list and Filtered list)
//		Note: for filtering and printing and sorting make use of Stream or Lambda
//		expressions.
		
		
		
		List <Product> list = new ArrayList<>();
		
		list.add(new Product(1, "shop", 400, 20));
		list.add(new Product(2, "rice", 300, 10));
		list.add(new Product(3, "pulses", 650, 9));
		list.add(new Product(4, "maggie", 900, 15));
		list.add(new Product(5, "soyabean", 200, 8));
		
		
		System.out.println(list);
		
		System.out.println("******************************************");
		System.out.println("******************************************");
		
		list.stream().filter(p -> p.getQuantity() > 10).sorted((p1,p2)-> p1.getPrice() - p2.getPrice()).forEach(p -> System.out.println(p));
		

	}

}
