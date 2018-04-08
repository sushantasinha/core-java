package com.java.lambda;

import java.util.Arrays;
import java.util.List;
import com.java.model.Person;

public class ForEachIterationSample {

	public static void main(String[] args) {
		
		List<Person> personList = Arrays.asList(
				new Person("F1", "ZL1", 10), 
				new Person("F2", "CL2", 20),
				new Person("cF3", "BL3", 30), 
				new Person("F4", "CL4", 40));

		personList.forEach(p -> System.out.println(p));//External Iterator
		System.out.println(".................................................");
		personList.forEach(System.out::println);//Internal Iterator
		
	}

}
