package com.tw.igcc.rn.validation.rule;

public class RSXValidationRule extends BaseRSValidationRule{
	
	@Override
	protected String[] getInvalidPattern() {
		return new String[]{"[IVXLCDM]*XXXX[IVXLCDM]*","[IVXLCDM]*X{5,}[IVXLCDM]*","[IVXLCDM]*X[DM][IVXLCDM]*"};
	}
}
