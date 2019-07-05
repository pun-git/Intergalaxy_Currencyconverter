package com.tw.igcc.validation.rule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.rn.validation.rule.RSCValidationRule;

public class RSCValidationRuleTest {
	
	private RSCValidationRule rscValidationRule;
	
	@Before
	public void setUp() {	
		rscValidationRule = new RSCValidationRule();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSucessesive5cs() {
		rscValidationRule.execute("MCCCCCCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSucessesive4Cs() {
		rscValidationRule.execute("MCCCCCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByD() {
		rscValidationRule.execute("MCCCCDCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByM() {
		rscValidationRule.execute("MCCCCMCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByI() {
		rscValidationRule.execute("MCCCICLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByV() {
		rscValidationRule.execute("MCCCVCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByX() {
		rscValidationRule.execute("MCCCXCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByL() {
		rscValidationRule.execute("MCCCLCLIV");
	}
	@Test
	public void testValidatorRuleValidaNumber() {
		rscValidationRule.execute("MCMXLIV");
	}
	
	@After
	public void tearDown() {
		
	}


}
