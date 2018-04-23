package com.java.java8.DateTime;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

//Read from http://www.baeldung.com/java-8-date-time-intro

//The LocalDateTime is used to represent a combination of date and time.
public class Java8LocalTime{
	
	public static void main(String args[]){
		
		LocalTime now = LocalTime.now();
		System.out.println("Now: " + now);
		
		LocalTime sixThirty1 = LocalTime.parse("06:30");//create a LocalTime representing 06:30 AM by parsing a string representation:0
		System.out.println("sixThirty1: " + sixThirty1);
		
		LocalTime sixThirty2 = LocalTime.of(6, 30);//The Factory method “of” can be used to create a LocalTime.
		System.out.println("sixThirty: " + sixThirty2);
		
		LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);//creates a LocalTime by parsing a string and adds an hour to it by using the “plus” API.
		System.out.println("sevenThirty: " + sevenThirty);
		
		int hour = LocalTime.parse("06:30").getHour();
		int min =  LocalTime.parse("06:30").getMinute();
		int sec =  LocalTime.parse("06:30").getSecond();
		System.out.println(hour + ":" + min + ":" + sec);
		
		boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
		System.out.println("isbefore: " + isbefore);
		
		LocalTime maxTime = LocalTime.MAX;
		LocalTime minTime = LocalTime.MIN;
		LocalTime midNightTime = LocalTime.MIDNIGHT;
		System.out.println(maxTime + "   -   " + minTime + "   -   " + midNightTime);
		
	}
}