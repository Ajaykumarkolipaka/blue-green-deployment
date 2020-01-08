package com.example.demo.cleanstrike;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.cleanstrike.CarromBoard;

public class CarromBoardTest {
	CarromBoard cleanStrikeBoard = new CarromBoard();
	
	@Test
	public void testStrikingOfBlack() {
		assertEquals(1, cleanStrikeBoard.strike(cleanStrikeBoard));
	}
	
	@Test
	public void testStrikeWhenNoBlackCoins() {
		cleanStrikeBoard.setBlack(0);
		assertEquals(0, cleanStrikeBoard.strike(cleanStrikeBoard));
	}
	
	@Test
	public void testMultiStrike() {
		assertEquals(2, cleanStrikeBoard.multiStike(cleanStrikeBoard));
		assertEquals(7, cleanStrikeBoard.getBlack());
		assertEquals(1, cleanStrikeBoard.getRed());
	}
	
	@Test
	public void testMultiStrikeWithNoBlackCoins() {
		cleanStrikeBoard.setBlack(0);
		assertEquals(0, cleanStrikeBoard.multiStike(cleanStrikeBoard));
	}
	
	@Test
	public void testRedStrike() {
		assertEquals(3, cleanStrikeBoard.redStrike(cleanStrikeBoard));
		assertEquals(0, cleanStrikeBoard.getRed());
	}
	
	@Test
	public void testRedStrikeWithNoRedCoinsOnBoard() {
		cleanStrikeBoard.setRed(0);
		assertEquals(0, cleanStrikeBoard.redStrike(cleanStrikeBoard));
	}
	
	@Test
	public void foulByPocketingStriker() {
		assertEquals(-1, cleanStrikeBoard.striker(cleanStrikeBoard));
	}
	
	@Test
	public void foulByDefunt() {
		int expectedNoOfCoins = cleanStrikeBoard.getBlack()-1;
		assertEquals(-2, cleanStrikeBoard.defunt(cleanStrikeBoard));
		assertEquals(expectedNoOfCoins, cleanStrikeBoard.getBlack());
	}
	
	@Test
	public void testDefuntWithNoCoins() {
		cleanStrikeBoard.setBlack(0);
		assertEquals(0, cleanStrikeBoard.defunt(cleanStrikeBoard));
	}
	
	@Test
	public void emptyStike() {
		assertEquals(0, cleanStrikeBoard.emptyStrike());
	}
	
	@Test
	public void allCoinsArePocketed() {
		assertEquals(false, cleanStrikeBoard.isAllCoinsPocketed(cleanStrikeBoard));
	}
	
	@Test
	public void isAllCoinsPocketed() {
		cleanStrikeBoard.setBlack(0);
		cleanStrikeBoard.setRed(0);
		assertEquals(true, cleanStrikeBoard.isAllCoinsPocketed(cleanStrikeBoard));
	}
}
