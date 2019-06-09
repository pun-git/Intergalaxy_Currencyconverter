package com.tw.igcc.rn.validation.rule;

import java.util.regex.Pattern;

import com.tw.igcc.api.Rule;
import com.tw.igcc.exception.InvalidRomanNumberException;

public abstract class BaseRSValidationRule implements Rule<String>{
	
	@Override
	public void execute(String romanNumber) {
		if(romanNumber == null || romanNumber.isEmpty()) {
			throw new InvalidRomanNumberException("Invalid Roman Number");
		}
		for(String pattern : getInvalidPattern()) {
			if(Pattern.matches(pattern, romanNumber)) {
				throw new InvalidRomanNumberException("Invalid Roman Number");
			}
		}
	}
	
	abstract protected String[] getInvalidPattern();
}
