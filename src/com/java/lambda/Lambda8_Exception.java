package com.java.lambda;

import java.util.function.BiConsumer;

public class Lambda8_Exception {

	public static void main(String[] args) {
		int [] numerators = {4,5,6,7,8,9,10,11,12};
		int denominator = 0;	// change the value to 2 and see the result		
		divide(numerators, denominator, wrapperLambda((n, d) -> System.out.println(n/d)));
	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> wb) {
		System.out.println("Wrapping ...");
		return (n, d) -> {
			try {
				System.out.println("Inner Wrapping ...");
				wb.accept(n, d);
			} catch (ArithmeticException e) {
				System.out.println("In Exception ...");
			}
		};
	}

	private static void divide(int[] numerators, int denominator, BiConsumer<Integer, Integer> b) {
		for(int i: numerators){
			//System.out.println(i/denominator);
			b.accept(i, denominator);
		}
		
	}

}
