package com.tw.igcc.model;

public class IntergalacticUnit {
	
	private String unitName;
	private RomanNumber romanNumber;
	
	public void add(String unitName, RomanNumber romanNumber) {
		this.unitName = unitName;
		this.romanNumber = romanNumber;
	}
	
	public String getUnitName() {
		return unitName;
	}
	
	public RomanNumber getRomanNumber() {
		return romanNumber;
	}
	
}
