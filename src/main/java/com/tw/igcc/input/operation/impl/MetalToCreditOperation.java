package com.tw.igcc.input.operation.impl;

import java.util.Optional;

import com.tw.igcc.api.Operation;
import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.MetalCredit;
import com.tw.igcc.model.MetalType;
import com.tw.igcc.model.RomanNumber;

public class MetalToCreditOperation implements Operation<MetalCredit, CommandArgs>{
	
	@Override
	public Optional<MetalCredit> process(CommandArgs commandArgs) {
		validate(commandArgs.getInput());
		RomanNumber romanNumber = createRomanNumber(commandArgs.getInput());
		return Optional.of(new MetalCredit(MetalType.valueOf(commandArgs.getInput().trim().split("\\s+")[3]), (Integer.valueOf(commandArgs.getInput().trim().split("\\s+")[6]) - (int)romanNumber.getRomanNumberInDigit())));
	}
	
	private void validate(String input) {
		if(input == null || input.trim().isEmpty() || input.trim().split("\\s+").length<5) {
			throw new UnsupportedOperationException("I have no idea what you are talking about");
		}
	}
	
	private RomanNumber createRomanNumber(String input) {
		String inputs[] = input.trim().split("\\s+");
		return RomanNumber.create(inputs[0]+inputs[1]);
	}
}
