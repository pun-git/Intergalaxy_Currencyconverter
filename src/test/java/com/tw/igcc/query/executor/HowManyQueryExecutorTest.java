package com.tw.igcc.query.executor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.input.operation.impl.MetalToCreditOperation;
import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.IntergalacticUnit;
import com.tw.igcc.model.MetalCredit;
import com.tw.igcc.model.MetalType;
import com.tw.igcc.model.RomanNumber;
import com.tw.igcc.query.executor.impl.HowManyQueryExecutorImpl;

public class HowManyQueryExecutorTest {
	
	private HowManyQueryExecutorImpl howManyQueryExecutor;
	private Map<String, IntergalacticUnit> igUnitNameVsIgUnit;
	private Map<MetalType, MetalCredit> metalTypeVsMetalCredit;
	
	@Before
	public void setUp() {
		howManyQueryExecutor = new HowManyQueryExecutorImpl();
		igUnitNameVsIgUnit = new ConcurrentHashMap<>();
		metalTypeVsMetalCredit = new ConcurrentHashMap<>();
		buildGalacticUnitVsRomanNumberMap();
		buildMetalTypeVsMetalCredit();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testHowManyNullQuery() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, null);
		howManyQueryExecutor.execute(commandArgs);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHowManyBlankQuery() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "");
		howManyQueryExecutor.execute(commandArgs);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testHowManyInvalidQuery() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "?");
		howManyQueryExecutor.execute(commandArgs);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHowManyGritProkSilver() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "how many Credits is grit prok Silver ?");
		howManyQueryExecutor.execute(commandArgs);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHowManyGlobProkWood() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "how many Credits is glob prok Wood ?");
		howManyQueryExecutor.execute(commandArgs);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testHowManyNoCurrency() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "how many Credits is Wood ?");
		howManyQueryExecutor.execute(commandArgs);
	}
	
	@Test
	public void testHowManyGlobProkSilver() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "how many Credits is glob prok Silver ?");
		Optional<String> result = howManyQueryExecutor.execute(commandArgs);
		assertTrue(result.isPresent());
		assertEquals("glob prok Silver is 68 Credits", result.get());
	}
	
	@Test
	public void testHowManyGlobProkGold() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "how many Credits is glob prok Gold ?");
		Optional<String> result = howManyQueryExecutor.execute(commandArgs);
		assertTrue(result.isPresent());
		assertEquals("glob prok Gold is 57800 Credits", result.get());
	}
	
	@Test
	public void testHowManyGlobProkIron() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "how many Credits is glob prok Iron ?");
		Optional<String> result = howManyQueryExecutor.execute(commandArgs);
		assertTrue(result.isPresent());
		assertEquals("glob prok Iron is 782 Credits", result.get());
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
	
	private void buildMetalTypeVsMetalCredit() {
		metalTypeVsMetalCredit.put(MetalType.Gold, new MetalToCreditOperation().process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, "glob prok Gold is 57800 Credits")).get().getMetalCredit());
		metalTypeVsMetalCredit.put(MetalType.Silver, new MetalToCreditOperation().process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, "glob glob Silver is 34 Credits")).get().getMetalCredit());
		metalTypeVsMetalCredit.put(MetalType.Iron, new MetalToCreditOperation().process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, "pish pish Iron is 3910 Credits")).get().getMetalCredit());
	}
}
