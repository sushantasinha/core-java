package com.java.java8.lambda;

public class Lambda2 {

	public static void main(String[] args) {
		Thread myThread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("My Thread 1 ...");
				
			}
		});
		
		myThread1.start();
		
		Thread myThread2 = new Thread(() -> System.out.println("My Thread 2 ..."));
		myThread2.start();

	}

}
