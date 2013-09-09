package com.taophys.minesweeper.model;

public class Mine {
	// flag for whether the mine is armed or not
	private boolean armed; // BG: Things like status and hint are perfect
							// candidates for creating your own custom enums.
							// Basically, any time you have a finite set of
							// values for something, it's a good indication you
							// should be using an enum.
	// status = 0 --- unchecked
	// status = 1 --- checked and shown
	// status = 2 --- shown but not checked
	// status = 3 --- user declared mine
	private int status;
	// hint = -1 --- mine is here
	// hint = # --- number of mines around this square
	private int hint;

	// BG: As far as style goes, a lot of people prefer to sort their methods
	// alphabetically by name.
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getHint() {
		return hint;
	}

	public void setHint(int hint) {
		this.hint = hint;
	}
}
