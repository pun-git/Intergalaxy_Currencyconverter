package com.tw.igcc.rn.validation.rule;

public class RSCValidationRule extends BaseRSValidationRule{

	@Override
	protected String[] getInvalidPattern() {
		return new String[]{"[IVXLCDM]*C{4,}[IVXLCDM]*","[IVXLCDM]*CCC[IVXLC]C[IVXLCDM]*"};
	}
}
