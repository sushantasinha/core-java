package com.java.lambda;

public class Lambda10_MethodReference3 {

	public static void main(String[] args) {
		doProcess((s) -> print(s));
		doProcess(Lambda10_MethodReference3::print);//  (s) -> print(s) === Lambda10_MethodReference3::print
	}

	private static void doProcess(SampleFunctionalInterfaceAnother s) {
		s.display("Sushanta");
	}

	private static void print(String name) {
		System.out.println("Hi " + name);
	}

}

@FunctionalInterface
interface SampleFunctionalInterfaceAnother {
	void display(String s);
}
