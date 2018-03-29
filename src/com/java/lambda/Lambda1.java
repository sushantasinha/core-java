package com.java.lambda;

public class Lambda1 {

	public static void main(String[] args) {
		SampleInterface sampleInterface = (int a, int b) -> a+b;	//Note: We dont mention return a+b, evern not allowed
		//but if it is multiple line statement, then return is needed if return type is not void
		System.out.println(sampleInterface.add(2,3));
		
		SampleInterface sampleInterface1 = (a, b) -> a+b;
		System.out.println("sampleInterface1: " + sampleInterface1.add(2,3));
		
		//when passing as argument, left hand side type is not required
		//because, compiler will identify that
		new SampleClass().sampleMethod((int a, int b) -> a+b ); 
		
		//if there is only one input arg, dont need the parenthesis 
		AnotherInterface anotherInterface = (s) -> System.out.println("Message ............." + s );
		AnotherInterface anotherInterface1 = s -> System.out.println("Message ............." + s );
		
		anotherInterface.msgMthd(" anotherInterface print ");
		anotherInterface1.msgMthd(" anotherInterface1 print ");
		
		
	}

}


@FunctionalInterface
interface SampleInterface{
	int add(int a, int b); 
}

@FunctionalInterface
interface AnotherInterface{
	void msgMthd(String s); 
}


class SampleClass{
	void sampleMethod(SampleInterface sampleInterface){
		System.out.println("Hiiiiii................: " + sampleInterface.add(1, 2));
	}
}