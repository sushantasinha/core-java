//http://www.mkyong.com/java8/java-8-stringjoiner-example/
package com.java.java8.others;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerExample {

	public static void main(String[] args) {
		
		StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString();
        System.out.println(result);
        
        StringJoiner sj1 = new StringJoiner("/", "prefix-", "-suffix");
        sj1.add("2016");
        sj1.add("02");
        sj1.add("26");
        String result1 = sj1.toString(); 
        System.out.println(result1);

        String result2 = String.join("-", "2015", "10", "31" );
        System.out.println(result2);
        
        //Join a List by a delimiter
        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
    	String result3 = String.join(", ", list);
    	System.out.println(result3);
        
	}

}
