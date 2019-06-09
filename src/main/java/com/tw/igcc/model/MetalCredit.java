package com.tw.igcc.model;

public class MetalCredit {
	
	private MetalType metalType;
	private int credits;
	
	public MetalCredit(MetalType metalType, int credit) {
		this.metalType = metalType;
		this.credits = credit;
	}
	
	public MetalType getMetalType() {
		return metalType;
	}
	
	public int getCredits() {
		return credits;
	}

}
