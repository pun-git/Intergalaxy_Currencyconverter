package com.tw.igcc.rn.util;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.model.RomanSymbol;

public class RomanNumberUtil {

		public static long convertRomanNumberToDecimal(String romanNumberInSymbol) throws InvalidRomanNumberException{
				
				RomanSymbol[] romanSymbols = getArrayOfRnSymbol(romanNumberInSymbol);
				long romanNumberInDigit = 0;
			
				for(int i=romanSymbols.length-1; i >= 0; i--) {
					int currentRomanSymbolValue = romanSymbols[i].getValue();
					int nextRomanSymbolValue = -1;
					
					if(i >= 1) {
						nextRomanSymbolValue = romanSymbols[i-1].getValue();
					}
					
					if(nextRomanSymbolValue != -1 && currentRomanSymbolValue > nextRomanSymbolValue) {
						romanNumberInDigit += (currentRomanSymbolValue - nextRomanSymbolValue);
						i--;
					}else {
						romanNumberInDigit += currentRomanSymbolValue;
					}
				}
				
				return romanNumberInDigit;
		}
	
		public static RomanSymbol[] getArrayOfRnSymbol(String romanNumberInSymbol) throws InvalidRomanNumberException{
			
			char[] symbolsInRomanNumber = romanNumberInSymbol.toCharArray();
			RomanSymbol[] romanSymbols = new RomanSymbol[symbolsInRomanNumber.length];
		
			for(int i=0; i<symbolsInRomanNumber.length ; i++) {
					romanSymbols[i] = RomanSymbol.valueOf(String.valueOf(symbolsInRomanNumber[i]));
			}
			
			return romanSymbols;
		}
}
