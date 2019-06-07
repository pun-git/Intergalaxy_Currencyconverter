package com.tw.igcc.model;
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
		String invalidRomanNumber = "IVMQ";
		RomanNumber.create(invalidRomanNumber);
	}
	
	@Test
	public void testRN_WithValidSymbol() throws Exception {
		String validRomanNumber = "MMVI";
		RomanNumber romanNumber = RomanNumber.create(validRomanNumber);
		assertEquals(2006, romanNumber.getRomanNumberInDigit());
	}
	
	@Test
	public void  testRN_WithSmallerPrecedsLargerValueSymbol() throws Exception{
		String validRomanNumber = "MCMXLIV";
		RomanNumber romanNumber = RomanNumber.create(validRomanNumber);
		assertEquals(1944, romanNumber.getRomanNumberInDigit());
	}
	
	@After
	public void tearDown() {
		
	}
	
}
