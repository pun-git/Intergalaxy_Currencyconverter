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
	public void testValidatorRule_Sucessesive5Xs() {
		rsxValidationRule.execute("MCXXXXXLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_Sucessesive4Xs() {
		rsxValidationRule.execute("MCXXXXLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByD() {
		rsxValidationRule.execute("MCXXXDXLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByM() {
		rsxValidationRule.execute("MCXXXMXLIV");
	}
	
	@Test
	public void testValidatorRule_SubtractedByL() {
		rsxValidationRule.execute("MCXXXLXLIV");
	}
	
	@Test
	public void testValidatorRule_SubtractedByC() {
		rsxValidationRule.execute("MCXXXCXLIV");
	}
	
	@Test
	public void testValidatorRule_validaNumber() {
		rsxValidationRule.execute("MCMXLIV");
	}
	
	@After
	public void tearDown() {
		
	}
	
}
