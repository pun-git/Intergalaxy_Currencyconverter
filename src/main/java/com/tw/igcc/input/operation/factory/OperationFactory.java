package com.tw.igcc.input.operation.factory;

import java.util.regex.Pattern;

import com.tw.igcc.api.Operation;
import com.tw.igcc.input.operation.impl.IgcToRnOperation;
import com.tw.igcc.input.operation.impl.MetalToCreditOperation;
import com.tw.igcc.input.operation.impl.QueryProcessingOperation;
import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.OperationType;
import com.tw.igcc.model.Result;

public class OperationFactory {
	
	public static Operation<Result, CommandArgs> getOperation(String input) {
		if(input.indexOf(OperationType.QUERY.getExpr()) > -1) {
			return new QueryProcessingOperation();
		}else if(input.indexOf(OperationType.IGCWITHMETALVsCREDIT.getExpr()) > -1) {
			return new MetalToCreditOperation();
		}else if(Pattern.matches(OperationType.IGCVsRN.getExpr(), input)) {
			return new IgcToRnOperation();
		}		
		throw new UnsupportedOperationException("I have no idea what you are talking about");
	}

}
