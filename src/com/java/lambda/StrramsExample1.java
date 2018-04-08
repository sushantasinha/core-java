package com.java.lambda;

import java.util.Arrays;import java.util.Comparator;
import java.util.List;

import com.java.model.Person;

/**
 * Note: We can think about a car service centre, where 3 mechanics (one person is fixing glass, one is tyres and one is cleaning ), working in parallel to fix the issue. 
 * There is belt which moving and 3 mechanics are fixed in same location and as the belt moving and they are working.
 * Note: IN java 8 every collection comes with stream()
 *
 */
public class StrramsExample1 {
	
	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(
				new Person("F1", "ZL1", 10), 
				new Person("F2", "CL2", 20),
				new Person("cF3", "BL3", 30), 
				new Person("F4", "CL4", 40));
		
		personList.stream()
		.filter(p -> p.getLastName().toUpperCase().startsWith("C"))
		.forEach(System.out::println);
		System.out.println(".....................");
		
		//parallel stream ->result is not going to change from above but it could potentially try to run in parallel
		personList.parallelStream()
		.filter(p -> p.getLastName().toUpperCase().startsWith("C"))
		.forEach(System.out::println);		
		System.out.println(".....................");
		
		long c = personList.stream()
				.filter(p -> p.getLastName().toUpperCase().startsWith("C"))
				.count();
		System.out.println(c);
		
		
		System.out.println("Printing sorted List");
		personList.stream()
		.sorted((Person person1, Person person2) -> person1.getLastName().compareTo(person2.getLastName()))
		.forEach(System.out::println);
	}

}

