package com.masai.prob2;

class EvenNumbersThread extends Thread {
    public void run() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
        }
    }
}

class OddNumbersThread extends Thread {
    private EvenNumbersThread evenNumbersThread;

    public OddNumbersThread(EvenNumbersThread evenNumbersThread) {
        this.evenNumbersThread = evenNumbersThread;
    }

    public void run() {
        try {
            evenNumbersThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 19; i += 2) {
            System.out.println(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EvenNumbersThread evenNumbersThread = new EvenNumbersThread();
        OddNumbersThread oddNumbersThread = new OddNumbersThread(evenNumbersThread);

        evenNumbersThread.start();
        oddNumbersThread.start();

        try {
            evenNumbersThread.join();
            oddNumbersThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


