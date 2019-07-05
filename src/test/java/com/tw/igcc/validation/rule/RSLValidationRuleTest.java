package com.tw.igcc.validation.rule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.rn.validation.rule.RSLValidationRule;

public class RSLValidationRuleTest {
	
	private RSLValidationRule rslValidationRule;
	
	@Before
	public void setUp() {
		this.rslValidationRule = new RSLValidationRule();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSucessesive2Ls() {
		rslValidationRule.execute("MCMXLLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByC() {
		rslValidationRule.execute("MCMXLCIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByD() {
		rslValidationRule.execute("MCMXLDIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByM() {
		rslValidationRule.execute("MCMXLMIV");
	}
	
	@Test
	public void testValidatorRuleValid() {
		rslValidationRule.execute("MCMXLIV");
	}
	
	@Test
	public void testValidatorRuleValidWithCDM() {
		rslValidationRule.execute("MCMXMDCLIV");
	}
	
	@After
	public void tearDown() {
		
	}
}
