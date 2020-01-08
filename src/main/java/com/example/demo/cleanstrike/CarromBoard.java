package com.example.demo.cleanstrike;

import lombok.Data;

@Data
public class CarromBoard implements CarromBoardUtils {
	
	private int black;
	private int red;
	
	public CarromBoard() {
		this.black=9;
		this.red=1;
	}
	
	public int strike(CarromBoard cleanStrikeBoard) {
		if (cleanStrikeBoard.getBlack() == 0)
			return 0;
		else {
			cleanStrikeBoard.setBlack(cleanStrikeBoard.getBlack() - 1);
			return 1;
		}

	}

	public int multiStike(CarromBoard cleanStrikeBoard) {
		if (cleanStrikeBoard.getBlack() == 0)
			return 0;
		else {
			cleanStrikeBoard.setBlack(7); /* need to check to reduce no.of black coins by 2 or else hard code by 7 , need clarity on(All, but 2
			coins, that were pocketed, get back on to the carrom-board)*/
			cleanStrikeBoard.setRed(1);
			return 2;
		}
	}

	public int redStrike(CarromBoard cleanStrikeBoard) {
		if (cleanStrikeBoard.getRed() == 0) {
			return 0;
		} else {
			cleanStrikeBoard.setRed(cleanStrikeBoard.getRed() - 1);
			return 3;
		}
	}

	public int striker(CarromBoard cleanStrikeBoard) {
		return -1;
	}

	public int defunt(CarromBoard cleanStrikeBoard) {
		if (cleanStrikeBoard.getBlack() == 0)
			return 0;
		else {
			cleanStrikeBoard.setBlack(cleanStrikeBoard.getBlack() - 1);
			return -2;
		}
	}
	
	public int emptyStrike() {
		return 0;
	}
	
	public boolean isAllCoinsPocketed(CarromBoard cleanStrikeBoard) {
		if(cleanStrikeBoard.getBlack()==0 && cleanStrikeBoard.getRed()==0)
			return true;
		else 
			return false;
	}

}
