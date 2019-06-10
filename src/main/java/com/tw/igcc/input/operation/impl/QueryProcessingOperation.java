package com.tw.igcc.input.operation.impl;

import java.util.Optional;

import com.tw.igcc.api.Operation;
import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.Result;
import com.tw.igcc.query.executor.api.QueryExecutor;
import com.tw.igcc.query.executor.factory.QueryExecutorFactory;

public class QueryProcessingOperation implements Operation<Result, CommandArgs>{
	
	@Override
	public Optional<Result> process(CommandArgs commandArgs) {
		QueryExecutor queryExecutor = getQueryExecutor(commandArgs);
		String result = queryExecutor.execute(commandArgs).get();
		return Optional.of(new Result(result));
	}
	
	private QueryExecutor getQueryExecutor(CommandArgs commandArgs) {
		return new QueryExecutorFactory().getQueryFactory(commandArgs.getInput());
	}

}
