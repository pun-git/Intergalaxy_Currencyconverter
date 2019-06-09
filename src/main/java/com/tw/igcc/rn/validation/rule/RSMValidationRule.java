package com.tw.igcc.rn.validation.rule;

public class RSMValidationRule extends BaseRSValidationRule{
	
	@Override
	protected String[] getInvalidPattern() {
		return new String[]{"[IVXLCDM]*MMMM[IVXLCDM]*","[IVXLCDM]*M{5,}[IVXLCDM]*"};
	}
}
