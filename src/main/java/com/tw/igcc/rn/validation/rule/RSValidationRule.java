package com.tw.igcc.rn.validation.rule;

public class RSValidationRule extends BaseRSValidationRule{

	@Override
	protected String[] getInvalidPattern() {
		return new String[]{"[IVXLCDM]*[^IVXLCDM]+[IVXLCDM]*"};
	}
}
