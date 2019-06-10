package com.tw.igcc.model;

public class MetalCredit {
	
	private MetalType metalType;
	private float credits;
	
	public MetalCredit(MetalType metalType, float credit) {
		this.metalType = metalType;
		this.credits = credit;
	}
	
	public MetalType getMetalType() {
		return metalType;
	}
	
	public float getCredits() {
		return credits;
	}

}
