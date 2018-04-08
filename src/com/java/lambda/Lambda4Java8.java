package com.java.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.java.model.Person;

public class Lambda4Java8 {

	public static void main(String[] args) {
		
		List<Person> personList = Arrays.asList(
				new Person ("F1", "ZL1", 10),
				new Person ("F2", "CL2", 20),
				new Person ("cF3", "BL3", 30),
				new Person ("F4", "CL4", 40)
		);
		
		
		//Lambda Way
		//Comparator<Person> comparator = (Person person1, Person person2) -> person1.getLastName().compareTo(person2.getLastName());
		//Collections.sort(personList, comparator); 
		
		//Shorter way
		Collections.sort(personList, (person1, person2) -> person1.getLastName().compareTo(person2.getLastName())); 
		
		
		System.out.println("Printing entire list");
		printSelective(personList, p -> true);
		
		System.out.println("\nPrinting entire list: Last Name Starts with C");
		printSelective(personList, p -> p.getLastName().toUpperCase().startsWith("C") );
		
		System.out.println("\nPrinting entire list: First Name Starts with C");
		printSelective(personList, p -> p.getFirstName().toUpperCase().startsWith("C") );
		
		
		//Another work
		//personList.forEach(person1 -> System.out.println(person1));
		
		//personList.forEach(person2 -> System.out::println);
		
	}
	
	

	private static void printSelective(List<Person> personList, ConditionInterfaceAnother c) {
		for(Person person: personList){
			if(c.test(person)){
				System.out.println(person);
			}
		}
	}

}


interface ConditionInterfaceAnother{
	boolean test(Person p);
}