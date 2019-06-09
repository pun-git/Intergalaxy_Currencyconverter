package com.tw.igcc.model;

public class Metal {
	
	private MetalType metalType;
	private int credits;
	
	public Metal(MetalType metalType, int credit) {
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
