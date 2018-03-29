package com.java.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import com.java.model.TransactionModel;

public class CallableTransactionService implements Callable<Map<String, TransactionModel>> {

	int bankAccountNumber;

	public CallableTransactionService(int bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	@Override
	public Map<String, TransactionModel> call() throws Exception {
		System.out.println("****************:::::: CallableTransactionService ***********");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getAllTransactionDetails();
	}

	public Map<String, TransactionModel> getAllTransactionDetails() {//making it public to test non-thread process
		
		Map<String, TransactionModel> transactionModelMap = new HashMap<String, TransactionModel>();
		for (int i = 0; i < 10; i++) {
			TransactionModel transactionModel = new TransactionModel((int) Math.random(), "2018-01-28", 123.234f,
					"Comment" + i);
			transactionModelMap.put("T" + Integer.toString(i), transactionModel);
			System.out.println("$$$ Transaction Added: " + transactionModel);
			
		}

		return transactionModelMap;

	}

}
