package com.example.demo.cleanstrike;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.demo.cleanstrike.Players;

public class PlayersTest {
	
	Players players = new Players();

	@Test
	public void testCheckPlayerScore() {
		assertEquals(false, players.checkPlayerScore(players));
	}
	
	@Test
	public void testCheckPlayer1ScoreGreaterThan5() {
		players.setPlayer1Score(6);
		assertEquals(true, players.checkPlayerScore(players));
	}
	
	@Test
	public void techCheckPlayer2ScoreGreaterThan2() {
		players.setPlayer2Score(7);
		assertEquals(true, players.checkPlayerScore(players));
	}
	
	@Test
	public void testUpdatePlayer1Score() {
		players.updatePlayerScore(1, 1, players);
		assertEquals(1, players.getPlayer1Score());
	}
	
	@Test
	public void testUpdatePlayerScoreForPlayer1WithScore0() {
		players.setPlayer1Score(-2);
		players.updatePlayerScore(1, 1, players);
		assertEquals(0, players.getPlayer1Score());
	}
	
	@Test
	public void testUpdatePlaye2rScore() {
		players.updatePlayerScore(2, 1, players);
		assertEquals(1, players.getPlayer2Score());
	}
	
	@Test
	public void testUpdatePlayerScoreForPlayer2WithScore0() {
		players.setPlayer2Score(-2);
		players.updatePlayerScore(2, 1, players);
		assertEquals(0, players.getPlayer2Score());
	}
	
	@Test
	public void testGetPlayerHistoryForPlayer1() {
		List<String> player1History = players.getPlayer1StrikeHistory();
		player1History.add("NONE");
		players.setPlayer1StrikeHistory(player1History);
		assertEquals(player1History, players.getPlayerHistory(1, players));
	}
	
	@Test
	public void testGetPaylerHistoryOfPlayer2() {
		List<String> playerHistory = players.getPlayer2StrikeHistory();
		playerHistory.add("STRIKE");
		players.setPlayer1StrikeHistory(playerHistory);
		assertEquals(playerHistory, players.getPlayerHistory(2, players));
	}
	
	@Test 
	public void testUpdatePlayerHistoryForPlayer1() {
		List<String> history = new ArrayList<String>();
		history.add("STRIKE");
		players.updatePlayerHistory(players, "STRIKE", 1);
		assertEquals(history, players.getPlayer1StrikeHistory());
	}
	
	@Test 
	public void testUpdatePlayerHistoryForPlayer2() {
		List<String> history = new ArrayList<String>();
		history.add("STRIKE");
		players.updatePlayerHistory(players, "STRIKE", 2);
		assertEquals(history, players.getPlayer2StrikeHistory());
	}
	
	@Test
	public void testEmptyMovesForPlayer1() {
		List<String> history = new ArrayList<String>();
		history.add("STRIKE");
		history.add("NONE");
		history.add("NONE");
		history.add("NONE");
		
		players.setPlayer1Score(1);
		players.setPlayer1StrikeHistory(history);
		players.emptyMoves(players, 1);
		assertEquals(0, players.getPlayer1Score());
	}
	
	@Test
	public void testEmptyMovesForPlayer2() {
		List<String> history = new ArrayList<String>();
		history.add("STRIKE");
		history.add("NONE");
		history.add("NONE");
		history.add("NONE");
		
		players.setPlayer2Score(1);
		players.setPlayer2StrikeHistory(history);
		players.emptyMoves(players, 2);
		assertEquals(0, players.getPlayer2Score());
	}
	
	@Test
	public void testPlayerFoulCountForPlayer1() {
		List<String> history = new ArrayList<String>();
		history.add("STRIKE");
		history.add("DEFUNCT");
		history.add("STRIKERSTRIKE");
		history.add("STRIKERSTRIKE");
		
		players.setPlayer1Score(1);
		players.setPlayer1StrikeHistory(history);
		players.playerFoulCount(players, 1);
		assertEquals(0, players.getPlayer1Score());
	}
	
	@Test
	public void testPlayerFoulCountForPlayer2() {
		List<String> history = new ArrayList<String>();
		history.add("STRIKE");
		history.add("DEFUNCT");
		history.add("STRIKERSTRIKE");
		history.add("STRIKERSTRIKE");
		
		players.setPlayer2Score(1);
		players.setPlayer2StrikeHistory(history);
		players.playerFoulCount(players, 2);
		assertEquals(0, players.getPlayer2Score());
	}
	
	@Test
	public void testScoreDiff() {
		players.setPlayer1Score(5);
		players.setPlayer2Score(2);
		assertEquals(3, players.scoreDiff(players));
	}
}
