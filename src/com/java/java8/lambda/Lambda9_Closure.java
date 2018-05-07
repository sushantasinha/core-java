package com.java.java8.lambda;

import java.util.function.Consumer;

public class Lambda9_Closure {

	public static void main(String[] args) {
		int a = 20;
		//Before Java 8 if we tried to use it in anonymous function, b must be set a final. 
		//But in java 8 we don't need to set it as final but java compiler will keep an eye on it, if we change the value if it 
		//inside anonymous function, this will complain.
		//The b is closure. As we are not passing b as argument to Lambda, this will be considered as frozen as 20 to anywhere. 
		//Because we can observe, we are using b within doProcess where there is NO b (Line number 20)
		int b = 10; 
		//b = 2;
		doProcess(a, c -> System.out.println(a + b));
	}
	

	private static void doProcess(int a, Consumer<Integer> c){
		c.accept(a);
	}
}
