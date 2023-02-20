package com.masai.prob3;

//**Create a multithreaded application in which start 2 threads:**
//
//1. Salman thread:
//2. Hritik thread:
//- Salman Thread should print all the even numbers starting from 0 to 20
//- Hritik Thread should print all the odd numbers starting from 0 to 20.
//- Both threads should print the number by taking a 1-second pause.
//
//**Note:** Salman Thread should wait until the complete execution of the Hritik Thread. (make use of the Join method)

class Salman extends Thread{
	Hritik ht;
	public Salman(Hritik ht) {
		super("Salman");
		this.ht = ht;
	}
	
	public void run() {
		
		try {
			ht.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
        }
    }
	
}
class Hritik extends Thread{
	
	public Hritik() {
		super("Hritik");
	}
	
	public void run() {

		for (int i = 1; i <= 19; i += 2) {
            System.out.println(i);
        }
    }
	
}


public class Main {
	
	public static void main(String[] args) {
		Hritik ht = new Hritik();
		
		Salman st = new Salman(ht);
		
		ht.start();
		st.start();
		
		try {
			ht.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
