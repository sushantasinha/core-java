package com.java.java8.DateTime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;

//Read from http://www.baeldung.com/java-8-date-time-intro
public class Java8LocalDateTime{
	
	public static void main(String args[]){
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("localDateTime: " + localDateTime);
		
		LocalDateTime localDateTimeOf = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
		System.out.println("localDateTimeOf: " + localDateTimeOf);
		LocalDateTime localDateTimeParse = LocalDateTime.parse("2015-02-20T06:30:00");
		System.out.println("localDateTimeParse: " + localDateTimeParse);
		
		System.out.println("plusDays: " + localDateTime.plusDays(1));
		System.out.println("plusHours: " + localDateTime.plusHours(2));
		System.out.println("getMonth: " + localDateTime.getMonth());
		
		//The LocalDateTime can be constructed from epoch seconds as below. 
		LocalDateTime localDateTimeFromEpochSecond = LocalDateTime.ofEpochSecond(1465817690, 0, ZoneOffset.UTC);
		System.out.println("localDateTimeFromEpochSecond: "  + localDateTimeFromEpochSecond);
		
	}
}