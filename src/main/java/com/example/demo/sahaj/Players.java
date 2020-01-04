package com.example.demo.sahaj;
import java.util.ArrayList;
import java.util.List;

public class Players implements PlayersUtils {
	
	private int player1Score;
	private int player2Score;
	private List<String> player1StrikeHistory = new ArrayList<String>();
	private List<String> player2StrikeHistory = new ArrayList<String>();
	
	public Players() {
		
	}
	
	public Players(int player1Score, int player2Score, List<String> player1StrikeHistory,
			List<String> player2StrikeHistory) {
		super();
		this.player1Score = player1Score;
		this.player2Score = player2Score;
		this.player1StrikeHistory = player1StrikeHistory;
		this.player2StrikeHistory = player2StrikeHistory;
	}

	public int getPlayer1Score() {
		return player1Score;
	}

	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}

	public int getPlayer2Score() {
		return player2Score;
	}

	public void setPlayer2Score(int player2Score) {
		this.player2Score = player2Score;
	}

	public List<String> getPlayer1StrikeHistory() {
		return player1StrikeHistory;
	}

	public void setPlayer1StrikeHistory(List<String> player1StrikeHistory) {
		this.player1StrikeHistory = player1StrikeHistory;
	}

	public List<String> getPlayer2StrikeHistory() {
		return player2StrikeHistory;
	}

	public void setPlayer2StrikeHistory(List<String> player2StrikeHistory) {
		this.player2StrikeHistory = player2StrikeHistory;
	}
	
	public boolean checkPlayerScore(Players players) {
		
		if(players.getPlayer1Score() >=5 || players.getPlayer2Score() >=5)
			return true;
		else 
			return false;
	}
	
	public void updatePlayerScore(int playerDetails, int score, Players player) {
		if(playerDetails == 1) {
			player.setPlayer1Score(player.getPlayer1Score()+score);
			
			if(player.getPlayer1Score()<0)
				player.setPlayer1Score(0);
		} else {
			player.setPlayer2Score(player.getPlayer2Score()+score);
			
			if(player.getPlayer2Score()<0)
				player.setPlayer2Score(0);
		}
	}
	
	public List<String> getPlayerHistory(int player, Players playerDetails) {
		if(player==1)
			return playerDetails.getPlayer1StrikeHistory();
		else 
			return playerDetails.getPlayer2StrikeHistory();
	}
	
	public void updatePlayerHistory(Players players, String strikeOutcome, int playerDetails) {
		List<String> playerHistory = null;
		if(playerDetails==1) {
			playerHistory = players.getPlayer1StrikeHistory();
			playerHistory.add(strikeOutcome);
			players.setPlayer1StrikeHistory(playerHistory);
		} else {
			playerHistory = players.getPlayer2StrikeHistory();
			playerHistory.add(strikeOutcome);
			players.setPlayer2StrikeHistory(playerHistory);
		}
	}
	
	public void emptyMoves(Players player, int playerDetails) {
		List<String> playerMoves = null;
		if(playerDetails == 1) {
			playerMoves = player.getPlayer1StrikeHistory();
		} else {
			playerMoves = player.getPlayer2StrikeHistory();
		}
		
		int count =0;
		int j=0;
		for(int i=playerMoves.size()-1;i > 0;i--) {
			if(j>3)
				break;
			if(playerMoves.get(i).equals("NONE"))
				count++;
			j++;
		}
		
		if(count>=3) 
			updatePlayerScore(playerDetails, -1, player);
			
	}
	
	public void playerFoulCount(Players player, int playerDetails) {
		List<String> playerMoves = null;
		if(playerDetails == 1) {
			playerMoves = player.getPlayer1StrikeHistory();
		} else {
			playerMoves = player.getPlayer2StrikeHistory();
		}
		
		int count =0;
		int j=0;
		for(int i=playerMoves.size()-1;i > 0;i--) {
			if(j>3)
				break;
			if(playerMoves.get(i).equals("STRIKERSTRIKE") || playerMoves.get(i).equals("DEFUNCT"))
				count++;
			j++;
			
		}
		
		if(count>=3) 
			updatePlayerScore(playerDetails, -1, player);
	}
	
	public int scoreDiff(Players player) {
		if(player.getPlayer1Score() > player.getPlayer2Score())
			return player.getPlayer1Score()- player.getPlayer2Score();
		else
			return player.getPlayer2Score()-player.getPlayer1Score();
	}
}
