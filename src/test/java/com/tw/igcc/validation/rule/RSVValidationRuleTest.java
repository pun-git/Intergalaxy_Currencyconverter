package com.tw.igcc.validation.rule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.rn.validation.rule.RSVValidationRule;

public class RSVValidationRuleTest {
	
	private RSVValidationRule rsvValidationRule;

	@Before
	public void setUp() {
		rsvValidationRule = new RSVValidationRule();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSucessesive2Vs() {
		rsvValidationRule.execute("MCMXVVIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByX() {
		rsvValidationRule.execute("MCMXVXIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByL() {
		rsvValidationRule.execute("MCMXVLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByC() {
		rsvValidationRule.execute("MCMXVCIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByD() {
		rsvValidationRule.execute("MCMXVDIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByM() {
		rsvValidationRule.execute("MCMXVMIV");
	}
	
	@Test
	public void testValidatorRuleValid() {
		rsvValidationRule.execute("MCMXLIV");
	}
	
	@After
	public void tearDown() {
		
	}
	
}
