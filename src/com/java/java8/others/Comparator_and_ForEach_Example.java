package com.java.java8.others;

import java.util.ArrayList;
import java.util.List;

public class Comparator_and_ForEach_Example {

	public static void main(String[] args) {
		List<Emp> list = new ArrayList<>();
		list.add(new Emp(1, "Name1" , 20));
		list.add(new Emp(1, "Name2" , 10));
		list.add(new Emp(1, "Name3" , 30));
		
		System.out.println("Before");
		list.forEach((emp)->System.out.println(emp));
		
		//lambda to sort
		list.sort((Emp o1, Emp o2)->o1.getAge()-o2.getAge());
		
		System.out.println("After");
		list.forEach((emp)->System.out.println(emp));
		
	}

}






class Emp{
	
	private int id;
	private String name;
	private int age;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Emp(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
