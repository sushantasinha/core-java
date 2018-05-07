//http://www.mkyong.com/java8/java-convert-instant-to-localdatetime/
package com.java.java8.DateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class InstantExample1 {

    public static void main(String[] argv) {
        Instant instant = Instant.now();
        System.out.println("Instant :::: " + instant);
        //Convert instant to LocalDateTime, no timezone, add a zero offset / UTC+0
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        System.out.println("LocalDateTime : " + ldt);

    }

}