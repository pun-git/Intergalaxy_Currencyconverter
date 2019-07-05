package com.tw.igcc.validation.rule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.rn.validation.rule.RSXValidationRule;

public class RSXValidationRuleTest {
	
	private RSXValidationRule rsxValidationRule;

	@Before
	public void setUp() {
		rsxValidationRule = new RSXValidationRule();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSucessesive5Xs() {
		rsxValidationRule.execute("MCXXXXXLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSucessesive4Xs() {
		rsxValidationRule.execute("MCXXXXLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByD() {
		rsxValidationRule.execute("MCXXXDXLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByM() {
		rsxValidationRule.execute("MCXXXMXLIV");
	}
	
	@Test
	public void testValidatorRuleSubtractedByL() {
		rsxValidationRule.execute("MCXXXLXLIV");
	}
	
	@Test
	public void testValidatorRuleSubtractedByC() {
		rsxValidationRule.execute("MCXXXCXLIV");
	}
	
	@Test
	public void testValidatorRulevalidaNumber() {
		rsxValidationRule.execute("MCMXLIV");
	}
	
	@After
	public void tearDown() {
		
	}
	
}
