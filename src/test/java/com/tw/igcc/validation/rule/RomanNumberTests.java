package com.tw.igcc.validation.rule;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.model.RomanNumber;

public class RomanNumberTests {
	
	@Before
	public void setUp() {
		
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRN_WithNullSymbol() throws Exception {
		RomanNumber.create(null);
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRN_WithInvalidSymbol() throws Exception {
		RomanNumber.create("IVMQ");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRN_WithDRepreatedMorethanOne() throws Exception{
		RomanNumber.create("IDDM");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRN_WithLRepreatedMorethanOne() throws Exception{
		RomanNumber.create("ILLM");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRN_WithVRepreatedMorethanOne() throws Exception{
		RomanNumber.create("ILLM");
	}
	
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRN_WithIRepreatedMorethanThreeInSuccession() throws Exception{
		RomanNumber.create("IIIILLM");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRN_WithXRepreatedMorethanThreeInSuccession() throws Exception{
		RomanNumber.create("XXXXLLM");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRN_WithCRepreatedMorethanThreeInSuccession() throws Exception{
		RomanNumber.create("ICCCCLM");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRN_WithMRepreatedMorethanThreeInSuccession() throws Exception{
		RomanNumber.create("ILLMMMM");
	}
	
	@Test
	public void testRN_WithValidSymbol() throws Exception {
		String validRomanNumber = "MMVI";
		RomanNumber romanNumber = RomanNumber.create(validRomanNumber);
		assertEquals(2006, romanNumber.getRomanNumberInDigit());
	}
	
	@Test
	public void  testRN_WithSmallerPrecedsLargerValueSymbol() throws Exception{
		String validRomanNumber = "MCMXIV";
		RomanNumber romanNumber = RomanNumber.create(validRomanNumber);
		assertEquals(1914, romanNumber.getRomanNumberInDigit());
	}
	
	@After
	public void tearDown() {
		
	}
	
}
