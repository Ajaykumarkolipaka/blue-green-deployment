package com.example.demo.sahaj;

import java.util.List;

public class CleanStrikeMain {
	
	public void startGame(List<Integer> player1Moves, List<Integer> player2Moves) {
		PlayersUtils players = new Players();
		CarromBoardUtils cleanStrikeBoard = new CarromBoard();
		int playerDetails = 1;
		int score = 0;
		
		int i=0,j=0;
	    
		while(true) {
			playerDetails = (playerDetails+1)%2;
			
			if((players.checkPlayerScore((Players) players) && players.scoreDiff((Players) players) >=3) || cleanStrikeBoard.isAllCoinsPocketed((CarromBoard) cleanStrikeBoard)) {
				System.out.println("player-1 moves: "+ ((Players) players).getPlayer1StrikeHistory());
				System.out.println("player-1 score: "+ ((Players) players).getPlayer1Score());
				System.out.println("player-2 moves: "+ ((Players) players).getPlayer2StrikeHistory());
				System.out.println("player-2 score: "+ ((Players) players).getPlayer2Score());
				break;
			}
			int option = 6;
			if(playerDetails+1 == 1) {
				option = player1Moves.get(i);
				i++;
			} else {
				option = player2Moves.get(j);
				j++;
			}
				
			if(!validateOption(option)) {
				System.out.println("choose proper option from the list...");
				continue;
			}
			
			if(option==1) {
				score = cleanStrikeBoard.strike((CarromBoard) cleanStrikeBoard);
				players.updatePlayerScore(playerDetails+1, score, (Players) players);
				players.updatePlayerHistory((Players) players, "STRIKE", playerDetails+1);
			} else if (option == 2) {
				score = cleanStrikeBoard.multiStike((CarromBoard) cleanStrikeBoard);
				players.updatePlayerScore(playerDetails+1, score, (Players) players);
				players.updatePlayerHistory((Players) players, "MULTISTRIKE", playerDetails+1);
			} else if (option == 3) {
				score = cleanStrikeBoard.redStrike((CarromBoard) cleanStrikeBoard);
				players.updatePlayerScore(playerDetails+1, score, (Players) players);
				players.updatePlayerHistory((Players) players, "REDSTRIKE", playerDetails+1);
			} else if (option == 4) {
				score = cleanStrikeBoard.striker((CarromBoard) cleanStrikeBoard);
				players.updatePlayerScore(playerDetails+1, score, (Players) players);
				players.updatePlayerHistory((Players) players, "STRIKERSTRIKE", playerDetails+1);
				players.playerFoulCount((Players) players, playerDetails +1);
			} else if (option == 5) {
				score = cleanStrikeBoard.defunt((CarromBoard) cleanStrikeBoard);
				players.updatePlayerScore(playerDetails+1, score, (Players) players);
				players.updatePlayerHistory((Players) players, "DEFUNCT", playerDetails+1);
				players.playerFoulCount((Players) players, playerDetails +1);
			} else if (option == 6) {
				score = cleanStrikeBoard.emptyStrike();
				players.updatePlayerScore(playerDetails+1, score, (Players) players);
				players.updatePlayerHistory((Players) players, "NONE", playerDetails+1);
			}
		}
	}
	
	public boolean validateOption(int n) {
		if(n>=1 && n <=6){
			return true;
		} else {
			return false;
		}
	}
}
