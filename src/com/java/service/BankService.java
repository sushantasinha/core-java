package com.java.service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import com.java.concurrent.CallableFDDetailsService;
import com.java.concurrent.CallableTransactionService;
import com.java.model.FDModel;
import com.java.model.TransactionModel;

public class BankService {
	
	private static ExecutorService es = Executors.newFixedThreadPool(3);//try with 1, and see result
	//Thread pool should be created once and should be used through out the application. 
	//In that way we can limit total number of threads in application;
	//Otherwise if a thread pool will be created for each user and we can not control number on number of threads 
	
	//private static ExecutorService esAdmin = Executors.newFixedThreadPool(2);
	
	public static void main(String []args) throws InterruptedException, ExecutionException{	
		
		/*Callable<String> aCallable = new Callable<String>(){
            String result = "Callable done !";
            ThreadPoolExecutor pool = (ThreadPoolExecutor) es;
            @Override
            public String call() throws Exception {
            	boolean b = true;
                while(b){
                	System.out.println("************ Core threads: " + pool.getCorePoolSize());
                    System.out.println("Largest number of simultaneous executions: "
                                                        + pool.getLargestPoolSize());
                    System.out.println("Maximum number of  allowed threads: "
                                                        + pool.getMaximumPoolSize());
                    System.out.println("Current threads in the pool: "
                                                        + pool.getPoolSize());
                    System.out.println("Currently executing threads: "
                                                        + pool.getActiveCount());
                    System.out.println("Total number of threads ever scheduled: "
                                                        + pool.getTaskCount());
                    
                    Thread.sleep(1000);
                }
                return result;
            }
            
        }; 
		esAdmin.submit(aCallable);*/

		
		new BankService().getDetails();		
		
		shutdown();
	}
	
	private static void shutdown() {
		//Need to close ExecutorService. If you running this project in Eclipse 
		//(with commenting out below line), you can observe Terminate option still enable in Eclipse console
		es.shutdown();		
	}

	private void getDetails() throws InterruptedException, ExecutionException{
		
		//Note: After this line there would be 2 separate parallel execution - 1. Main flow execution 
		//2. IN parallel CallableFDDetailsService will run as the part flow a separate thread
		Future<Map<String, FDModel>> fdServiceFuture = es.submit(new CallableFDDetailsService(106));
		
		//Note: Below code is NON-BLOCKING code. Although this will start execute CallableTransactionService.call() here
		//Evidence: The "****************:::::: CallableTransactionService ***********" will print immediately
		//but transactionServiceFuture.get() is BLOCKING code. BY the time it reaches this line (transactionServiceFuture.get()),
		//if the CallableTransactionService.call() execution is NOT completed, here this asynchronous call will be blocked
		//until that transactionServiceFuture.get() is completed. Try to debug the code and see the result.
		Future<Map<String, TransactionModel>> transactionServiceFuture = es.submit(new CallableTransactionService(106));
		
		
		Map<String, FDModel> map = fdServiceFuture.get();//Note: Blocking
	
		
		for(String fdId : fdServiceFuture.get().keySet()){
			System.out.println("FD Printing from Main::: " + fdId );
		}
		
		es.submit(()->System.out.println("Thread 333 ........."));

		try {
			
			Set<String> s = transactionServiceFuture.get(60000, TimeUnit.MILLISECONDS ).keySet();
		
			for(String transactionId : s){
				System.out.println("Transaction Printing from Main::: " + transactionId );
			}
		} catch (TimeoutException e) {
			e.printStackTrace();
			transactionServiceFuture.cancel(true);
		}
		
		
		
		
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
