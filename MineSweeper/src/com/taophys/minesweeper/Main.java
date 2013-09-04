package com.taophys.minesweeper;

import com.taophys.minesweeper.controller.MineController;
import com.taophys.minesweeper.model.MineModel;
import com.taophys.minesweeper.viewer.MineView;

/**
 * Minesweeper game
 * @author Andrew
 *
 */
public class Main {
	// Creates the model, view, and controller for the game and then passes them correctly
	// so that there is only one of each.
	public static void main(String[] args) {
		MineModel model = new MineModel();
		MineView view = new MineView(model);
		MineController controller = new MineController(model, view);
		
		view.setVisible(true);
	}

}
