package com.tw.igcc.input.operation.impl;

import java.util.Optional;

import com.tw.igcc.api.Operation;
import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.MetalCredit;
import com.tw.igcc.model.MetalType;
import com.tw.igcc.model.Result;
import com.tw.igcc.model.RomanNumber;

public class MetalToCreditOperation implements Operation<Result, CommandArgs>{
	
	@Override
	public Optional<Result> process(CommandArgs commandArgs) {
		validate(commandArgs.getInput());
		RomanNumber romanNumber = createRomanNumber(commandArgs.getInput(), commandArgs);
		return Optional.of(new Result(new MetalCredit(MetalType.valueOf(commandArgs.getInput().trim().split("\\s+")[2]), (float)(Float.valueOf(commandArgs.getInput().trim().split("\\s+")[4]) / (float)romanNumber.getRomanNumberInDigit()))));
	}
	
	private void validate(String input) {
		if(input == null || input.trim().isEmpty() || input.trim().split("\\s+").length<5) {
			throw new UnsupportedOperationException("I have no idea what you are talking about");
		}
		if(!isValidMetalType(input.trim().split("\\s+")[2])) {
			throw new IllegalArgumentException("Unkown Metal Type");
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
	
	private RomanNumber createRomanNumber(String input, CommandArgs commandArgs) {
		String inputs[] = input.trim().split("\\s+");
		if(commandArgs.getIgUnitNameVsIgUnit(inputs[0]) == null || commandArgs.getIgUnitNameVsIgUnit(inputs[0]).getRomanNumber() == null
				|| commandArgs.getIgUnitNameVsIgUnit(inputs[1]) == null || commandArgs.getIgUnitNameVsIgUnit(inputs[1]).getRomanNumber() == null) {
			throw new UnsupportedOperationException("I have no idea what you are talking about");
		}
		return RomanNumber.create(commandArgs.getIgUnitNameVsIgUnit(inputs[0]).getRomanNumber().getRomanNumberInSymbol()+commandArgs.getIgUnitNameVsIgUnit(inputs[1]).getRomanNumber().getRomanNumberInSymbol());
	}
}
