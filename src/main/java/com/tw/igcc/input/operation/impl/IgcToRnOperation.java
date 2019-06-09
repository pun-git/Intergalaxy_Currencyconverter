package com.tw.igcc.input.operation.impl;

import java.util.Optional;

import com.tw.igcc.api.Operation;
import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.IntergalacticUnit;
import com.tw.igcc.model.RomanNumber;

public class IgcToRnOperation implements Operation<IntergalacticUnit, CommandArgs>{
	
	@Override
	public Optional<IntergalacticUnit> process(CommandArgs commandArgs) {
		validate(commandArgs.getInput());
		return getIGcUnit(commandArgs.getInput());
	}
	
	public void validate(String input) throws InvalidRomanNumberException{
		if(input == null || input.isEmpty() || input.trim().split("\\s+").length < 3) {
			throw new UnsupportedOperationException("I have no idea what you are talking about");
		}
	}
	
	public Optional<IntergalacticUnit> getIGcUnit(String input) throws InvalidRomanNumberException{
		String[] inputs = input.split("\\s+");
		return Optional.of(new IntergalacticUnit(inputs[0], RomanNumber.create(inputs[2])));
	}

}
