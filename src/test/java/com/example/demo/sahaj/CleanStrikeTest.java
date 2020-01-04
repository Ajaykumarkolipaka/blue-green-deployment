package com.example.demo.sahaj;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CleanStrikeTest {
	
	@Test
	public void testInputIsValidOrNot() {
		
		assertEquals(true, CleanStrike.validateOption(6));
	}
	
	@Test
	public void testGameHasEndedProperlyOrNot() {
		CleanStrike.main(null);
	}
}
