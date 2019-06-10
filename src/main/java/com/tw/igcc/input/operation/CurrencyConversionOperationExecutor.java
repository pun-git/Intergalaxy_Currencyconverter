package com.tw.igcc.input.operation;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.tw.igcc.api.Operation;
import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.IntergalacticUnit;
import com.tw.igcc.model.MetalCredit;
import com.tw.igcc.model.MetalType;
import com.tw.igcc.model.Result;

public class CurrencyConversionOperationExecutor {
	
	private Map<MetalType, MetalCredit> metalVsMetalCredit = new ConcurrentHashMap<>();
	private Map<String, IntergalacticUnit> igUnitNameVsIgUnit = new ConcurrentHashMap<>();
	
	
	public void execute(Operation<Result, CommandArgs> operation, String input) {
		Optional<Result> result = operation.process(new CommandArgs(new ConcurrentHashMap<>(metalVsMetalCredit), new ConcurrentHashMap<>(igUnitNameVsIgUnit), input));
		processResult(result);
	}
	
	private void processResult(Optional<Result> result) {
		if(result.get().getIntergalacticUnit() != null) {
			igUnitNameVsIgUnit.put(result.get().getIntergalacticUnit().getUnitName(), result.get().getIntergalacticUnit());
		}else if(result.get().getMetalCredit() != null) {
			metalVsMetalCredit.put(result.get().getMetalCredit().getMetalType(), result.get().getMetalCredit());
		}else {
			System.out.println(result.get().getOutput());
		}
	}

}
