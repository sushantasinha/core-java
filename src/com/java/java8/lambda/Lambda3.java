package com.java.java8.lambda;

//Note: TO use Lambda,an interface can have as many as methods but this will only have one abstract method. This is called Functional interface
//Before Java 8, an interface can only have abstract methods but in java 8, there can be method implementations as well in interface


public class Lambda3 {

	public static void main(String[] args) {
		
		FuncInterface f = (m) -> System.out.println("Message ..." + m);
		f.print("Hi ... ");
	}
	
	@FunctionalInterface 
	public interface FuncInterface{
		
		void print(String message);
		
		default int add(int a, int b){
			return a+b;
		}
	}

}
