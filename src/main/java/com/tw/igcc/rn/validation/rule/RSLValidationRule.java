package com.tw.igcc.rn.validation.rule;

public class RSLValidationRule extends BaseRSValidationRule{

	@Override
	protected String[] getInvalidPattern() {
		return new String[]{"[IVXLCDM]*L{1,}[CDM]+[IVXLCDM]*","[IVXLCDM]*L{2,}[IVXLCDM]*"};
	}
}
