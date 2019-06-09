package com.tw.igcc.validation.rule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.rn.validation.rule.RSIValidationRule;

public class RSIValidationRuleTest {
	
	private RSIValidationRule rsiValidator;
	
	@Before
	public void setUp() {
		rsiValidator = new RSIValidationRule();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_Sucessesive4Is() {
		rsiValidator.execute("VIIIIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByM() {
		rsiValidator.execute("VIMV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByD() {
		rsiValidator.execute("VIDV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByC() {
		rsiValidator.execute("VICV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByL() {
		rsiValidator.execute("VILV");
	}
	
	@Test
	public void testValidatorRule_SubtractedByV() {
		rsiValidator.execute("VIVV");
	}
	@Test
	public void testValidatorRule_SubtractedByX() {
		rsiValidator.execute("VIXV");
	}
	
	@After
	public void tearDown() {
		
	}
	
}
