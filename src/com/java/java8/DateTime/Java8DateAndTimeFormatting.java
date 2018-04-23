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
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
//Read from http://www.baeldung.com/java-8-date-time-intro
import java.util.Set;

//Read from http://www.baeldung.com/java-8-date-time-intro

public class Java8DateAndTimeFormatting{
	
	public static void main(String args[]){
		
		LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
		System.out.println("localDateTime: " + localDateTime);
		String localDate = localDateTime.format(DateTimeFormatter.ISO_DATE);
		System.out.println("localDate: " + localDate);
		
		//The DateTimeFormatter provides various standard formatting options. 
		String localDateFormat = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println("localDateFormat: " + localDateFormat);
		
		//We can pass in formatting style either as SHORT, LONG or MEDIUM as part of the formatting option. 
		/*String localDateFormat2 = localDateTime
		  .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).ofPattern("yyyy/MM/dd hh MM ss").withLocale(Locale.UK));*/
		String localDateFormat2 =  localDateTime
		  .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK));
		System.out.println("localDateFormat2: " + localDateFormat2);
		
		String localDateFormat3 =  localDateTime
				  .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US));
				System.out.println("localDateFormat3: " + localDateFormat3);
		
	}
	
	/*"Using Project Threeten" and "Joda-Time Library":
	Alternatives for Java 8 Date and Time library*/
	
}