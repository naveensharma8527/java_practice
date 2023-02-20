package com.masai.prob1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Create a ThreadPool of 3 threads, submit the 6 tasks using Callable, and
//from each task check whether the supplied number is Odd or even, if the number
//is Odd return “Odd Number” and if the number is even then return “Even Number”.
//Note: Supply the number to the Callable task through the constructor of the
//Callable task class. 





public class CallableInt implements Callable<String> {
	
	int num;
	public CallableInt(int n ) {
		this.num = n;
	}
	
	
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		if(num%2 == 0) {
			return "Even Number  " + Thread.currentThread().getName() ;
		}else {
			return "Odd Number  "+ Thread.currentThread().getName();
		}
	}
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		CallableInt[] ar = {new CallableInt(1),new CallableInt(2),new CallableInt(3),new CallableInt(4),new CallableInt(5),new CallableInt(6) };
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		
		for(CallableInt ci : ar) {
			
			System.out.println(es.submit(ci).get());
			
		}
		
		
		
		

	}

	

}
