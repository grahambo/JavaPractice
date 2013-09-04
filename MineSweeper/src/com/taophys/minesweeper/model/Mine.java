package com.taophys.minesweeper.model;

public class Mine {
	// flag for whether the mine is armed or not
	private boolean armed;
	// status = 0 --- unchecked
	// status = 1 --- checked and shown
	// status = 2 --- shown but not checked
	// status = 3 --- user declared mine
	private int status;
	// hint = -1 --- mine is here
	// hint = # --- number of mines around this square
	private int hint;
	
	public Mine() {
		armed = false;
		status = 0;
	}
	
	public boolean isArmed() {
		
		return armed;
	}

	public void setArmed() {
		armed = true;
	}

	public int getStatus(){
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getHint(){
		return hint;
	}
	
	public void setHint(int hint){
		this.hint = hint;
	}
}
