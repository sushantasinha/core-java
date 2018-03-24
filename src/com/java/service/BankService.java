package com.java.service;

import java.util.Map;
import java.util.concurrent.*;
import com.java.concurrent.CallableFDDetailsService;
import com.java.concurrent.CallableTransactionService;
import com.java.model.FDModel;
import com.java.model.TransactionModel;

public class BankService {

	public static void main(String []args) throws InterruptedException, ExecutionException{
		//Thread
		ExecutorService es = Executors.newFixedThreadPool(2);//try with 1, and see result
		Future<Map<String, FDModel>> fdServiceFuture = es.submit(new CallableFDDetailsService(106));
		Future<Map<String, TransactionModel>> transactionServiceFuture = es.submit(new CallableTransactionService(106));
		
		for(String fdId : fdServiceFuture.get().keySet()){
			System.out.println("FD Printing from Main::: " + fdId );
		}
		
		for(String transactionId : transactionServiceFuture.get().keySet()){
			System.out.println("Transaction Printing from Main::: " + transactionId );
		}
		
		//Need to close ExecutorService. If you running this project in Eclipse 
		//(with commenting out below line), you can observe Terminate option still enable in Eclipse console
		es.shutdown();
		
		
		//Without Thread
		/*CallableTransactionService callableTransactionService = new CallableTransactionService(106);
		Map<String, TransactionModel>  transactionModelMap = callableTransactionService.getAllTransactionDetails();
		
		CallableFDDetailsService callableFDDetailsService = new CallableFDDetailsService(106);
		Map<String, FDModel>  fdModelMap = callableFDDetailsService.getAllFDDetails();
		
		for(String fdId : transactionModelMap.keySet()){
			System.out.println("FD Printing from Main::: " + fdId );
		}
		
		for(String transactionId : fdModelMap.keySet()){
			System.out.println("Transaction Printing from Main::: " + transactionId );
		}*/
		
		System.out.println("Done....................");
		
	}
}
