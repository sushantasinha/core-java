//From http://www.mkyong.com/java8/java-8-convert-list-to-map/
package com.java.java8.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class MapToListExample {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        System.out.println("\n1. Export Map Key to List...");
		
        List<Integer> result = new ArrayList(map.keySet());
		
        result.forEach(System.out::println);

        System.out.println("\n2. Export Map Value to List...");
		
        List<String> result2 = new ArrayList(map.values());
		
        result2.forEach(System.out::println);

    }
	

}


