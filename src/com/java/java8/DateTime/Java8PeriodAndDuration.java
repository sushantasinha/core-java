package com.java.java8.DateTime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
//Read from http://www.baeldung.com/java-8-date-time-intro
import java.util.Set;

//Read from http://www.baeldung.com/java-8-date-time-intro
/*The Period class represents a quantity of time in terms of years, months and days and the Duration class represents a quantity of 
time in terms of seconds and nano seconds.*/

public class Java8PeriodAndDuration{
	
	public static void main(String args[]){
		
		//Working with Period
		LocalDate initialDate = LocalDate.parse("2007-05-10");
		LocalDate finalDate = initialDate.plus(Period.ofDays(5));
		System.out.println("finalDate: " + finalDate);
		
		//The Period class has various getter methods such as getYears, getMonths and getDays to get values from a Period object. 
		int five1 = Period.between(finalDate, initialDate).getDays();
		int five2 = Period.between(initialDate, finalDate).getDays(); //Note there is method for Days, Months, Year. For Time need to use Duration
		System.out.println("five1: " + five1 + " five2: " + five2 );
		
		int five3 = (int) ChronoUnit.DAYS.between(finalDate , initialDate);
		System.out.println("five3: " + five3);
		
		
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDateTime finalDateTime = localDateTime.plus(Period.ofDays(10));
		int tenDaysAddConvertedintoHours = (int) ChronoUnit.HOURS.between(localDateTime, finalDateTime);
		System.out.println("tenDaysAddConvertedintoHours: " + tenDaysAddConvertedintoHours);
		
		//Working with Duration
		//Similar to Period, the Duration class is use to deal with Time. 
		LocalTime initialTime = LocalTime.of(6, 30, 0);
		LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
		int thirty = (int) Duration.between(initialTime, finalTime).getSeconds();
		System.out.println("thirty: " + thirty);
		int thirty2 = (int) ChronoUnit.SECONDS.between(initialTime, finalTime);
		System.out.println("thirty2: " + thirty2);
		
		
		
	}
}