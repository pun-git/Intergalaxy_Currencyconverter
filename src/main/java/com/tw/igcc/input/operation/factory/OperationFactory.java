package com.tw.igcc.input.operation.factory;

import com.tw.igcc.api.Operation;
import com.tw.igcc.input.operation.impl.IgcToRnOperation;
import com.tw.igcc.input.operation.impl.MetalToCreditOperation;
import com.tw.igcc.input.operation.impl.QueryProcessingOperation;
import com.tw.igcc.model.OperationType;

public class OperationFactory {
	
	
	public Operation<?,?> getOperation(String input) {
		if(input.indexOf(OperationType.QUERY.getExpr()) > -1) {
			return new QueryProcessingOperation();
		}else if(input.indexOf(OperationType.IGCVsRN.getExpr()) > -1) {
			return new IgcToRnOperation();
		}else if(input.indexOf(OperationType.IGCWITHMETALVsCREDIT.getExpr()) > -1) {
			return new MetalToCreditOperation();
		}		
		throw new UnsupportedOperationException("I have no idea what you are talking about");
	}

}
