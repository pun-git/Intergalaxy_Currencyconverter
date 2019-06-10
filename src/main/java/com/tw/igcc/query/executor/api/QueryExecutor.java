package com.tw.igcc.query.executor.api;

import java.util.Optional;

import com.tw.igcc.model.CommandArgs;

public interface QueryExecutor{

	public Optional<String> execute(CommandArgs commandArgs);
	
}
