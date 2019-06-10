package com.tw.igcc.query.executor.impl;

import java.util.Optional;

import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.query.executor.api.QueryExecutor;

public class HowMuchQueryExecutorImpl implements QueryExecutor{
	
	@Override
	public Optional<String> execute(CommandArgs commandArgs) {
		return Optional.empty();
	}
}
