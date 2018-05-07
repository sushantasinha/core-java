package com.java.serialization;

import java.io.*;

public class SerializationExample {

	public static void main(String[] args) throws IOException {
	
		SerializationExample se = new SerializationExample();
		se.writeObj();

	}
	
	
	private void writeObj() throws IOException{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("emp.ser");
			oos = new ObjectOutputStream(fos);
			Employee  e = new Employee(123, "name1");
			oos.writeObject(e);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		 finally{
			 fos.close();
			 oos.close();
		 }
		
		
		
	}

}
