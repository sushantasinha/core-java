package com.java.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java.model.Person;

public class Lambda6_Consumer {

	public static void main(String[] args) {
		
		List<Person> personList = Arrays.asList(
				new Person ("F1", "ZL1", 10),
				new Person ("F2", "CL2", 20),
				new Person ("CF3", "BL3", 30),
				new Person ("F4", "CL4", 40)
		);
		
		//Sort the collection
		Collections.sort(personList, (Person person1, Person person2) -> person1.getLastName().compareTo(person2.getLastName()));
		
		System.out.println("\nPrinting entire list");
		printSelective(personList, p  -> true, p -> System.out.println(p));
		
		System.out.println("\nPrinting entire list: Last Name Starts with C");
		printSelective(personList, p -> p.getLastName().toUpperCase().startsWith("C"), p -> System.out.println(p.getFirstName()));
				
		System.out.println("\nPrinting entire list: First Name Starts with C");
		printSelective(personList, p -> p.getFirstName().toUpperCase().startsWith("C"), p -> System.out.println(p.getFirstName()));
				
	}

	private static void printAll(List<Person> personList) {
		for(Person person: personList){
			System.out.println(person);
		}
	}
	
	
	private static void printSelective(List<Person> personList, Predicate<Person> c, Consumer<Person> consumer) {
		for(Person person: personList){
			if(c.test(person)){
				consumer.accept(person);
			}
		}
	}
	
	
}
