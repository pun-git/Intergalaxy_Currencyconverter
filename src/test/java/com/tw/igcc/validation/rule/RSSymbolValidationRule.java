package com.tw.igcc.validation.rule;

import com.tw.igcc.api.Rule;
import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.model.RomanSymbol;

public class RSSymbolValidationRule implements Rule<String>{
	
	public void execute(String romanNumber) throws InvalidRomanNumberException {
		char[] romansymbols = romanNumber.toCharArray();
		
		for(char romansymbol : romansymbols) {
			try {
				RomanSymbol.valueOf(String.valueOf(romansymbol));
			}catch (IllegalArgumentException e) {
				throw new InvalidRomanNumberException("Invalid Roman Number");
			}
		}
	}

}
