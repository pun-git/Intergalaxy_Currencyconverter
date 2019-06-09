package com.tw.igcc.model;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.rn.util.RomanNumberUtil;
import com.tw.igcc.rn.validation.rule.builder.ValidationRuleChainBuilder;
import com.tw.igcc.rn.validation.rule.executor.RuleExecutor;

public class RomanNumber {
		
	private long romanNumberInDigit;

	private RomanNumber() {}
	
	public static RomanNumber create(String romanNumberInSymbol) throws InvalidRomanNumberException {
		
		RomanNumber romanNumber = new RomanNumber();
		romanNumber.validate(romanNumberInSymbol);
		romanNumber.romanNumberInDigit = RomanNumberUtil.convertRomanNumberToDecimal(romanNumberInSymbol);
		return romanNumber;
	}
	
	private void validate(String romanNumber) throws InvalidRomanNumberException{
		RuleChain ruleChain = new ValidationRuleChainBuilder().build();
		new RuleExecutor().execute(ruleChain, romanNumber);
	}
	
	public long getRomanNumberInDigit() {
		return romanNumberInDigit;
	}

}
