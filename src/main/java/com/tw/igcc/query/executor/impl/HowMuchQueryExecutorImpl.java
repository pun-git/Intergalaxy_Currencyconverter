package com.tw.igcc.query.executor.impl;

import java.util.Optional;

import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.RomanNumber;
import com.tw.igcc.query.executor.api.QueryExecutor;

public class HowMuchQueryExecutorImpl implements QueryExecutor{
	
	@Override
	public Optional<String> execute(CommandArgs commandArgs) {
		long calculatedResult = calculate(commandArgs);
		return Optional.of(buildOutput(commandArgs.getInput(), calculatedResult));
	}
	
	private String buildOutput(String input, long calculatedResult) {
		return input.split("\\s+")[3] + " " + input.split("\\s+")[4] + " " + input.split("\\s+")[5] + " " + input.split("\\s+")[6] + " is " + calculatedResult;
	}
	
	private long calculate(CommandArgs commandArgs) {
		validate(commandArgs);
		return processQuery(commandArgs);
	}
	
	private long processQuery(CommandArgs commandArgs) {
		String igcs[] = new String[] {commandArgs.getInput().split("\\s+")[3], commandArgs.getInput().split("\\s+")[4], commandArgs.getInput().split("\\s+")[5], commandArgs.getInput().split("\\s+")[6]};
		String romanNumber = "";
		for(String igc : igcs) {
			romanNumber += commandArgs.getIgUnitNameVsIgUnit(igc).getRomanNumber().getRomanNumberInSymbol();
		}
		return RomanNumber.create(romanNumber).getRomanNumberInDigit();
	}
	
	private void validate(CommandArgs commandArgs) {
		if(commandArgs.getInput() == null || commandArgs.getInput().trim().isEmpty() || commandArgs.getInput().trim().split("\\s+").length <= 4) {
			throw new IllegalArgumentException("I have no idea what you are talking about");
		}
		
		if(commandArgs.getIgUnitNameVsIgUnit(commandArgs.getInput().trim().split("\\s+")[3]) == null ||
				commandArgs.getIgUnitNameVsIgUnit(commandArgs.getInput().trim().split("\\s+")[4]) == null ||
				commandArgs.getIgUnitNameVsIgUnit(commandArgs.getInput().trim().split("\\s+")[5]) == null ||
				commandArgs.getIgUnitNameVsIgUnit(commandArgs.getInput().trim().split("\\s+")[6]) == null) {
			throw new IllegalArgumentException("I have no idea what you are talking about");
		}
	}
}
