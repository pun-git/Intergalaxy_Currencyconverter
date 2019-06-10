package com.tw.igcc.input.operation.impl;

import java.util.Optional;

import com.tw.igcc.api.Operation;
import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.query.executor.api.QueryExecutor;
import com.tw.igcc.query.executor.factory.QueryExecutorFactory;

public class QueryProcessingOperation implements Operation<String, CommandArgs>{
	
	@Override
	public Optional<String> process(CommandArgs commandArgs) {
		QueryExecutor queryExecutor = getQueryExecutor(commandArgs);
		return queryExecutor.execute(commandArgs);
	}
	
	private QueryExecutor getQueryExecutor(CommandArgs commandArgs) {
		return new QueryExecutorFactory().getQueryFactory(commandArgs.getInput());
	}

}
