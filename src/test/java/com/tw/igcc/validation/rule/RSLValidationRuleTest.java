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
	public void testValidatorRule_Sucessesive2Ls() {
		rslValidationRule.execute("MCMXLLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByC() {
		rslValidationRule.execute("MCMXLCIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByD() {
		rslValidationRule.execute("MCMXLDIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByM() {
		rslValidationRule.execute("MCMXLMIV");
	}
	
	@Test
	public void testValidatorRule_Valid() {
		rslValidationRule.execute("MCMXLIV");
	}
	
	@Test
	public void testValidatorRule_ValidWithCDM() {
		rslValidationRule.execute("MCMXMDCLIV");
	}
	
	@After
	public void tearDown() {
		
	}
}
