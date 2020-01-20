package com.example.demo.cleanstrike;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.example.demo.cleanstrike.CleanStrikeMain;

public class CleanStrikeMainTest {

	@Test
	public void startGame() {
		int noOfPlayers = 3;
		List<Integer> player1Moves = new ArrayList<Integer>();
		List<Integer> player2Moves = new ArrayList<Integer>();
		List<Integer> player3Moves  = new ArrayList<Integer>();
		player1Moves.addAll(Arrays.asList(1, 2, 3, 4, 5));
		player2Moves.addAll(Arrays.asList(1, 2, 3, 4, 5));
		player3Moves.addAll(Arrays.asList(1, 2, 3, 4, 5));
		
		CleanStrikeMain cleanStrikeMain = new CleanStrikeMain();
		cleanStrikeMain.startGame(player1Moves, player2Moves);
	}
}
