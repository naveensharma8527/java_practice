package com.masai.prob5;

//Develop a multithreaded Java Application to start 2 threads by implementing a Runnable interface.

class ImpRun implements Runnable{

	@Override
	public void run() {
		System.out.println("implementing a Runnable interface.");
		
	}
	
}


public class Main {

	public static void main(String[] args) {
		
		ImpRun ir = new ImpRun();
		
		Thread t1 = new Thread(ir);
		
		Thread t2 = new Thread(ir);
		t1.start();
		t2.start();
		

	}

}
