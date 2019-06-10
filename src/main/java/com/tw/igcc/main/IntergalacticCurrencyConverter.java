package com.tw.igcc.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.input.operation.CurrencyConversionOperationExecutor;
import com.tw.igcc.input.operation.factory.OperationFactory;

public class IntergalacticCurrencyConverter {
	private static final String EXIT = "exit";
	
	public static void main(String[] args) {
		IntergalacticCurrencyConverter igcConverter = new IntergalacticCurrencyConverter();
		CurrencyConversionOperationExecutor conversionOperationExecutor = new CurrencyConversionOperationExecutor();
		
		try(Scanner scanner = new Scanner(igcConverter.getSource(args))){
				if(!scanner.hasNextLine()) return;
				String input = scanner.nextLine();
				while(!input.equals(EXIT)) {
					try {
						conversionOperationExecutor.execute(OperationFactory.getOperation(input), input);
					}catch (IllegalArgumentException | InvalidRomanNumberException | UnsupportedOperationException e) {
						System.out.println(e.getMessage());
					}
					if(!scanner.hasNextLine()) return;
					input = scanner.nextLine();
				}
		}catch(IOException e) {
				System.out.println(e.getMessage());
		}
	}
	
	private InputStream getSource(String[] args) throws IOException{
		if(args == null || args.length < 1 || args[0] == null || !new File(args[0]).exists()) {
			return System.in;
		}else {
			return new FileInputStream(args[0]);
		}
	}

}
