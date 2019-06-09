package com.tw.igcc.rn.validation.rule;

public class RSDValidationRule extends BaseRSValidationRule{
	
	@Override
	protected String[] getInvalidPattern() {
		return new String[]{"[IVXLCDM]*D[M][IVXLCDM]*","[IVXLCDM]*D{2,}[IVXLCDM]*"};
	}
}
