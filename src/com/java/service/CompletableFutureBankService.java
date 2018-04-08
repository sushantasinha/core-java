package com.java.service;

import java.util.Map;
import java.util.concurrent.*;
import com.java.concurrent.CallableFDDetailsService;
import com.java.concurrent.CallableTransactionService;
import com.java.model.FDModel;
import com.java.model.TransactionModel;

public class CompletableFutureBankService {
	
	private static ExecutorService es = Executors.newFixedThreadPool(2);
	

	public static void main(String []args) throws InterruptedException, ExecutionException{		
		
		new CompletableFutureBankService().calculateAsync();
	}
	
	public Future<String> calculateAsync() throws InterruptedException {
	    CompletableFuture<String> completableFuture 
	      = new CompletableFuture<>();
	 
	    es.submit(() -> {
	        Thread.sleep(500);
	        completableFuture.complete("Hello");
	        return null;
	    });
	 
	    return completableFuture;
	}
	
}
