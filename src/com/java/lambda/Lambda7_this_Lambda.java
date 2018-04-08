package com.java.lambda;

import java.util.function.Supplier;

//Note: There is difference between Anonymous Inner Class and Lambda.
//As in Lambda7_this_anonymous (line 25) we can observe, 'this' returning instance of Supplier.
//But in Lambda 'this' returns instance of Parent class i.e. Lambda7_this_Lambda
//SO, if we try un-commenting line 33-40, 
//this will give error as we are trying to get 'this' instance from static instance, the same was working in Lambda7_this_anonymous
public class Lambda7_this_Lambda {

	public void doProcess(int i, Supplier<String> s){
		System.out.println("In Lambda7_this_Lambda.doProcess(): "  + this);
		s.get();
	}

	private void doProcessAnother(){
			this.doProcess(10, () -> {
			System.out.println("In Supplier: " + this);
			System.out.println(this instanceof Supplier); // this is instance of Supplier
			return null;
		});
	}
	
	public String toString(){
		return "This is Lambda7_this_Lambda class";				
	}
	
	public static void main(String[] args) {
		Lambda7_this_Lambda l7 = new Lambda7_this_Lambda();
		l7.doProcessAnother();
		//Try uncommented this
		//System.out.println(this);
		
		//Try uncommented this
		/*l7.doProcess(10, () -> {
			System.out.println("In Supplier " + this);
			System.out.println(this instanceof Supplier); // this is instance of Supplier
			return null;
		});*/
	}
}
