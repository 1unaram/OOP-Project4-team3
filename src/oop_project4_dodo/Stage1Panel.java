package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;
import java.util.Arrays;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Stage1Panel extends JPanel {
	
	Container contentpane;
	
	ObjBlock dodo;
	ObjBlock fish;
	WordBlock _dodo;
	
	StageBlockArray blockArr = new StageBlockArray();
	
	
	YouKeyListener ykl;
	
	Stage1Panel(Container cp) {		
		contentpane = cp;
		
		this.setBackground(Color.BLACK);
		this.setBounds(20, ConstantClass.BANNER_HEIGHT,ConstantClass.PANEL_WIDTH,ConstantClass.PANEL_HEIGHT);
		
		initBlock();
		initBlockArr();
		
		ykl = new YouKeyListener(dodo);
		contentpane.addKeyListener(ykl);
	}
	
	public void initBlock() {
		dodo = new ObjBlock("img/dodo.png");
		fish = new ObjBlock("img/fish.png");
		_dodo = new WordBlock("img/_dodo.png");
		

		dodo.setBounds(Stage1BlockPos.dodo[1] * 60, Stage1BlockPos.dodo[0] * 60, 60, 60);
		fish.setBounds(Stage1BlockPos.fish[1] * 60, Stage1BlockPos.fish[0] * 60, 60, 60);
		
		_dodo.setBounds(Stage1BlockPos._dodo[1] * 60, Stage1BlockPos._dodo[0] * 60, 60, 60);
		
		this.add(dodo);
		this.add(fish);
		this.add(_dodo);
	}
	
	// Block 배열 초기화
	public void initBlockArr() {
		
		blockArr.setPosition(dodo, Stage1BlockPos.dodo[0], Stage1BlockPos.dodo[1], "D");
		blockArr.setPosition(fish, Stage1BlockPos.fish[0], Stage1BlockPos.fish[1], "F");
		blockArr.setPosition(_dodo, Stage1BlockPos._dodo[0], Stage1BlockPos._dodo[1], "d");
		blockArr.printArray();

	}
}


class Stage1BlockPos {
	// y , x
	static int[] dodo = {5, 3};
	static int[] fish = {5, 10};
	static int[] _dodo = {3, 9};
}
