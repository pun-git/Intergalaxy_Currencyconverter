package com.tw.igcc.validation.rule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.rn.validation.rule.RSDValidationRule;

public class RSDValidationRuleTest {
	
	private RSDValidationRule rsdValidationRule;
	
	@Before
	public void setUp() {
		this.rsdValidationRule = new RSDValidationRule();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSucessesive2Ds() {
		rsdValidationRule.execute("MCMDDLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSubtractedByM() {
		rsdValidationRule.execute("MCMDMLIV");
	}
	
	@Test
	public void testValidatorRuleValid() {
		rsdValidationRule.execute("MCMDXLIV");
	}
	
	@After
	public void tearDown() {
		
	}
}
