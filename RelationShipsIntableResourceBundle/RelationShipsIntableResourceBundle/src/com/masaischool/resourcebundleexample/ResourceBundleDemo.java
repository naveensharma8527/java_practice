package com.masaischool.resourcebundleexample;

import java.util.ResourceBundle;

public class ResourceBundleDemo {
	public static void main(String[] args) {
		//it will look for file demo.properties in src folder
		//ResourceBundle bundle = ResourceBundle.getBundle("demo");
		
		//it will look for file demo.properties in src/com/masaischool/resourcebundleexample folder
		ResourceBundle bundle = ResourceBundle.getBundle("com.masaischool.resourcebundleexample.demo");
		String name = bundle.getString("name");
		String percentage = bundle.getString("percentage");
		String location = bundle.getString("location");
		
		System.out.println(name + ", " + percentage + ", " + location);
	}
}
