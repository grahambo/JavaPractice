package com.taophys.minesweeper;

import com.taophys.minesweeper.controller.MineController;
import com.taophys.minesweeper.model.MineModel;
import com.taophys.minesweeper.viewer.MineView;

/**
 * Minesweeper game
 * 
 * @author Andrew
 * 
 */
public class Main {
	// Creates the model, view, and controller for the game and then passes them
	// correctly
	// so that there is only one of each.
	public static void main(String[] args) {
		MineModel model = new MineModel();
		MineView view = new MineView(model);
		MineController controller = new MineController(model, view);// BG: You
																	// don't
																	// ever
																	// reference
																	// the
																	// controller
																	// again so
																	// you don't
																	// need to
																	// hold a
																	// reference
																	// to it.

		view.setVisible(true);
	}
	// BG: While playing around with the game, I noticed I don't get any
	// indication of losing outside of it taking me to a screen where I can
	// choose a new game or to exit. Something telling me I lost would be
	// helpful IMO.
}
