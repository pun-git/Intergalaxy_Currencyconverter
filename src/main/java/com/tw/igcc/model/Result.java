package com.tw.igcc.model;

public class Result {
	
	private MetalCredit metalCredit;
	private IntergalacticUnit intergalacticUnit;
	private String output;
	
	public Result(MetalCredit metalCredit) {
		this.metalCredit = metalCredit;
	}
	
	public Result(IntergalacticUnit intergalacticUnit) {
		this.intergalacticUnit = intergalacticUnit;
	}
	
	public Result(String output) {
		this.output = output;
	}

	public MetalCredit getMetalCredit() {
		return metalCredit;
	}
	
	public IntergalacticUnit getIntergalacticUnit() {
		return intergalacticUnit;
	}

	public String getOutput() {
		return output;
	}
}
