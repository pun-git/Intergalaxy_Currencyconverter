package com.tw.igcc.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommandArgs {
	
	private Map<MetalType, MetalCredit> metalVsMetalCredit ;
	private Map<String, IntergalacticUnit> igUnitNameVsIgUnit;
	private String input;
	
	public CommandArgs(Map<MetalType, MetalCredit> metalVsMetalCredit, Map<String, IntergalacticUnit> igUnitNameVsIgUnit, String input) {
		this.metalVsMetalCredit = new ConcurrentHashMap<>(metalVsMetalCredit);
		this.igUnitNameVsIgUnit = new ConcurrentHashMap<>(igUnitNameVsIgUnit);
		this.input = input;
	}
	
	public MetalCredit getMetalVsMetalCredit(MetalType metalType) {
		return metalVsMetalCredit.get(metalType);
	}
	
	public IntergalacticUnit getIgUnitNameVsIgUnit(String igUnit) {
		return igUnitNameVsIgUnit.get(igUnit);
	}
	
	public String getInput() {
		return input;
	}

}
