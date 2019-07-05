package com.tw.igcc.validation.rule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.rn.validation.rule.RSMValidationRule;

public class RSMValidationRuleTest {
	
	private RSMValidationRule rsmValidationRule;

	@Before
	public void setUp() {
		rsmValidationRule = new RSMValidationRule();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSucessesive5Ms() {
		rsmValidationRule.execute("MCMMMMMXLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRuleSucessesive4Ms() {
		rsmValidationRule.execute("MCMMMMXLIV");
	}
	
	@Test
	public void testValidatorRuleValid() {
		rsmValidationRule.execute("MCMXLIV");
	}
	
	@Test
	public void testValidatorRuleValidWithCDM() {
		rsmValidationRule.execute("MCMXLIV");
	}
		
	@Test
	public void testValidatorRuleSucessesive4MsI() {
		rsmValidationRule.execute("MCMMMIMXLIV");
	}
	
	@Test
	public void testValidatorRuleSucessesive4MsV() {
		rsmValidationRule.execute("MCMMMVMXLIV");
	}
	
	@Test
	public void testValidatorRuleSucessesive4MsX() {
		rsmValidationRule.execute("MCMMMXMXLIV");
	}
	
	@Test
	public void testValidatorRuleSucessesive4MsL() {
		rsmValidationRule.execute("MCMMMLMXLIV");
	}
	
	@Test
	public void testValidatorRuleSucessesive4MsC() {
		rsmValidationRule.execute("MCMMMCMXLIV");
	}
	
	@Test
	public void testValidatorRuleSucessesive4MsD() {
		rsmValidationRule.execute("MCMMMDMXLIV");
	}
	
	@After
	public void tearDown() {
		
	}
	
}
