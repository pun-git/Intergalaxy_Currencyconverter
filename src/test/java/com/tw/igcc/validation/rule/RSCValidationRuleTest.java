package com.tw.igcc.validation.rule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.rn.validation.rule.RSCValidationRule;

public class RSCValidationRuleTest {
	
	private RSCValidationRule rscValidationRule;
	
	@Before
	public void setUp() {	
		rscValidationRule = new RSCValidationRule();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_Sucessesive5cs() {
		rscValidationRule.execute("MCCCCCCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_Sucessesive4Cs() {
		rscValidationRule.execute("MCCCCCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByD() {
		rscValidationRule.execute("MCCCCDCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByM() {
		rscValidationRule.execute("MCCCCMCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByI() {
		rscValidationRule.execute("MCCCICLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByV() {
		rscValidationRule.execute("MCCCVCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByX() {
		rscValidationRule.execute("MCCCXCLIV");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testValidatorRule_SubtractedByL() {
		rscValidationRule.execute("MCCCLCLIV");
	}
	@Test
	public void testValidatorRule_validaNumber() {
		rscValidationRule.execute("MCMXLIV");
	}
	
	@After
	public void tearDown() {
		
	}


}
