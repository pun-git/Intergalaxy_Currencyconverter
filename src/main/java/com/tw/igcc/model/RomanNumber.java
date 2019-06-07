package com.tw.igcc.model;

import com.tw.igcc.exception.InvalidRomanNumberException;

public class RomanNumber {
	
	private RomanSymbol[] romanSymbols;
	
	private long romanNumberInDigit;

	private RomanNumber() {}
	
	public static RomanNumber create(String romanNumberInSymbol) throws InvalidRomanNumberException {
		
		RomanNumber romanNumber = new RomanNumber();
		return romanNumber;
	}
	
	private long buildRomanNumberInDigit() {
		return 0;
	}
	
	public long getRomanNumberInDigit() {
		return romanNumberInDigit;
	}
	
	enum RomanSymbol{
		I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
		
		private int value;
		
		private RomanSymbol(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
	}

}
