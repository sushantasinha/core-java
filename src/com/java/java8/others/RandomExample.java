package com.java.java8.others;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		
		System.out.println(new Random().nextInt(5));// [0...4] [min = 0, max = 4]
		System.out.println(new Random().nextInt(5 + 1)); // [0...5] [min = 0, max = 5]
		System.out.println(new Random().nextInt(5 + 1)  + 10); // [0...5]  + 10 = [10...15]
		System.out.println(new Random().nextInt((30 - 10) + 1) + 10); // Test [10...30]
		

	}

}
