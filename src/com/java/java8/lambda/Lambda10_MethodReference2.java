package com.java.java8.lambda;

public class Lambda10_MethodReference2 {

	public static void main(String[] args) {
		doProcess(() -> print());
		doProcess(Lambda10_MethodReference2::print);//  () -> print() === Lambda10_MethodReference2::print
		//Note: () -> method() can replace with Method Reference
	}

	private static void doProcess(SampleFunctionalInterface s) {
		s.get();
	}

	private static void print() {
		System.out.println("Hi............");
	}

}

@FunctionalInterface
interface SampleFunctionalInterface {
	void get();
}
