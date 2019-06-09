package com.tw.igcc.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class IntergalacticCurrencyConverter {
	
	public static void main(String[] args) {
		IntergalacticCurrencyConverter igcConverter = new IntergalacticCurrencyConverter();
		try(Scanner scanner = new Scanner(igcConverter.getSource(null))){
			String input = scanner.nextLine();
			
		}catch(IOException e) {
			
		}
	}
	
	private InputStream getSource(File file) throws IOException{
		if(file == null || !file.exists()) {
			return System.in;
		}else {
			return new FileInputStream(file);
		}
	}

}
