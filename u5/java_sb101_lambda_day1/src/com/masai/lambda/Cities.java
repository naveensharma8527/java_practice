package com.masai.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> cities = new ArrayList<>();
		
		cities.add("delhi");
		cities.add("ghaziabad");
		cities.add("lucknow");
		cities.add("noida");
		cities.add("mirzapur");
		
		
		Collections.sort(cities,(c1,c2) -> {
			return c1.compareTo(c2);
		});
		
		System.out.println(cities);
//		
//		Collections.sort(cities,(c1,c2) -> {
//			return c2.compareTo(c1);
//		});
//		
//		System.out.println(cities);
		
		
	}
	
	

}
