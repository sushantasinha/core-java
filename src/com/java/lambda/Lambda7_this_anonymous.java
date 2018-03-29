package com.java.lambda;

import java.util.function.Supplier;

public class Lambda7_this_anonymous {

	public void doProcess(int i, Supplier s){
		System.out.println("In Lambda7_this_anonymous.doProcess(): "  + this);
		s.get();
	}
	
	public String toString(){
		return "This is Lambda7_this_anonymous class";				
	}
	
	public static void main(String[] args) {
		Lambda7_this_anonymous l7 = new Lambda7_this_anonymous();
		//Try uncommented this
		//System.out.println(this);
		l7.doProcess(10, new Supplier<String>(){

			@Override
			public String get() {
				System.out.println("In Supplier " + this);
				System.out.println(this instanceof Supplier); // this is instance of Supplier
				return null;
			}
			
			public String toString(){
				return "This is annonimous inner class";				
			}
			
		});
	}
}
