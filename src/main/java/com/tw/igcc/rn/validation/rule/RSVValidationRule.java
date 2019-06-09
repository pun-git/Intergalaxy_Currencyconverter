package com.tw.igcc.rn.validation.rule;

public class RSVValidationRule extends BaseRSValidationRule{
	
	@Override
	protected String[] getInvalidPattern() {
		return new String[]{"[IVXLCDM]*V{1,}[XLCDM]+[IVXLCDM]*","[IVXLCDM]*V{2,}[IVXLCDM]*"};
	}
	
}
