package com.java.model;

public class FDModel {
	String fdDate;
	float fdAmount;
	String comment;
	String fdPeriod;
	
	public FDModel(String fdDate, float fdAmount, String fdPeriod, String comment) {
		super();
		this.fdDate = fdDate;
		this.fdAmount = fdAmount;
		this.comment = comment;
		this.fdPeriod = fdPeriod;
	}
	
	public String getFdDate() {
		return fdDate;
	}
	public void setFdDate(String fdDate) {
		this.fdDate = fdDate;
	}
	public float getFdAmount() {
		return fdAmount;
	}
	public void setFdAmount(float fdAmount) {
		this.fdAmount = fdAmount;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getFdPeriod() {
		return fdPeriod;
	}
	public void setFdPeriod(String fdPeriod) {
		this.fdPeriod = fdPeriod;
	}
	
	@Override
	public String toString() {
		return "FDModel [fdDate=" + fdDate + ", fdAmount=" + fdAmount + ", comment=" + comment + ", fdPeriod="
				+ fdPeriod + "]";
	}
}
