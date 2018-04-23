package com.java.java8.DateTime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
//Read from http://www.baeldung.com/java-8-date-time-intro
import java.util.Set;

//Read from http://www.baeldung.com/java-8-date-time-intro
/*Java 8 provides ZonedDateTime when we need to deal with time zone specific date and time. The ZoneId is an identifier used to represent 
different zones. There are about 40 different time zones and the ZoneId are used to represent them as follows.*/

public class Java8ZonedDateTime{
	
	public static void main(String args[]){
		
		ZoneId zoneId = ZoneId.of("Asia/Calcutta");
		System.out.println("zoneId: " + zoneId);
		
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();//A set of all zone ids
		allZoneIds.forEach(action -> System.out.println(action));
		
		LocalDateTime localDateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);//The LocalDateTime can be converted to a specific zone:
		System.out.println("Local Time Now: " + localDateTime  + " Asia/Calcutta Time Now: " + zonedDateTime);
		
		//The ZonedDateTime provides parse method to get time zone specific date time:
		ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");
		System.out.println("zonedDateTime2: " + zonedDateTime2);
		
		
		/*Another way to work with time zone is by using OffsetDateTime. The OffsetDateTime is an immutable representation of a date-time 
		with an offset. This class stores all date and time fields, to a precision of nanoseconds, as well as the offset from UTC/Greenwich.*/
		LocalDateTime localDateTimeAnother = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
		ZoneOffset offset = ZoneOffset.of("+02:00");		 
		OffsetDateTime offSetByTwo = OffsetDateTime.of(localDateTime, offset);
		System.out.println("offSetByTwo: " + offSetByTwo);
		

	
		
	}
}