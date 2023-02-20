package com.masai.funInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.function.*;

@FunctionalInterface
interface PrintList {
abstract void display(List<String> city);
};
 


public class City {
	
	
	
	
	public static void main(String[] args) {
		List<String> cities = new ArrayList<>();
		cities.add("delhi");
		cities.add("mumbai");
		cities.add("chennai");
		cities.add("bengal");
		cities.add("gujrat");
		
		PrintList pl = cit -> {
			cit.forEach( c -> System.out.println(c) );
		};
		
		
		pl.display(cities);
		
	}
	
	
	
	
	
	
	
}
