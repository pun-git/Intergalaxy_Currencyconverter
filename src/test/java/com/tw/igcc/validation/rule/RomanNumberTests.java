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
	public void testRNWithNullSymbol() throws Exception {
		RomanNumber.create(null);
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRNWithInvalidSymbol() throws Exception {
		RomanNumber.create("IVMQ");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRNWithDRepreatedMorethanOne() throws Exception{
		RomanNumber.create("IDDM");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRNWithLRepreatedMorethanOne() throws Exception{
		RomanNumber.create("ILLM");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRNWithVRepreatedMorethanOne() throws Exception{
		RomanNumber.create("ILLM");
	}
	
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRNWithIRepreatedMorethanThreeInSuccession() throws Exception{
		RomanNumber.create("IIIILLM");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRNWithXRepreatedMorethanThreeInSuccession() throws Exception{
		RomanNumber.create("XXXXLLM");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRNWithCRepreatedMorethanThreeInSuccession() throws Exception{
		RomanNumber.create("ICCCCLM");
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void testRNWithMRepreatedMorethanThreeInSuccession() throws Exception{
		RomanNumber.create("ILLMMMM");
	}
	
	@Test
	public void testRNWithValidSymbol() throws Exception {
		String validRomanNumber = "MMVI";
		RomanNumber romanNumber = RomanNumber.create(validRomanNumber);
		assertEquals(2006, romanNumber.getRomanNumberInDigit());
	}
	
	@Test
	public void  testRNWithSmallerPrecedsLargerValueSymbol() throws Exception{
		String validRomanNumber = "MCMXIV";
		RomanNumber romanNumber = RomanNumber.create(validRomanNumber);
		assertEquals(1914, romanNumber.getRomanNumberInDigit());
	}
	
	@After
	public void tearDown() {
		
	}
	
}
