package com.tw.igcc.input.operation;

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
import com.tw.igcc.model.Result;
import com.tw.igcc.model.RomanNumber;

public class MetalToCreditOperationTest {
	
	private MetalToCreditOperation metalToCreditOperation;
	private Map<String, IntergalacticUnit> igUnitNameVsIgUnit;
	
	@Before
	public void setUp() {
		metalToCreditOperation = new MetalToCreditOperation();
		igUnitNameVsIgUnit = new ConcurrentHashMap<>();
		buildGalacticUnitVsRomanNumberMap();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMetalWith_GlobGlobUnkownTotal3910Credit() {
		CommandArgs commandArgs = new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, "pish pish Unkown is 3910 Credits");
		metalToCreditOperation.process(commandArgs);
	}
	
	@Test
	public void testMetalWith_GlobGlobSilverTotal37Credit() {
		CommandArgs commandArgs = new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, "glob glob Silver is 39 Credits");
		Optional<Result> optionalMetalCredit =metalToCreditOperation.process(commandArgs);
		assertTrue(optionalMetalCredit.isPresent());
		assertEquals(optionalMetalCredit.get().getMetalCredit().getMetalType(), MetalType.Silver);
		assertEquals(optionalMetalCredit.get().getMetalCredit().getCredits(), 19.5, 0);
	}
	
	@Test
	public void testMetalWith_GlobProkGoldTotal57800Credit() {
		CommandArgs commandArgs = new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, "glob prok Gold is 57800 Credits");
		Optional<Result> optionalMetalCredit =metalToCreditOperation.process(commandArgs);
		assertTrue(optionalMetalCredit.isPresent());
		assertEquals(optionalMetalCredit.get().getMetalCredit().getMetalType(), MetalType.Gold);
		assertEquals(optionalMetalCredit.get().getMetalCredit().getCredits(), 14450.0, 0);
	}
	
	@Test
	public void testMetalWith_GlobGlobIronTotal3910Credit() {
		CommandArgs commandArgs = new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), igUnitNameVsIgUnit, "pish pish Iron is 3910 Credits");
		Optional<Result> optionalMetalCredit =metalToCreditOperation.process(commandArgs);
		assertTrue(optionalMetalCredit.isPresent());
		assertEquals(optionalMetalCredit.get().getMetalCredit().getMetalType(), MetalType.Iron);
		assertEquals(optionalMetalCredit.get().getMetalCredit().getCredits(), 195.5, 0);
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
