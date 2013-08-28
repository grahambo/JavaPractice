import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PieGraph extends JFrame implements ActionListener{
	ArrayList<Integer> data = new ArrayList<>();
	JTextField dataField = new JTextField("0",20);
	
	public PieGraph(){
		super();
		setBounds(500, 300, 600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// set up input area
		JPanel inputPane = new JPanel();
		inputPane.setLayout(new FlowLayout());
		inputPane.setBounds(0, 0, getWidth(), getHeight()/3);
		JButton enter = new JButton("Enter");
		enter.addActionListener(this);
		inputPane.add(dataField);
		inputPane.add(enter);
		inputPane.setBackground(Color.black);
		
		// set up pie area
		PiePane piePane = new PiePane(data);
		piePane.setBounds(0,getHeight()/3, getWidth(), getHeight()*2/3);
		piePane.setBackground(Color.red);
		
		// add panes
		add(inputPane);
		add(piePane);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		PieGraph pie = new PieGraph();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		data.add(Integer.parseInt(dataField.getText()));
		dataField.setText("0");
		repaint();
	}
}

class PiePane extends JPanel {
	ArrayList<Integer> data;
	public PiePane(ArrayList<Integer> data) {
		this.data = data;
	}
	
	public void paintComponent(Graphics comp) {
		float startingDegree = 0;
		float dataTotal = 0;
		int colorNum = 1;
		float angle = 0;
		Graphics2D comp2D = (Graphics2D)comp;
		for (Integer i : data) {
			dataTotal+= i;
		}
		for (Integer piePiece : data) {
			// determine starting angle for pie piece
			angle = piePiece/dataTotal*360;
			
			//create and draw the pie piece
			Arc2D.Float pie = new Arc2D.Float(this.getWidth()/4, 235, this.getWidth()/2, 
					this.getHeight()/2, startingDegree, angle, Arc2D.Float.PIE);
			comp2D.setPaint(getNewColor(colorNum));
			
			colorNum = (colorNum<=13 ? colorNum+1 : 1);
			comp2D.fill(pie);
			
			startingDegree+=piePiece/dataTotal*360;
		}
	}
	
	private Color getNewColor(int i){
		switch (i) {
		case 1:
			return Color.black;
		case 2:
			return Color.blue;
		case 3:
			return Color.cyan;
		case 4:
			return Color.red;
		case 5:
			return Color.gray;
		case 6:
			return Color.green;
		case 7:
			return Color.lightGray;
		case 8:
			return Color.magenta;
		case 9:
			return Color.orange;
		case 10:
			return Color.pink;
		case 11:
			return Color.red;
		case 12:
			return Color.white;
		case 13:
			return Color.yellow;
		default:
			return Color.black;
		}
	}
}
