package com.tw.igcc.input.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tw.igcc.exception.InvalidRomanNumberException;
import com.tw.igcc.input.operation.impl.IgcToRnOperation;
import com.tw.igcc.model.CommandArgs;
import com.tw.igcc.model.IntergalacticUnit;
import com.tw.igcc.model.MetalCredit;
import com.tw.igcc.model.MetalType;
import com.tw.igcc.model.Result;

public class IgcToRnOperationTest {
	
	private IgcToRnOperation igcToRnOperation;
	
	@Before
	public void setUp() {
		this.igcToRnOperation = new IgcToRnOperation();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void test_CreationOfInvalidIGCForInvalidRomanNumber() {
		igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), new ConcurrentHashMap<String, IntergalacticUnit>(), "tegj is Q"));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test_CreationOfInvalidIGCForBlank() {
		igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), new ConcurrentHashMap<String, IntergalacticUnit>(), ""));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test_CreationOfInvalidIGCForNull() {
		igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), new ConcurrentHashMap<String, IntergalacticUnit>(), null));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test_CreationOfInvalidIGCForNoRN() {
		igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), new ConcurrentHashMap<String, IntergalacticUnit>(), "glob is "));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test_CreationOfInvalidIGCForNoIGC() {
		igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), new ConcurrentHashMap<String, IntergalacticUnit>(), " is I"));
	}
	
	@Test
	public void test_CreationOfValidIGCForglob() {
		Optional<Result> intergalacticUnitOptional = igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), new ConcurrentHashMap<String, IntergalacticUnit>(), "glob is I"));
		assertTrue(intergalacticUnitOptional.isPresent());
		assertEquals("glob", intergalacticUnitOptional.get().getIntergalacticUnit().getUnitName());
		assertEquals("I", intergalacticUnitOptional.get().getIntergalacticUnit().getRomanNumber().getRomanNumberInSymbol());
	}
	
	@Test
	public void test_CreationOfValidIGCForprok() {
		Optional<Result> intergalacticUnitOptional = igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), new ConcurrentHashMap<String, IntergalacticUnit>(), "prok is V"));
		assertTrue(intergalacticUnitOptional.isPresent());
		assertEquals("prok", intergalacticUnitOptional.get().getIntergalacticUnit().getUnitName());
		assertEquals("V", intergalacticUnitOptional.get().getIntergalacticUnit().getRomanNumber().getRomanNumberInSymbol());
	}
	
	@Test
	public void test_CreationOfValidIGCForpish() {
		Optional<Result> intergalacticUnitOptional = igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), new ConcurrentHashMap<String, IntergalacticUnit>(), "pish is X"));
		assertTrue(intergalacticUnitOptional.isPresent());
		assertEquals("pish", intergalacticUnitOptional.get().getIntergalacticUnit().getUnitName());
		assertEquals("X", intergalacticUnitOptional.get().getIntergalacticUnit().getRomanNumber().getRomanNumberInSymbol());
	}
	
	@Test
	public void test_CreationOfValidIGCFortegj() {
		Optional<Result> intergalacticUnitOptional = igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<MetalType, MetalCredit>(), new ConcurrentHashMap<String, IntergalacticUnit>(), "tegj is L"));
		assertTrue(intergalacticUnitOptional.isPresent());
		assertEquals("tegj", intergalacticUnitOptional.get().getIntergalacticUnit().getUnitName());
		assertEquals("L", intergalacticUnitOptional.get().getIntergalacticUnit().getRomanNumber().getRomanNumberInSymbol());
	}
	
	@After
	public void tearDown() {
		
	}

}
