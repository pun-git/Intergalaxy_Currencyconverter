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
	public void testValidatorRuleSucessesive4Is() {
		rsiValidator.execute("VIIIIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByM() {
		rsiValidator.execute("VIMV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByD() {
		rsiValidator.execute("VIDV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByC() {
		rsiValidator.execute("VICV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByL() {
		rsiValidator.execute("VILV");
	}
	
	@Test
	public void testValidatorRuleSubtractedByV() {
		rsiValidator.execute("VIVV");
	}
	@Test
	public void testValidatorRuleSubtractedByX() {
		rsiValidator.execute("VIXV");
	}
	
	@After
	public void tearDown() {
		
	}
	
}
