//http://www.mkyong.com/java8/
package com.java.java8.others;

import java.util.*;
import java.util.stream.Collectors;

public class Misc {

	public static void main(String[] args) {
		//Streams filter() and collect()
		List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println);                //output : spring, node
        
        
        
        
        //Streams filter(), findAny() and orElse()
        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person result1 = persons.stream()                        // Convert to steam
                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null

        System.out.println(result1);
        
        
        
        
        //A List of Strings to Uppercase
        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        // Java 8
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]

	}

}





class Person {

    @Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

    
}