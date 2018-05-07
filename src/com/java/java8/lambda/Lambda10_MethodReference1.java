package com.java.java8.lambda;

public class Lambda10_MethodReference1 {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> doProcess());
		Thread t2 = new Thread(Lambda10_MethodReference1::doProcess);// () -> doProcess() === Lambda10_MethodReference1::doProcess
		
		t1.start();
		t2.start();

	}

	private static void doProcess() {
		System.out.println("In doProcess");
	}

}
