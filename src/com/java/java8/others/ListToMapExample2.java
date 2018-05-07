//From http://www.mkyong.com/java8/java-8-convert-list-to-map/
//List to Map � Duplicated Key!
package com.java.java8.others;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class ListToMapExample2 {

	public static void main(String[] args) {
		
		List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(2, "linodezzz.com", 100000));
        list.add(new Hosting(5, "mkyong.com", 1));

        Map<Integer, Long> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getId, Hosting::getWebsites,
                        (oldValue, newValue) -> newValue //or (oldValue, newValue) -> oldValue
                )
        );

        System.out.println("Result 1 : " + result1);
        
        
        
        
        
        //List to Map � Sort & Collect
        Map result2 = list.stream()
                .sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
                .collect(
                        Collectors.toMap(
                                Hosting::getName, Hosting::getWebsites, // key = name, value = websites
                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
                        ));

        System.out.println("Result 2 : " + result2);

        
     

	}

}



