package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;
import java.util.Arrays;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Stage1Panel extends JPanel {
	
	Container contentpane;
	
	Block dodo;
	ObjBlock fish;
	
	boolean[][] isBlockArr = new boolean[20][11];
	
	YouKeyListener ykl;
	
	Stage1Panel(Container cp) {		
		contentpane = cp;
		
		this.setBackground(Color.BLUE);
		this.setBounds(20, ConstantClass.BANNER_HEIGHT,ConstantClass.PANEL_WIDTH,ConstantClass.PANEL_HEIGHT);
		
		initBlock();
		initBlockArr();
		
		ykl = new YouKeyListener(dodo);
		contentpane.addKeyListener(ykl);
	}
	
	public void initBlock() {
		dodo = new Block("img/dodo.png");
		fish = new ObjBlock("img/fish.png");
		

		dodo.setBounds(540, 300, 60, 60);
		fish.setBounds(600, 300, 60, 60);
		
		this.add(dodo);
		this.add(fish);
	}
	
	public void initBlockArr() {
		
		// initialize array to false
		for(boolean[] b : isBlockArr) {
			Arrays.fill(b, false);
		}
		
	}
}
