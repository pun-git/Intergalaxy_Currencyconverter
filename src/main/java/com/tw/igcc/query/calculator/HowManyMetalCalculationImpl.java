package com.tw.igcc.query.calculator;

import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.MetalType;

public class HowManyMetalCalculationImpl implements HowManyQueryCalculator{
	
	@Override
	public float calculate(CommandArgs commandArgs, String input) {
		validate(commandArgs);
		return calculate(commandArgs);
	}
	
	private float calculate(CommandArgs commandArgs) {
		String words[] = commandArgs.getInput().split("\\s+");
		float igCredit  = commandArgs.getIgUnitNameVsIgUnit(words[4]).getRomanNumber().getRomanNumberInDigit();
		float metalCredit = commandArgs.getMetalVsMetalCredit(MetalType.valueOf(words[5])).getCredits();
		float metalInQueryCredit = commandArgs.getMetalVsMetalCredit(MetalType.valueOf(words[2])).getCredits();
		return (igCredit * metalCredit)/metalInQueryCredit;
	}
	
	@Override
	public String buildOutput(float calculatedResult, String input) {
		String[] words = input.split("\\s+");
		return calculatedResult+ " " +words[2]+" "+words[3]+" "+words[4]+" "+words[5];
	}
	
	private void validate(CommandArgs commandArgs) {
		if(commandArgs.getInput() == null || commandArgs.getInput().trim().isEmpty() || commandArgs.getInput().trim().split("\\s+").length < 7) {
			throw new IllegalArgumentException("I have no idea what you are talking about");
		}
		
		String words[] = commandArgs.getInput().trim().split("\\s+");
	
		if(!(words.length >= 6 && words[words.length-1].equals("?") && isValidMetalType(words[2]) && isValidIgUnit(commandArgs, words[4]) && isValidMetalType(words[5]))) {
			throw new IllegalArgumentException("I have no idea what you are talking about");
		}
	}
	

	private boolean isValidMetalType(String metalType) {
		try {
			MetalType.valueOf(metalType);
			return true;
		}catch(IllegalArgumentException e) {
			return false;
		}
	}
	
	private static boolean isValidIgUnit(CommandArgs commandArgs, String unitName) {
		return (commandArgs.getIgUnitNameVsIgUnit(unitName) != null);
	}
}
