package com.tw.igcc.query.calculator;

import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.MetalType;

public class HowManyQueyCalculatorFactory {

	public static HowManyQueryCalculator getHowManyCalculatorFactory(CommandArgs commandArgs) {
		String[] words = commandArgs.getInput().trim().split("\\s+");
		if(isCalculationForCredits(words, commandArgs)) {
			return new HowManyCreditCalculationImpl();
		}else if(isCalculationForMetal(words, commandArgs)) {
			return new HowManyMetalCalculationImpl();
		}
		throw new UnsupportedOperationException("I have no idea what you are talking about");
	}
	
	
	private static boolean isCalculationForCredits(String[] words, CommandArgs commandArgs) {
		return words.length >=7 && !(words.length <= 7 &&
				(commandArgs.getIgUnitNameVsIgUnit(words[4]) == null ||
				commandArgs.getIgUnitNameVsIgUnit(words[5]) == null || 
				commandArgs.getMetalVsMetalCredit(MetalType.valueOf(words[6])) == null));
	}
	
	private static boolean isCalculationForMetal(String[] words, CommandArgs commandArgs) {
		return words.length >= 7 && words[words.length-1].equals("?") && isValidMetalType(words[2]) && isValidIgUnit(commandArgs, words[4]) && isValidMetalType(words[5]);
	}
	
	private static boolean isValidMetalType(String metalType) {
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
