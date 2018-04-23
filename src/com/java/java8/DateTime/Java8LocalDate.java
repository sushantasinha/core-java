package com.java.java8.DateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
//Read from http://www.baeldung.com/java-8-date-time-intro
/*Thread Safety – The Date and Calendar classes are not thread safe, leaving developers to deal with the headache of hard to debug concurrency 
issues and to write additional code to handle thread safety. On the contrary the new Date and Time APIs introduced in Java 8 are immutable 
and thread safe, thus taking that concurrency headache away from developers.
APIs Design and Ease of Understanding – The Date and Calendar APIs are poorly designed with inadequate methods to perform day-to-day operations.
ZonedDate and Time – Developers had to write additional logic to handle timezone logic with the old APIs, whereas with the new APIs, handling 
of timezone can be done with Local and ZonedDate/Time APIs. 
*/

//The LocalDate represents a date in ISO format (yyyy-MM-dd) without time.
public class Java8LocalDate{
	//date format ??????
	public static void main(String args[]){
		
		LocalDate currentDate = LocalDate.now();//An instance of current date 
		System.out.println("Current Date: " + currentDate);
		
		//The LocalDate representing a specific day, month and year can be obtained using the “of” method or by using the “parse” method.
		LocalDate anotherDate1 = LocalDate.of(2015, 02, 20);
		System.out.println("Another Date1: " + anotherDate1);
		
		LocalDate anotherDate2 = LocalDate.parse("2015-02-20");
		System.out.println("Another Date2: " + anotherDate2);
		
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println("Tomorrow: " + tomorrow);
		
		LocalDate yesterday = LocalDate.now().minusDays(1);
		System.out.println("Yesterday: " + yesterday);
		
		//This example obtains the current date and subtracts one month
		LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
		System.out.println("Previous Month Same Day: " + previousMonthSameDay);
		
		DayOfWeek dayOfWeek = LocalDate.parse("2016-06-12").getDayOfWeek();
		System.out.println("Day Of Week: " + dayOfWeek);
		 
		int dayOfMonth = LocalDate.parse("2016-06-12").getDayOfMonth();
		System.out.println("Day Of Month: " + dayOfMonth);
		
		boolean nonLeapYear = LocalDate.now().isLeapYear();
		boolean leapYear = LocalDate.parse("2016-06-12").isLeapYear();
		System.out.println("Is Leap Year: " + nonLeapYear);
		System.out.println("Is Leap Year: " + leapYear);
		
		boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
		System.out.println("notBefore: " + notBefore);
				 
		boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));
		System.out.println("isAfter: " + isAfter);
		
		LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
		System.out.println("beginningOfDay: " + beginningOfDay);
		
		LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
		  .with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("firstDayOfMonth: " + firstDayOfMonth);
		
	}
}