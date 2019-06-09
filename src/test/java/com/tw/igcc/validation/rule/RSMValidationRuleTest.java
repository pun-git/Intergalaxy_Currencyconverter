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
	public void testValidatorRule_Sucessesive5Ms() {
		rsmValidationRule.execute("MCMMMMMXLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_Sucessesive4Ms() {
		rsmValidationRule.execute("MCMMMMXLIV");
	}
	
	@Test
	public void testValidatorRule_Valid() {
		rsmValidationRule.execute("MCMXLIV");
	}
	
	@Test
	public void testValidatorRule_ValidWithCDM() {
		rsmValidationRule.execute("MCMXLIV");
	}
		
	@Test
	public void testValidatorRule_Sucessesive4MsI() {
		rsmValidationRule.execute("MCMMMIMXLIV");
	}
	
	@Test
	public void testValidatorRule_Sucessesive4MsV() {
		rsmValidationRule.execute("MCMMMVMXLIV");
	}
	
	@Test
	public void testValidatorRule_Sucessesive4MsX() {
		rsmValidationRule.execute("MCMMMXMXLIV");
	}
	
	@Test
	public void testValidatorRule_Sucessesive4MsL() {
		rsmValidationRule.execute("MCMMMLMXLIV");
	}
	
	@Test
	public void testValidatorRule_Sucessesive4MsC() {
		rsmValidationRule.execute("MCMMMCMXLIV");
	}
	
	@Test
	public void testValidatorRule_Sucessesive4MsD() {
		rsmValidationRule.execute("MCMMMDMXLIV");
	}
	
	@After
	public void tearDown() {
		
	}
	
}
