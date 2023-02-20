package com.masai.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Product {
	
	
	int productId;
	String productName;
	int quantity ;
	int price;
	
	
	
	

	public Product(int productId, String productName, int quantity, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + "] "+"\n";
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
		
		products.add(new Product(1, "abc", 2, 50));
		products.add(new Product(2, "def", 1, 150));
		products.add(new Product(3, "gkl", 5, 650));
		products.add(new Product(4, "mno", 8, 350));
		products.add(new Product(5, "pqr", 7, 70));
		
		
		System.out.println(products);
		
		Collections.sort(products, (p1,p2)-> {
			if(p1.price > p2.price) {
				return 1;
			}
			return -1;
		});
		System.out.println(products);

	}

}
