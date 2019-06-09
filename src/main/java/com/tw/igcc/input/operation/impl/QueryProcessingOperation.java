package com.tw.igcc.input.operation.impl;

import java.util.Optional;

import com.tw.igcc.api.Operation;
import com.tw.igcc.model.CommandArgs;

public class QueryProcessingOperation implements Operation<String, CommandArgs>{
	
	@Override
	public Optional<String> process(CommandArgs commandArgs) {
		return null;
	}

}
