package com.java.java8.lambda;

import java.util.*;

interface Drawable{  
    public int draw(int a, int b);  
}  
public class Test {  
    public static void main(String[] args) {  
        int width=10;  
  
        Drawable d =(a,b)-> {
        	return a+b;
        };
        System.out.println(d.draw(1,2));
        
        List<String> list=new ArrayList<String>();  
        list.add("ankit");  
        list.add("mayank");  
        list.add("zxzx");  
        list.add("jai");  
        list.forEach(
        		(i) -> System.out.println(i)
        );
    }  
}  