package com.masai.prob1;

//**Create a multithreaded application in which start 2 threads along with the main thread:**
//
//- Both threads will print their priority along with the thread name 10 times.
//- From the main method set the name of both the thread as Dhoni thread for thread 1 and Kohli thread for thread 2,
//- Set the priority for thread1 as 5 and thread2 as 10.
//
//**Note:** Both threads should run on a single object.

class PrintTh implements Runnable{

	@Override
	public void run() {
		
		for(int i =1;i<=10;i++) {
			System.out.println(Thread.currentThread().getPriority() +" : "+ Thread.currentThread().getName()  );
		}
		
	}
	
}



public class MultiTh {

	public static void main(String[] args) {
		
		PrintTh pt = new PrintTh();
		
		Thread t1 = new Thread(pt,"Dhoni");
		t1.setPriority(5);
		
		Thread t2 = new Thread(pt,"Kohli");
		t2.setPriority(5);
		
		t1.start();
		t2.start();
		

	}

}
