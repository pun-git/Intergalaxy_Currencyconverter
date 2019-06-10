package com.tw.igcc.query.executor.factory;

import com.tw.igcc.query.executor.api.QueryExecutor;
import com.tw.igcc.query.executor.impl.HowManyQueryExecutorImpl;
import com.tw.igcc.query.executor.impl.HowMuchQueryExecutorImpl;

public class QueryExecutorFactory {

	public QueryExecutor getQueryFactory(String input) {
		if(input.indexOf("how much") > -1 && input.lastIndexOf("?") > -1) {
			return new HowMuchQueryExecutorImpl();
		}else if(input.indexOf("how many") > -1 && input.lastIndexOf("?") > -1) {
			return new HowManyQueryExecutorImpl();
		}
		throw new UnsupportedOperationException("I have no idea what you are talking about");
	}
	
}
