package com.taophys.minesweeper.model;

public class MineModel {
	private int xMines, yMines;

	private static Mine mineArray[][];
	
	public MineModel(){
		newGame();
	}
	
	
	public void newGame(){
		// number of mines in the x and y directions
		xMines = 50;
		yMines = 25;
		double armed = .15;
		
		newMineArray();
		
		// randomizes and "arms" 20% of the mines
		armMines(armed);
		
		// sets the hint numbers around the mines
		setHints();
		
	}


	private void newMineArray() {
		// creates a new mine array with xMines and yMines
			mineArray = new Mine[yMines][xMines];
			// fill array with mines and adds them up
			for (int i = 0; i < yMines; i++) {
				for (int j = 0; j < xMines; j++) {
					mineArray[i][j] = new Mine();
				}
			}
	}
	
	
	// arms 20% of the mines
	public void armMines(double armed) {
		int armedTotal;
		int armedCounter = 0;
		// these are mineArray indices
		int m1, m2;
		
		// total amount of mines to be armed, 10% rounded down
		armedTotal = (int)Math.floor(mineArray.length * mineArray[0].length * armed);
		
		// arms the mines by checking if a random mine is armed
		// and arming it if it is not
		do {
			m1 = (int)Math.floor(Math.random()*mineArray.length);
			m2 = (int)Math.floor(Math.random()*mineArray[0].length);
			
			if(!mineArray[m1][m2].isArmed()) {
				mineArray[m1][m2].setArmed();
				armedCounter++;
			}
		
		}while (armedCounter < armedTotal);
	}

	// this sets the hint numbers around the mines
	public void setHints() {
		for (int i = 0; i < mineArray.length; i++) {
			// check if the mine you are looking at is armed
			for (int j = 0; j < mineArray[0].length; j++) {
				if(mineArray[i][j].isArmed()){
					mineArray[i][j].setHint(-1);
				}else {
					mineArray[i][j].setHint(findNearbyMines(j, i));
				}
			}
		}
	}
	
	// get a hint from an individual mine
	public String getHint(int x, int y) {
		return String.valueOf(mineArray[y][x].getHint());
	}
	
	// finds nearby mines at any point on the array
	private int findNearbyMines(int x, int y) {
		int minesFound = 0;
		int xStart = 0, xFin = 0;
		int yStart = 0, yFin = 0;
		
		// this effectively creates the corners of the "box" around the mine that is looked at
		xStart = (x-1 < 0 ? 0 : x-1);
		xFin = (x+1 > mineArray[0].length - 1 ? mineArray[0].length - 1  : x+1);
		yStart = (y-1 < 0 ? 0 : y-1);
		yFin = (y+1 > mineArray.length - 1 ? mineArray.length - 1: y+1);
		
		// looks through the "box" and counts the armed mines
		for(int i = yStart; i <= yFin; i++){
			for(int j = xStart; j <= xFin; j++){
				if(mineArray[i][j].isArmed()) {
					minesFound++;
				}
			}
		}
		
		return minesFound;
	}
	public int getXMines() {
		return xMines;
	}

	public int getYMines() {
		return yMines;
	}


	public void setStatus(int x, int y, int status) {
		mineArray[y][x].setStatus(status);
	}


	public int getStatus(int x, int y) {
		return mineArray[y][x].getStatus();
	}


}
