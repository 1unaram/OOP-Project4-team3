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
	ObjBlock toy;
	WordBlock _dodo;
	
	static StageBlockArray stage1BlockArr;
	
	YouKeyListener ykl;
	
	Stage1Panel(Container cp) {		
		contentpane = cp;
		stage1BlockArr = new StageBlockArray();
		
		this.setBackground(Color.BLACK);
		this.setBounds(20, ConstClass.BANNER_HEIGHT,ConstClass.PANEL_WIDTH,ConstClass.PANEL_HEIGHT);
		
		initBlock();
		initBlockArr();
		
		ykl = new YouKeyListener(dodo);
		contentpane.addKeyListener(ykl);
	}
	
	public void initBlock() {
		
		dodo = new ObjBlock("img/dodo.png", stage1BlockArr);
		fish = new ObjBlock("img/fish.png", stage1BlockArr);
		_dodo = new WordBlock("img/_dodo.png", stage1BlockArr);
		toy = new ObjBlock("img/toy.png", stage1BlockArr);
		

		dodo.setBounds(Stage1BlockPos.dodo[1] * 60, Stage1BlockPos.dodo[0] * 60, 60, 60);
		fish.setBounds(Stage1BlockPos.fish[1] * 60, Stage1BlockPos.fish[0] * 60, 60, 60);
		toy.setBounds(Stage1BlockPos.toy[1] * 60, Stage1BlockPos.toy[0] * 60, 60, 60);
		_dodo.setBounds(Stage1BlockPos._dodo[1] * 60, Stage1BlockPos._dodo[0] * 60, 60, 60);
		
		this.add(dodo);
		this.add(fish);
		this.add(toy);
		this.add(_dodo);
	}
	
	// Block 배열 초기화
	public void initBlockArr() {
		
		stage1BlockArr.initPosition(dodo, Stage1BlockPos.dodo[0], Stage1BlockPos.dodo[1], "D");
		stage1BlockArr.initPosition(fish, Stage1BlockPos.fish[0], Stage1BlockPos.fish[1], "F");
		stage1BlockArr.initPosition(toy, Stage1BlockPos.toy[0], Stage1BlockPos.toy[1], "T");
		stage1BlockArr.initPosition(_dodo, Stage1BlockPos._dodo[0], Stage1BlockPos._dodo[1], "d");
		stage1BlockArr.printArray();

	}
}


class Stage1BlockPos {
	// y , x
	static int[] dodo = {5, 3};
	static int[] fish = {5, 10};
	static int[] toy = {5, 12};
	static int[] _dodo = {3, 9};
}
