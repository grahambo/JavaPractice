package com.taophys.minesweeper.viewer;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class MineButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1765871544165575198L;

	public MineButton(int x, int y){
		super();
		
		setX(x);
		setY(y);
		
		Font font = new Font("Arial Unicode MS", Font.PLAIN, 18);
		setFont(font);
		setText("X");
		setBorder(null);
		setPreferredSize(new Dimension(30,30));
	}
	
	private void setX(int x){
	}
	
	private void setY(int y){
	}
}
