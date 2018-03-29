package com.java.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.java.model.Person;

public class Lambda4Java7 {

	public static void main(String[] args) {
		
		List<Person> personList = Arrays.asList(
				new Person ("F1", "ZL1", 10),
				new Person ("F2", "CL2", 20),
				new Person ("CF3", "BL3", 30),
				new Person ("F4", "CL4", 40)
		);
		
		//Sort the collection
		Collections.sort(personList, new Comparator<Person>(){

			@Override
			public int compare(Person person1, Person person2) {
				return person1.getLastName().compareTo(person2.getLastName());
			}
			
		});
		
		System.out.println("\nPrinting entire list");
		printSelective(personList, p -> true);
		
		System.out.println("\nPrinting entire list: Last Name Starts with C");
		printSelective(personList, new Condition(){

			@Override
			public boolean test(Person p) {
				return p.getLastName().toUpperCase().startsWith("C");
			}
			
		});
		
		System.out.println("\nPrinting entire list: First Name Starts with C");
		printSelective(personList, new Condition(){

			@Override
			public boolean test(Person p) {
				return p.getFirstName().toUpperCase().startsWith("C");
			}
			
		});
		

	}
	
	private static void printSelective(List<Person> personList, Condition c) {
		for(Person person: personList){
			if(c.test(person)){
				System.out.println(person);
			}
		}
	}
	
	
}


interface Condition{
	boolean test(Person p);
}