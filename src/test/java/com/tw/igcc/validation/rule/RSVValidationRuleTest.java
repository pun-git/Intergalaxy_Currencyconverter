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
	public void testValidatorRule_Sucessesive2Vs() {
		rsvValidationRule.execute("MCMXVVIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByX() {
		rsvValidationRule.execute("MCMXVXIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByL() {
		rsvValidationRule.execute("MCMXVLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByC() {
		rsvValidationRule.execute("MCMXVCIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByD() {
		rsvValidationRule.execute("MCMXVDIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByM() {
		rsvValidationRule.execute("MCMXVMIV");
	}
	
	@Test
	public void testValidatorRule_Valid() {
		rsvValidationRule.execute("MCMXLIV");
	}
	
	@After
	public void tearDown() {
		
	}
	
}
