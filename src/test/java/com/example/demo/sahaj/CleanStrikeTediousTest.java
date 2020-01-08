package com.example.demo.sahaj;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.cleanstrike.CleanStrikeTedious;

public class CleanStrikeTediousTest {
	
	@Test
	public void testInputIsValidOrNot() {
		
		assertEquals(true, CleanStrikeTedious.validateOption(6));
	}
	
	@Test
	public void testGameHasEndedProperlyOrNot() {
		CleanStrikeTedious.main(null);
	}
}
