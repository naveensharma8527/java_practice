package com.masai.prob1;

class SalmanThread extends Thread{
	
	public SalmanThread() {
		super("Salman");
	}

	@Override
	public void run() {
		int sum =0;
		for(int i=1;i <=10; i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
	
	
}

class HritikThread extends Thread{
	
	public HritikThread() {
		super("Hritik");
	}

	@Override
	public void run() {
		int mul =1;
		for(int i=1;i <=10; i++) {
			mul*=i;
		}
		System.out.println(mul);
	}
	
	
}



public class Main extends Thread{
	
//	public Main() {
//		super("Akshay");
//	}

	@Override
	public void run() {
		
		for(int i =1;i<=10;i++) {
			System.out.println(Thread.currentThread().getName());
		}
		
	}
	
	

	public static void main(String[] args) {
			
//		Thread.currentThread().setName("Salman");
		
		SalmanThread st = new SalmanThread();
		st.start();
		System.out.println(st.getName());
		
		HritikThread ht = new HritikThread();
		System.out.println(ht.getName());
		ht.start();
		
		Main mt = new Main();
		mt.setName("Akshay");
		mt.start();
		
		
		
		
		

	}

}
