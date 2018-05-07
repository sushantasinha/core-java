package com.java.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeSerializationExample2 {
	


	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		DeSerializationExample2 dse = new DeSerializationExample2();
		dse.readObj();

	}
	
	
	private void readObj() throws IOException, ClassNotFoundException{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("emp.ser");
			ois = new ObjectInputStream(fis);
			Employee e = (Employee) ois.readObject();
			System.out.println(e.getEmpId() + " " + e.getName());
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		 finally{
			 fis.close();
			 ois.close();
		 }
		
		
		
	}


}
