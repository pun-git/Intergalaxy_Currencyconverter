package com.tw.igcc.query.executor;

import static org.junit.Assert.assertEquals;

import java.util.Map;
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
import com.tw.igcc.query.calculator.HowManyMetalCalculationImpl;

public class HowManyMetalCalculationImplTest {
	
	private HowManyMetalCalculationImpl howManyMetalCalculationImpl;
	private Map<String, IntergalacticUnit> igUnitNameVsIgUnit;
	private Map<MetalType, MetalCredit> metalTypeVsMetalCredit;
	
	@Before
	public void setUp() {
		this.howManyMetalCalculationImpl = new HowManyMetalCalculationImpl();
		igUnitNameVsIgUnit = new ConcurrentHashMap<>();
		metalTypeVsMetalCredit = new ConcurrentHashMap<>();
		buildGalacticUnitVsRomanNumberMap();
		buildMetalTypeVsMetalCredit();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenInputIsBlank() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "");
		howManyMetalCalculationImpl.calculate(commandArgs, "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenInputIsUnkown() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "how many Silver is glob Gold");
		howManyMetalCalculationImpl.calculate(commandArgs, "how many Silver is glob Gold");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenInputMetalTypeIsUnkown() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "how many Iron is glob Gold");		
		howManyMetalCalculationImpl.calculate(commandArgs, "how many Iron is glob Gold");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWhenInputIgUnitIsUnkown() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "how many silver is glob_new Gold");		
		howManyMetalCalculationImpl.calculate(commandArgs, "how many silver is glob_new Gold");
	}
	
	@Test
	public void testWithValidInput() {
		CommandArgs commandArgs = new CommandArgs(metalTypeVsMetalCredit, igUnitNameVsIgUnit, "how many Silver is glob Gold ?");		
		float calculatedResult = howManyMetalCalculationImpl.calculate(commandArgs, "how many Iron is glob Gold ?");
		assertEquals(850.0, calculatedResult, 0);
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
