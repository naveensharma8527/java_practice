package com.masai.prob5;

class A{

	synchronized public void sayHello(String name){

		System.out.print("Welcome :");

		try{

			Thread.sleep(2000);

		}catch(Exception e){

			e.printStackTrace();

		}

		System.out.print(name);
		System.out.println();

}

}


class ImpRun implements Runnable{
	
	String name;
	A a;
	
	public ImpRun(String name,A a) {
		this.name = name;
		this.a = a;
	}
	
		
	@Override
	public void run() {
		
		a.sayHello(name);
		
		
	}
	
}






public class Main {

	public static void main(String[] args) {
		A a = new A();
		
		ImpRun ir1 = new ImpRun("Naveen",a);
		ImpRun ir2 = new ImpRun("Kaushal",a);
		ImpRun ir3 = new ImpRun("Abhishek",a);
		
		Thread t1 = new Thread(ir1);
		Thread t2 = new Thread(ir2);
		Thread t3 = new Thread(ir3);
		
		t1.start();
		t2.start();
		t3.start();
		
		

	}

}
