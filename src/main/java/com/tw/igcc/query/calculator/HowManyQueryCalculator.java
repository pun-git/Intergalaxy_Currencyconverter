package com.tw.igcc.query.calculator;

import com.tw.igcc.model.CommandArgs;

public interface HowManyQueryCalculator {
	
	float calculate(CommandArgs commandArgs, String input);
	String buildOutput(float calculatedResult, String input);

}
