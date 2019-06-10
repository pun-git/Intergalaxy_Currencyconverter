package com.tw.igcc.input.operation.impl;

import java.util.Optional;

import com.tw.igcc.api.Operation;
import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.IntergalacticUnit;
import com.tw.igcc.model.Result;
import com.tw.igcc.model.RomanNumber;

public class IgcToRnOperation implements Operation<Result, CommandArgs>{
	
	@Override
	public Optional<Result> process(CommandArgs commandArgs) {
		validate(commandArgs.getInput());
		return getIGcUnit(commandArgs.getInput());
	}
	
	private void validate(String input) throws InvalidRomanNumberException{
		if(input == null || input.isEmpty() || input.trim().split("\\s+").length < 3) {
			throw new UnsupportedOperationException("I have no idea what you are talking about");
		}
	}
	
	private Optional<Result> getIGcUnit(String input) throws InvalidRomanNumberException{
		String[] inputs = input.split("\\s+");
		return Optional.of(new Result(new IntergalacticUnit(inputs[0], RomanNumber.create(inputs[2]))));
	}

}
