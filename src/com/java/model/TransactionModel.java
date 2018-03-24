package com.java.model;

import java.util.Date;

public class TransactionModel {
	@Override
	public String toString() {
		return "TransactionModel [toAccount=" + toAccount + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + ", comment=" + comment + "]";
	}
	int toAccount;
	String transactionDate;
	float transactionAmount;
	String comment;
	
	public TransactionModel(int toAccount, String transactionDate, float transactionAmount, String comment) {
		super();
		this.toAccount = toAccount;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.comment = comment;
	}
	
	public int gettoAccount() {
		return toAccount;
	}
	public void settoAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public float getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	
	
}
