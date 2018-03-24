package com.java.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import com.java.model.FDModel;

public class CallableFDDetailsService implements Callable<Map<String, FDModel>>{

	int bankAccountNumber;
	
	public CallableFDDetailsService(int bankAccountNumber){
		this.bankAccountNumber = bankAccountNumber;
	}
	
	@Override
	public Map<String, FDModel> call() throws Exception {		
		return getAllFDDetails();
	}

		
	public Map<String, FDModel> getAllFDDetails(){//making it public to test non-thread process
		
		Map<String, FDModel> fdModelMap = new HashMap<String, FDModel>();
		for(int i = 0; i < 20; i++){
			FDModel fdModel = new FDModel("2018-02-10", 2345.45f, "1Y", "this is a FD " + i);
			fdModelMap.put("FD" + Integer.toString(i), fdModel); 
			System.out.println("*** FD Added: " + fdModel);
		}
		
		return fdModelMap;		
	}

		
	
}
