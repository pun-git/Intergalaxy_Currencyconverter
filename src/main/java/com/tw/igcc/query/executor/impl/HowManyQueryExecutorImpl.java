package com.tw.igcc.query.executor.impl;

import java.util.Optional;

import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.query.calculator.HowManyQueryCalculator;
import com.tw.igcc.query.calculator.HowManyQueyCalculatorFactory;
import com.tw.igcc.query.executor.api.QueryExecutor;

public class HowManyQueryExecutorImpl implements QueryExecutor{
	
	@Override
	public Optional<String> execute(CommandArgs commandArgs) {
		validate(commandArgs.getInput());
		float calculatedResult = calculate(commandArgs);
		return Optional.of(HowManyQueyCalculatorFactory.getHowManyCalculatorFactory(commandArgs).buildOutput(calculatedResult, commandArgs.getInput()));
	}
	
	private void validate(String input) {
		if(input == null || input.isEmpty()) {
			throw new IllegalArgumentException("");
		}
	}
	private float calculate(CommandArgs commandArgs) {
		HowManyQueryCalculator howManyQueryCalculator = HowManyQueyCalculatorFactory.getHowManyCalculatorFactory(commandArgs);
		String input = commandArgs.getInput();
		return howManyQueryCalculator.calculate(commandArgs, input);
	}
}
