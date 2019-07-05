package com.tw.igcc.query.executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.IntergalacticUnit;
import com.tw.igcc.model.MetalCredit;
import com.tw.igcc.model.MetalType;
import com.tw.igcc.model.RomanNumber;
import com.tw.igcc.query.executor.impl.HowMuchQueryExecutorImpl;

public class HowMuchQueryExecutorTest {
	
	private HowMuchQueryExecutorImpl howQueryExecutorImpl;
	private Map<String, IntergalacticUnit> igUnitNameVsIgUnit;
	
	@Before
	public void setUp() {
		howQueryExecutorImpl = new HowMuchQueryExecutorImpl();
		igUnitNameVsIgUnit = new ConcurrentHashMap<>();
		buildGalacticUnitVsRomanNumberMap();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullHowMuchQuery() {
		howQueryExecutorImpl.execute(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBlankHowMuchQuery() {
		howQueryExecutorImpl.execute(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, ""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidHowMuchQuery() {
		howQueryExecutorImpl.execute(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
	}
	
	@Test
	public void testpishtegjglobglob() {
		Optional<String> howMuchResultOptional = howQueryExecutorImpl.execute(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, "how much is pish tegj glob glob ?"));
		assertTrue(howMuchResultOptional.isPresent());
		assertEquals("pish tegj glob glob is 42", howMuchResultOptional.get());
	}
	
	@After
	public void tearDown() {
		
	}
	
	private void buildGalacticUnitVsRomanNumberMap() {
		igUnitNameVsIgUnit.put("glob",new IntergalacticUnit("glob", RomanNumber.create("I")));
		igUnitNameVsIgUnit.put("prok",new IntergalacticUnit("prok", RomanNumber.create("V")));
		igUnitNameVsIgUnit.put("pish",new IntergalacticUnit("pish", RomanNumber.create("X")));
		igUnitNameVsIgUnit.put("tegj",new IntergalacticUnit("tegj", RomanNumber.create("L")));
	}

}
