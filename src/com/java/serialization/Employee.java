package com.java.serialization;

import java.io.Serializable;

public class Employee implements Serializable{
	
	public Employee(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}

	//serialVersionUID is used to ensure the same class (that was used during serialization), is 
	//loaded during deserialization
	//This should be static final
	//static members can not be serialized except serialization
	private static final long serialVersionUID = 5920645758906742390L;
	
	private int empId;
	private String name;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
