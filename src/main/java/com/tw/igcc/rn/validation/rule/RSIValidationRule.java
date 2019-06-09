package com.tw.igcc.rn.validation.rule;

public class RSIValidationRule extends BaseRSValidationRule{

	@Override
	protected String[] getInvalidPattern() {
		return new String[]{"[IVXLCDM]*I{4,}[IVXLCDM]*", "[IVXLCDM]*[I{1,3}][LCDM]+[IVXLCDM]*"};
	}
	
}
