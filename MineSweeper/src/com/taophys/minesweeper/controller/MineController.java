package com.taophys.minesweeper.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import com.taophys.minesweeper.model.MineModel;
import com.taophys.minesweeper.viewer.MineView;

public class MineController {
	private MineModel model;
	private MineView view;
	
	public MineController(MineModel model, MineView view) {
		this.model = model;
		this.view = view;
		
		setupListeners(view);
	}

	private void setupListeners(MineView view) {
		for (int i = 0; i < view.getMineButtons().length; i++) {
			for (int j = 0; j < view.getMineButtons()[0].length; j++) {
				view.getMineButtons()[i][j].addMouseListener(new MineListener(j, i));
			}
		}

		view.getNewGame().addActionListener(new NewGameListener());
		view.getExitGame().addActionListener(new ExitGameListener());
	}
	public class ExitGameListener implements ActionListener {
		public ExitGameListener(){
			super();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			view.exitGame();
		}
	}
	public class NewGameListener implements ActionListener {
		public NewGameListener(){
			super();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			model = new MineModel();
			view.resetGrid();
			view.newGame();
		}
	}
	public class MineListener implements MouseListener {
		int x, y;
		
		public MineListener(int x, int y){
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public void mousePressed(MouseEvent e) {
			Object source = e.getSource();
			JButton button = (JButton)source;
			
			
			switch (e.getButton()) {
			case MouseEvent.BUTTON1:
				if (model.getStatus(x, y) != 3) {
					button.setBackground(view.getMineColor(x,y, model.getHint(x, y)));
					button.setForeground(Color.WHITE);
					model.setStatus(x, y, 1);
					button.setText(model.getHint(x,y));
					if(model.getHint(x, y).equals("-1")){
						button.getModel().setPressed(false);
						view.loseGame();
					}
					if(model.getHint(x, y).equals("0")){
						view.showZeroes(x,y);
					}
				}
				break;
			case MouseEvent.BUTTON3:
				if(model.getStatus(x, y) == 0){
					button.setBackground(Color.BLACK);
					button.setForeground(Color.YELLOW);
					button.setText("?");
					model.setStatus(x, y, 3);
				} 
				else if(model.getStatus(x, y) == 3) {
					button.setBackground(null);
					button.setForeground(Color.BLACK);
					button.setText("X");
					model.setStatus(x,y,0);
				}
				break;

			default:
				break;
			}
		}
		

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}



		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
