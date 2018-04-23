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
import java.util.Calendar;
import java.util.Date;
//Read from http://www.baeldung.com/java-8-date-time-intro
import java.util.Set;

//Read from http://www.baeldung.com/java-8-date-time-intro

public class Java8DateCalendarCompatibility{
	
	public static void main(String args[]){
		Date date = new Date(); System.out.println("date"  + date);
		Calendar calendar = Calendar.getInstance(); System.out.println("calendar"  + calendar.getTime());
		LocalDateTime localDateTimeFromDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime localDateTimeFromTime = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
		System.out.println("localDateTimeFromDate: "  + localDateTimeFromDate);
		System.out.println("localDateTimeFromTime: "  + localDateTimeFromTime);		
		
	}
}