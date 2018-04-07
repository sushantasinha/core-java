package com.java.lambda;

public class Lambda10_MethodReference4 {

	public static void main(String[] args) {
		doProcess((firstNAme, lastName) -> print(firstNAme, lastName));
		doProcess(Lambda10_MethodReference4::print);//  (s) -> print(s) === Lambda10_MethodReference3::print
	}

	private static void doProcess(SampleFunctionalInterface4 s) {
		s.display("Sushanta", "Sinha");
		s.display("All", "Java Developer");
	}

	private static void print(String fstName, String lstName) {
		System.out.println("Hi " + fstName  + " " + lstName);
	}

}

@FunctionalInterface
interface SampleFunctionalInterface4 {
	void display(String fName, String lName);
}
