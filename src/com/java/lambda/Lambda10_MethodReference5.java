package com.java.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java.model.Person;

public class Lambda10_MethodReference5 {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(
				new Person("F1", "ZL1", 10), 
				new Person("F2", "CL2", 20),
				new Person("cF3", "BL3", 30), 
				new Person("F4", "CL4", 40));

		System.out.println("\n1. Printing entire list: Last Name Starts with C");
		printSelective(personList, p -> p.getLastName().toUpperCase().startsWith("C"), person -> System.out.println(person));
		
		System.out.println("\n2. Printing entire list: Last Name Starts with C (Another Way)");
		printSelective(personList, p -> p.getLastName().toUpperCase().startsWith("C"), System.out::println);
		
		//Note: p -> method(p) can replace with Method Reference
		
	}

	private static void printSelective(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : personList) {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		}
	}

}
