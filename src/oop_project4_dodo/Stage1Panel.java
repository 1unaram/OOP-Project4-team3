package oop_project4_dodo;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Stage1Panel extends JPanel {
	
	Stage1Panel() {		
		Block dodo = new Block("img/dodo.png");
		this.add(dodo);

		this.setBackground(Color.BLUE);
		this.setBounds(0,80,1200,720);
	}
	
}
