package com.java.hashcodeAndEquals;

import java.util.HashMap;
import java.util.Map;

public class HashcodeAndEqualsSample1 {

	public static void main(String[] args) {
		Map<Emp, Integer> map = new HashMap<>();
		
		//E123 -> Same hashcode and equal on 1 entry would be there as we override hashcode and equals (if we implement both)
		Emp e1 = new Emp("E123");
		Emp e2 = new Emp("E123");
		
		//Ea and FB has same hashcode but NOT equal, so will put in different bucket (if we implement both)
		Emp e3 = new Emp("Ea");
		Emp e4 = new Emp("FB");
		
		//Scenario1: hashcode() and equals() both implemented. 
		//e1 and e2 -> same hashcode and equals. so 1 obj will be inserted in a hash bucket
		//e3 and e4 -> same hashcode but different so 2 object will be inserted in a hash bucket
		//So, total 3 elements will be there over 2 hash bucket
		
		//Scenario2: hashcode() and equals() none implemented.
		//e1 and e2 -> hashcode not same so 2 entries will be inserted in 2 different hash bucket
		//e3 and e4 -> hashcode not same so 2 entries will be inserted in 2 different hash bucket
		//So, total 4 elements will be there over 4 hash bucket
		
		//Scenario3: hashcode() implemented but not equals().
		//e1 and e2 -> same hash code but not equals. So, 2 entries in same hash bucket.
		//e3 and e4 -> same hash code but not equals. So, 2 entries in same hash bucket.
		//So, total 2 elements distributed over 2 hash bucket
		
		//Scenario4: hashcode() not implemented but equals() implemented.
		//e1 and e2 -> Different hash code but same equals. So 2 entries in 2 different hash bucket.
		//e3 and e4 -> Different hash code and equals also false. So 2 entries in 2 different hash bucket.
		//So, total 4 elements will be there over 4 hash bucket
		
		map.put(e1, 1);
		map.put(e2, 2);
		map.put(e3, 1);
		map.put(e4, 2);
		
		System.out.println(map.size());
		System.out.println(e1.equals(e2));
		System.out.println(e3.equals(e4));
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e3.hashCode());
		System.out.println(e4.hashCode());
	}

}


class Emp{
	String empId;

	public Emp(String empId) {
		super();
		this.empId = empId;
	}

	public String getEmpId() {
		return empId;
	}

	@Override
	public int hashCode() {
		/*final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;*/
		return empId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}
	
	
}