package com.java.hashcodeAndEquals;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author sushanta
 *
 */

//See the performance with and without hashcode and equals implementation.
//Without hashcode and equals: 1500 ms
//With hashcode and equals: 170 ms
public class HashCodeSample2 {
	public static void main(String[] args) {
		
		Map<Key, Integer> map = new HashMap<>();
		
		LocalTime starts = LocalTime.now();
		System.out.println(starts);
		
		for(int i =0; i<1000000; i++){
			int ran = (int) Math.random();
			map.put(new Key(ran), ran);
		}
		
		for(Key key: map.keySet()){
			map.get(key);
		}
		for(Key key: map.keySet()){
			map.get(key);
		}
		for(Key key: map.keySet()){
			map.get(key);
		}
		for(Key key: map.keySet()){
			map.get(key);
		}
		
		LocalTime ends = LocalTime.now();
		int elasped = (int) ChronoUnit.MILLIS.between(starts, ends);
		
		System.out.println(elasped + " ms");
			
			
			
				
		
		
	}
}



class Key{
	int keyId;

	public Key(int keyId) {
		super();
		this.keyId = keyId;
	}

	public int getKeyId() {
		return keyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + keyId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (keyId != other.keyId)
			return false;
		return true;
	}
	
	
}
