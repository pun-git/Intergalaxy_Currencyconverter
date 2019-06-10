package com.tw.icc.query.executor.factory;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.query.executor.factory.QueryExecutorFactory;
import com.tw.igcc.query.executor.impl.HowManyQueryExecutorImpl;
import com.tw.igcc.query.executor.impl.HowMuchQueryExecutorImpl;

public class QueryExecutorFactoryTest {
	
	private QueryExecutorFactory queryExecutorFactory;
	
	@Before
	public void setUp() {
		queryExecutorFactory = new QueryExecutorFactory();
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test_UnknownProcessor() {
		assertTrue(queryExecutorFactory.getQueryFactory(" is pish tegj glob glob ?") instanceof HowMuchQueryExecutorImpl);
	}
	
	@Test
	public void test_HowMuchFactoryProcessor() {
		assertTrue(queryExecutorFactory.getQueryFactory("how much is pish tegj glob glob ?") instanceof HowMuchQueryExecutorImpl);
	}
	
	@Test
	public void test_HowManyFactoryProcessor() {
		assertTrue(queryExecutorFactory.getQueryFactory("how many Credits is glob prok Silver ?") instanceof HowManyQueryExecutorImpl);
	}
	
	@After
	public void tearDown() {
		
	}

}
