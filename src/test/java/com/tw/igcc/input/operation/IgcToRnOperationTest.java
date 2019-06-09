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

public class IgcToRnOperationTest {
	
	private IgcToRnOperation igcToRnOperation;
	
	@Before
	public void setUp() {
		this.igcToRnOperation = new IgcToRnOperation();
	}
	
	@Test(expected = InvalidRomanNumberException.class)
	public void test_CreationOfInvalidIGCForInvalidRomanNumber() {
		igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<>(), new ConcurrentHashMap<>(), "tegj is Q"));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test_CreationOfInvalidIGCForBlank() {
		igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<>(), new ConcurrentHashMap<>(), ""));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test_CreationOfInvalidIGCForNull() {
		igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<>(), new ConcurrentHashMap<>(), null));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test_CreationOfInvalidIGCForNoRN() {
		igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<>(), new ConcurrentHashMap<>(), "glob is "));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void test_CreationOfInvalidIGCForNoIGC() {
		igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<>(), new ConcurrentHashMap<>(), " is I"));
	}
	
	@Test
	public void test_CreationOfValidIGCForglob() {
		Optional<IntergalacticUnit> intergalacticUnitOptional = igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<>(), new ConcurrentHashMap<>(), "glob is I"));
		assertTrue(intergalacticUnitOptional.isPresent());
		assertEquals("glob", intergalacticUnitOptional.get().getUnitName());
		assertEquals("I", intergalacticUnitOptional.get().getRomanNumber().getRomanNumberInSymbol());
	}
	
	@Test
	public void test_CreationOfValidIGCForprok() {
		Optional<IntergalacticUnit> intergalacticUnitOptional = igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<>(), new ConcurrentHashMap<>(), "prok is V"));
		assertTrue(intergalacticUnitOptional.isPresent());
		assertEquals("prok", intergalacticUnitOptional.get().getUnitName());
		assertEquals("V", intergalacticUnitOptional.get().getRomanNumber().getRomanNumberInSymbol());
	}
	
	@Test
	public void test_CreationOfValidIGCForpish() {
		Optional<IntergalacticUnit> intergalacticUnitOptional = igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<>(), new ConcurrentHashMap<>(), "pish is X"));
		assertTrue(intergalacticUnitOptional.isPresent());
		assertEquals("pish", intergalacticUnitOptional.get().getUnitName());
		assertEquals("X", intergalacticUnitOptional.get().getRomanNumber().getRomanNumberInSymbol());
	}
	
	@Test
	public void test_CreationOfValidIGCFortegj() {
		Optional<IntergalacticUnit> intergalacticUnitOptional = igcToRnOperation.process(new CommandArgs(new ConcurrentHashMap<>(), new ConcurrentHashMap<>(), "tegj is L"));
		assertTrue(intergalacticUnitOptional.isPresent());
		assertEquals("tegj", intergalacticUnitOptional.get().getUnitName());
		assertEquals("L", intergalacticUnitOptional.get().getRomanNumber().getRomanNumberInSymbol());
	}
	
	@After
	public void tearDown() {
		
	}

}
