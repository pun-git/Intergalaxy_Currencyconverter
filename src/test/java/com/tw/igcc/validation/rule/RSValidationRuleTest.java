package com.tw.igcc.validation.rule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.rn.validation.rule.RSValidationRule;

public class RSValidationRuleTest {
	
	private RSValidationRule rsValidationRule;

	@Before
	public void setUp() {
		rsValidationRule = new RSValidationRule();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testForInvalidRomanSymbol() {
		rsValidationRule.execute("MCMXQQQIV");
	}
	
	@Test
	public void testForValidRomanSymbol() {
		rsValidationRule.execute("MCMXLIV");
	}
	
	@After
	public void tearDown() {
		
	}
	
}
