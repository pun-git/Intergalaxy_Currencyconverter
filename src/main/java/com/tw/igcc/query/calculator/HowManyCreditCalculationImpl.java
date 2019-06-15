package com.tw.igcc.query.calculator;

import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.MetalType;
import com.tw.igcc.model.RomanNumber;

public class HowManyCreditCalculationImpl implements HowManyQueryCalculator{
	
	@Override
	public float calculate(CommandArgs commandArgs, String input) {
		validate(commandArgs);
		return calculate(commandArgs);
	}
	
	@Override
	public String buildOutput(float calculatedResult, String input) {
		return input.split("\\s+")[4] + " " + input.split("\\s+")[5] + " " + input.split("\\s+")[6] + " is " + ((Float)calculatedResult).intValue()+" Credits";
	}
	
	private float calculate(CommandArgs commandArgs) {
		String igcs[] = new String[] {commandArgs.getInput().split("\\s+")[4], commandArgs.getInput().split("\\s+")[5]};
		MetalType metalType = MetalType.valueOf(commandArgs.getInput().split("\\s+")[6]);
		String romanNumber = "";
		for(String igc : igcs) {
			romanNumber += commandArgs.getIgUnitNameVsIgUnit(igc).getRomanNumber().getRomanNumberInSymbol();
		}
		float credit = RomanNumber.create(romanNumber).getRomanNumberInDigit();
		credit *= commandArgs.getMetalVsMetalCredit(metalType).getCredits();
		return credit;
	}
	
	private void validate(CommandArgs commandArgs) {
		if(commandArgs.getInput() == null || commandArgs.getInput().trim().isEmpty() || commandArgs.getInput().trim().split("\\s+").length <= 7) {
			throw new IllegalArgumentException("I have no idea what you are talking about");
		}
		isValidMetalType(commandArgs.getInput().trim().split("\\s+")[6]);
		if(commandArgs.getIgUnitNameVsIgUnit(commandArgs.getInput().trim().split("\\s+")[4]) == null ||
				commandArgs.getIgUnitNameVsIgUnit(commandArgs.getInput().trim().split("\\s+")[5]) == null || 
				commandArgs.getMetalVsMetalCredit(MetalType.valueOf(commandArgs.getInput().trim().split("\\s+")[6])) == null) {
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
}
