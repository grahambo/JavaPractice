package com.taophys.minesweeper.viewer;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.taophys.minesweeper.model.MineModel;

public class MineView extends JFrame {
	private static final long serialVersionUID = -6236037558417707514L;
	// This is the array of buttons that corresponds to the mines in the model
	// indices should be exactly the same
	private static MineButton[][] mineButtons;
	private JButton newGame;
	private JButton exitGame;

	private int xMines, yMines;
	private static JPanel gridPanel;
	private static JPanel losePanel;

	private MineModel model;

	public MineView(MineModel model) {
		super();

		this.model = model;

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// get the grid dimensions from the model
		setXMines(model.getXMines());
		setYMines(model.getYMines());

		setupGrid();
		setupLosePanel();
		add(gridPanel);

		pack();

		setVisible(true);

	}

	public void setupLosePanel() {
		// set up losePanel
		losePanel = new JPanel();
		// set up vertical layout
		BoxLayout loseLayout = new BoxLayout(losePanel, BoxLayout.Y_AXIS);
		losePanel.setLayout(loseLayout);
		// add buttons
		newGame = new JButton("New Game");
		exitGame = new JButton("Exit Game");
		losePanel.add(newGame);
		losePanel.add(exitGame);
	}

	public void setupGrid() {
		gridPanel = new JPanel();
		gridPanel.setBounds(0, 0, xMines * 32, yMines * 32);

		// set up the grid layout
		GridLayout grid = new GridLayout(yMines, xMines);
		grid.setHgap(4);
		grid.setVgap(4);
		gridPanel.setLayout(grid);

		mineButtons = new MineButton[yMines][xMines];

		// add in the mine buttons
		for (int i = 0; i < yMines; i++) {
			for (int j = 0; j < xMines; j++) {
				mineButtons[i][j] = new MineButton(j, i);
				gridPanel.add(mineButtons[i][j]);
			}
		}

	}

	public void resetGrid() {
		for (int i = 0; i < yMines; i++) {
			for (int j = 0; j < xMines; j++) {
				mineButtons[i][j].setText("X");
				mineButtons[i][j].setBackground(null);
				;
				mineButtons[i][j].setForeground(Color.BLACK);
			}
		}
	}

	public MineButton[][] getMineButtons() {
		return mineButtons;
	}

	public int getYMines() {
		return yMines;
	}

	private void setYMines(int yMines) {
		this.yMines = yMines;
	}

	public int getXMines() {
		return xMines;
	}

	private void setXMines(int xMines) {
		this.xMines = xMines;
	}

	public JButton getNewGame() {
		return newGame;
	}

	public JButton getExitGame() {
		return exitGame;
	}

	public JPanel getLosePanel() {
		return losePanel;
	}

	// remove the grid and show the losePanel
	public void loseGame() {
		add(losePanel);
		losePanel.setVisible(true);
		gridPanel.setVisible(false);
		remove(gridPanel);
	}

	public void newGame() {
		losePanel.setVisible(false);
		remove(losePanel);
		add(gridPanel);
		gridPanel.setVisible(true);
	}

	public void exitGame() {
		System.exit(0);
	}

	// gets the color of a specific mine
	public Color getMineColor(int x, int y, String hint) { // BG: I'm guessing
															// your project is
															// written targeting
															// Java 1.7 as the
															// version of
															// eclipse I'm using
															// (targeting 1.6)
															// is telling me
															// this isn't
															// allowed. We
															// usually try to
															// avoid switches
															// like this as they
															// tend to get
															// difficult to deal
															// with as they get
															// large. I'd
															// probably put
															// these into an
															// immutable map
															// <int,Color>. That
															// bring up another
															// point: You really
															// shouldn't be
															// passing around
															// Strings when
															// things are
															// actually numbers.
															// It kills your
															// type safety.
															// Normally, you
															// want to convert
															// from a String to
															// the proper type
															// as early (close
															// to the UI/Web as
															// possible).
		Integer hintInt;
		try {
			hintInt = Integer.valueOf(hint);
		} catch (NumberFormatException nfe) {
			return Color.GRAY;
		}
		switch (hintInt) {
		case 0:
			return Color.GRAY;
		case 1:
			return Color.BLUE;
		case 2:
			return Color.RED;
		case 3:
			return Color.GREEN;
		case 4:
			return Color.YELLOW;
		case 5:
			return Color.MAGENTA;
		case 6:
			return Color.ORANGE;
		case 7:
			return Color.PINK;
		case 8:
			return Color.BLACK;
		default:
			return Color.GRAY;
		}
	}

	// this shows every box around a zero
	// only use this function on a zero button
	public void showZeroes(int x, int y) {
		int xStart = 0, xFin = 0;
		int yStart = 0, yFin = 0;

		// this effectively creates the corners of the "box" around the mine
		// that is looked at
		xStart = (x - 1 < 0 ? 0 : x - 1);
		xFin = (x + 1 > mineButtons[0].length - 1 ? mineButtons[0].length - 1
				: x + 1);
		yStart = (y - 1 < 0 ? 0 : y - 1);
		yFin = (y + 1 > mineButtons.length - 1 ? mineButtons.length - 1 : y + 1);

		// looks through the "box" and displays all items.
		for (int i = yStart; i <= yFin; i++) {
			for (int j = xStart; j <= xFin; j++) {
				if ((i != y || j != x) && model.getStatus(j, i) != 3) {
					mineButtons[i][j].setBackground(getMineColor(j, i,
							model.getHint(j, i)));
					mineButtons[i][j].setForeground(Color.WHITE);
					mineButtons[i][j].setText(model.getHint(j, i));
					if (model.getStatus(j, i) != 1) {
						model.setStatus(j, i, 2);
					}
				}
			}
		}
		// looks through "box", for every zero, displays all items in a new box
		// around it.
		// ///// recursive ////////
		for (int i = yStart; i <= yFin; i++) {
			for (int j = xStart; j <= xFin; j++) {
				if (model.getHint(j, i).equals("0")
						&& model.getStatus(j, i) != 1
						&& model.getStatus(j, i) != 3) {
					model.setStatus(j, i, 1);
					showZeroes(j, i);
				}
			}
		}
	}
}
