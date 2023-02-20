package com.masai.prob4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//## Problem 4 :
//
//Create a List of Integers and Map each integer to its square inside another List. 
//
//**Note:** Print both the List using Lambda expressions.

public class Main {

	public static void main(String[] args) {
		List <Integer> list = new ArrayList<>();
		
		list.add(5);
		list.add(10);
		list.add(2);
		list.add(7);
		list.add(11);
		
		
		List <Integer> Squarelist = new ArrayList<>();
		
		Squarelist = list.stream().map(i -> i*i).collect(Collectors.toList());
		
		System.out.println(list);
		System.out.println(Squarelist);
		
		

	}

}
