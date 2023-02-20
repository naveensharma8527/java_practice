package com.masai.pro4;

//Develop a multithreaded Java Application to start 3 threads by extending the Thread class.


class ThreadOne extends Thread{

	@Override
	public void run() {
		System.out.println("I am Thread 1 ");
	}
	
}
class ThreadTwo extends Thread{

	@Override
	public void run() {
		System.out.println("I am Thread 2 ");
	}
	
}
class ThreadThree extends Thread{

	@Override
	public void run() {
		System.out.println("I am Thread 3 ");
	}
	
}




public class Main {

	public static void main(String[] args) {
		ThreadOne t1 = new ThreadOne();
		ThreadTwo t2 = new ThreadTwo();
		ThreadThree t3 = new ThreadThree();
		
		t1.start();
		t2.start();
		t3.start();
		

	}

}
