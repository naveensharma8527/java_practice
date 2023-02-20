package com.masai.prob3;

//Create a multithreaded application in which 2 different threads run on a single object
//of a class which will print both thread names 10 times.



public class MultiTh implements Runnable{
	
	@Override
	public void run() {
		
		for(int i=0;i<9;i++) {
			System.out.println(Thread.currentThread().getName());
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		MultiTh mt = new MultiTh();
		Thread t1 = new Thread(mt,"Naveen");
		
		
		Thread t2 = new Thread(mt,"Kaushal");
		
		t1.start();
		t2.start();
		
		
		
		
	}

	
	
}
