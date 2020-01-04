package com.example.demo.sahaj;
import java.util.Scanner;

public class CleanStrikeTedious {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		PlayersUtils players = new Players();
		CarromBoardUtils cleanStrikeBoard = new CarromBoard();
		int playerDetails = 1;
		int score = 0;
		while(true) {
			playerDetails = (playerDetails+1)%2;
			
			if((players.checkPlayerScore((Players) players) && players.scoreDiff((Players) players) >=3) || cleanStrikeBoard.isAllCoinsPocketed((CarromBoard) cleanStrikeBoard)) {
				System.out.println("player-1 moves: "+ ((Players) players).getPlayer1StrikeHistory());
				System.out.println("player-1 score: "+ ((Players) players).getPlayer1Score());
				System.out.println("player-2 moves: "+ ((Players) players).getPlayer2StrikeHistory());
				System.out.println("player-2 score: "+ ((Players) players).getPlayer2Score());
				break;
			}
			
			System.out.println("Choose an option from below..");
			System.out.println("1. Strike");
			System.out.println("2. Multi Strike");
			System.out.println("3. Red strike");
			System.out.println("4. Striker strike");
			System.out.println("5. Defunct coin");
			System.out.println("6. None");
			
			int option = s.nextInt();
			//int option = getInput();
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
		s.close();
	}
	
	 public static boolean validateOption(int n) {
		if(n>=1 && n <=6){
			return true;
		} else {
			return false;
		}
	}
	 
	public static int getInput(int input) {
		return input;
	}
}
