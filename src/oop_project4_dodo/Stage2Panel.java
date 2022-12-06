package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Stage2Panel extends JPanel {

	Container contentpane;

	static ObjBlock dodo;
	static ObjBlock fish;
	static ObjBlock toy;
	static ObjBlock water1;
	static ObjBlock water2;
	static ObjBlock water3;
	static ObjBlock water4;
	static ObjBlock water5;
	static ObjBlock water6;
	static ObjBlock water7;
	static ObjBlock water8;
	static ObjBlock water9;
	static ObjBlock water10;
	static ObjBlock water11;
	static ObjBlock water12;
	static ObjBlock water13;
	static ObjBlock water14;
	static ObjBlock water15;
	static ObjBlock water16;
	

	WordBlock _dodo;
	WordBlock _you;
	WordBlock _is1;
	WordBlock _fish;
	WordBlock _is2;
	WordBlock _win;
	WordBlock _toy;

	static StageBlockArray stage2BlockArr;
	static ManageListener manageListener;

	Stage2Panel(Container cp) {
		contentpane = cp;
		stage2BlockArr = new StageBlockArray();
		manageListener = new ManageListener(contentpane);

		this.setBackground(Color.BLACK);
		this.setBounds(20, ConstClass.BANNER_HEIGHT, ConstClass.PANEL_WIDTH, ConstClass.PANEL_HEIGHT);

		initBlock();
		initBlockArr();
		initWordBlockMemberVar();
		initBanner();

		YouKeyListener1 dodoListener = new YouKeyListener1(dodo);
		contentpane.addKeyListener(dodoListener);

		manageListener.addYouKeyListener1(dodoListener);
	}

	public void initBlock() {

		dodo = new ObjBlock("img/dodo.png", stage2BlockArr, manageListener);
		fish = new ObjBlock("img/fish.png", stage2BlockArr, manageListener);
		toy = new ObjBlock("img/toy.png", stage2BlockArr, manageListener);
		water1 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water2 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water3 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water4 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water5 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water6 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water7 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water8 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water9 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water10 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water11 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water12 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water13 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water14 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water15 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		water16 = new ObjBlock("img/water.png", stage2BlockArr, manageListener);
		
		_dodo = new WordBlock("img/_dodo.png", stage2BlockArr, manageListener);
		_is1 = new WordBlock("img/_is.png", stage2BlockArr, manageListener);
		_you = new WordBlock("img/_you.png", stage2BlockArr, manageListener);
		_fish = new WordBlock("img/_fish.png", stage2BlockArr, manageListener);
		_is2 = new WordBlock("img/_is.png", stage2BlockArr, manageListener);
		_win = new WordBlock("img/_win.png", stage2BlockArr, manageListener);
		_toy = new WordBlock("img/_toy.png", stage2BlockArr, manageListener);

		setAllObjects();
		
		dodo.setBounds(Stage2BlockPos.dodo[1] * 60, Stage2BlockPos.dodo[0] * 60, 60, 60);
		fish.setBounds(Stage2BlockPos.fish[1] * 60, Stage2BlockPos.fish[0] * 60, 60, 60);
		toy.setBounds(Stage2BlockPos.toy[1] * 60, Stage2BlockPos.toy[0] * 60, 60, 60);
		water1.setBounds(Stage2BlockPos.water1[1] * 60, Stage2BlockPos.water1[0] * 60, 60, 60);
		water2.setBounds(Stage2BlockPos.water2[1] * 60, Stage2BlockPos.water2[0] * 60, 60, 60);
		water3.setBounds(Stage2BlockPos.water3[1] * 60, Stage2BlockPos.water3[0] * 60, 60, 60);
		water4.setBounds(Stage2BlockPos.water4[1] * 60, Stage2BlockPos.water4[0] * 60, 60, 60);
		water5.setBounds(Stage2BlockPos.water5[1] * 60, Stage2BlockPos.water5[0] * 60, 60, 60);
		water6.setBounds(Stage2BlockPos.water6[1] * 60, Stage2BlockPos.water6[0] * 60, 60, 60);
		water7.setBounds(Stage2BlockPos.water7[1] * 60, Stage2BlockPos.water7[0] * 60, 60, 60);
		water8.setBounds(Stage2BlockPos.water8[1] * 60, Stage2BlockPos.water8[0] * 60, 60, 60);
		water9.setBounds(Stage2BlockPos.water9[1] * 60, Stage2BlockPos.water9[0] * 60, 60, 60);
		water10.setBounds(Stage2BlockPos.water10[1] * 60, Stage2BlockPos.water10[0] * 60, 60, 60);
		water11.setBounds(Stage2BlockPos.water11[1] * 60, Stage2BlockPos.water11[0] * 60, 60, 60);
		water12.setBounds(Stage2BlockPos.water12[1] * 60, Stage2BlockPos.water12[0] * 60, 60, 60);
		water13.setBounds(Stage2BlockPos.water13[1] * 60, Stage2BlockPos.water13[0] * 60, 60, 60);
		water14.setBounds(Stage2BlockPos.water14[1] * 60, Stage2BlockPos.water14[0] * 60, 60, 60);
		water15.setBounds(Stage2BlockPos.water15[1] * 60, Stage2BlockPos.water15[0] * 60, 60, 60);
		water16.setBounds(Stage2BlockPos.water16[1] * 60, Stage2BlockPos.water16[0] * 60, 60, 60);
		
		_dodo.setBounds(Stage2BlockPos._dodo[1] * 60, Stage2BlockPos._dodo[0] * 60, 60, 60);
		_is1.setBounds(Stage2BlockPos._is1[1] * 60, Stage2BlockPos._is1[0] * 60, 60, 60);
		_you.setBounds(Stage2BlockPos._you[1] * 60, Stage2BlockPos._you[0] * 60, 60, 60);
		_fish.setBounds(Stage2BlockPos._fish[1] * 60, Stage2BlockPos._fish[0] * 60, 60, 60);
		_is2.setBounds(Stage2BlockPos._is2[1] * 60, Stage2BlockPos._is2[0] * 60, 60, 60);
		_win.setBounds(Stage2BlockPos._win[1] * 60, Stage2BlockPos._win[0] * 60, 60, 60);
		_toy.setBounds(Stage2BlockPos._toy[1] * 60, Stage2BlockPos._toy[0] * 60, 60, 60);
		

		this.add(dodo);
		this.add(fish);
		this.add(toy);
		this.add(water1);
		this.add(water2);
		this.add(water3);
		this.add(water4);
		this.add(water5);
		this.add(water6);
		this.add(water7);
		this.add(water8);
		this.add(water9);
		this.add(water10);
		this.add(water11);
		this.add(water12);
		this.add(water13);
		this.add(water14);
		this.add(water15);
		this.add(water16);

		
		this.add(_dodo);
		this.add(_is1);
		this.add(_you);
		this.add(_fish);
		this.add(_is2);
		this.add(_win);
		this.add(_toy);

	}

	// Block 배열 초기화
	public void initBlockArr() {

		stage2BlockArr.initPosition(dodo, Stage2BlockPos.dodo[0], Stage2BlockPos.dodo[1], "D");
		stage2BlockArr.initPosition(fish, Stage2BlockPos.fish[0], Stage2BlockPos.fish[1], "F");
		stage2BlockArr.initPosition(toy, Stage2BlockPos.toy[0], Stage2BlockPos.toy[1], "T");
		stage2BlockArr.initPosition(water1, Stage2BlockPos.water1[0], Stage2BlockPos.water1[1], "W1");
		stage2BlockArr.initPosition(water2, Stage2BlockPos.water2[0], Stage2BlockPos.water2[1], "W2");
		stage2BlockArr.initPosition(water3, Stage2BlockPos.water3[0], Stage2BlockPos.water3[1], "W3");
		stage2BlockArr.initPosition(water4, Stage2BlockPos.water4[0], Stage2BlockPos.water4[1], "W4");
		stage2BlockArr.initPosition(water5, Stage2BlockPos.water5[0], Stage2BlockPos.water5[1], "W5");
		stage2BlockArr.initPosition(water6, Stage2BlockPos.water6[0], Stage2BlockPos.water6[1], "W6");
		stage2BlockArr.initPosition(water7, Stage2BlockPos.water7[0], Stage2BlockPos.water7[1], "W7");
		stage2BlockArr.initPosition(water8, Stage2BlockPos.water8[0], Stage2BlockPos.water8[1], "W8");
		stage2BlockArr.initPosition(water9, Stage2BlockPos.water9[0], Stage2BlockPos.water9[1], "W9");
		stage2BlockArr.initPosition(water10, Stage2BlockPos.water10[0], Stage2BlockPos.water10[1], "W10");
		stage2BlockArr.initPosition(water11, Stage2BlockPos.water11[0], Stage2BlockPos.water11[1], "W11");
		stage2BlockArr.initPosition(water12, Stage2BlockPos.water12[0], Stage2BlockPos.water12[1], "W12");
		stage2BlockArr.initPosition(water13, Stage2BlockPos.water13[0], Stage2BlockPos.water13[1], "W13");
		stage2BlockArr.initPosition(water14, Stage2BlockPos.water14[0], Stage2BlockPos.water14[1], "W14");
		stage2BlockArr.initPosition(water15, Stage2BlockPos.water15[0], Stage2BlockPos.water15[1], "W15");
		stage2BlockArr.initPosition(water16, Stage2BlockPos.water16[0], Stage2BlockPos.water16[1], "W16");
		
		stage2BlockArr.initPosition(_dodo, Stage2BlockPos._dodo[0], Stage2BlockPos._dodo[1], "d");
		stage2BlockArr.initPosition(_is1, Stage2BlockPos._is1[0], Stage2BlockPos._is1[1], "1");
		stage2BlockArr.initPosition(_you, Stage2BlockPos._you[0], Stage2BlockPos._you[1], "y");
		stage2BlockArr.initPosition(_fish, Stage2BlockPos._fish[0], Stage2BlockPos._fish[1], "f");
		stage2BlockArr.initPosition(_is2, Stage2BlockPos._is2[0], Stage2BlockPos._is2[1], "2");
		stage2BlockArr.initPosition(_win, Stage2BlockPos._win[0], Stage2BlockPos._win[1], "w");
		stage2BlockArr.initPosition(_toy, Stage2BlockPos._toy[0], Stage2BlockPos._toy[1], "t");

		// stage1BlockArr.printArray();
	}

	public void initWordBlockMemberVar() {

		_dodo.setSubject();
		_is1.setVerb();
		_you.setComplement();
		_fish.setSubject();
		_toy.setSubject();
		_is2.setVerb();
		_win.setComplement();
		fish.setIsPushable(false);
		toy.setIsPushable(true);
		water1.setIsPushable(false);
		water2.setIsPushable(false);
		water3.setIsPushable(false);
		water4.setIsPushable(false);
		water5.setIsPushable(false);
		water6.setIsPushable(false);
		water7.setIsPushable(false);
		water8.setIsPushable(false);
		water9.setIsPushable(false);
		water10.setIsPushable(false);
		water11.setIsPushable(false);
		water12.setIsPushable(false);
		water13.setIsPushable(false);
		water14.setIsPushable(false);
		water15.setIsPushable(false);
		water16.setIsPushable(false);
		
		dodo.setisYou(true);
	}

	// 배너 추가
	public void initBanner() {
		JLabel banner = new JLabel(new ImageIcon("img/stage2_banner.png"));
		banner.setBounds(0, 0, ConstClass.PANEL_WIDTH, ConstClass.BANNER_HEIGHT);
		contentpane.add(banner);
	}

	public void setAllObjects() {
		dodo.setObjects(this);
		fish.setObjects(this);
		toy.setObjects(this);
		water1.setObjects(this);
		water2.setObjects(this);
		water3.setObjects(this);
		water4.setObjects(this);
		water5.setObjects(this);
		water6.setObjects(this);
		water7.setObjects(this);
		water8.setObjects(this);
		water9.setObjects(this);
		water10.setObjects(this);
		water11.setObjects(this);
		water12.setObjects(this);
		water13.setObjects(this);
		water14.setObjects(this);
		water15.setObjects(this);
		water16.setObjects(this);
		
		_dodo.setObjects(this);
		_is1.setObjects(this);
		_you.setObjects(this);
		_fish.setObjects(this);
		_is2.setObjects(this);
		_win.setObjects(this);
		_toy.setObjects(this);
	}
}

class Stage2BlockPos {
	// y , x
	static int[] dodo = { 4, 10 };
	static int[] fish = { 3, 16 };
	static int[] toy = { 5, 14 };
	static int[] water1 = { 2, 13 };
	static int[] water2 = { 2, 14 };
	static int[] water3 = { 2, 15 };
	static int[] water4 = { 2, 16 };
	static int[] water5 = { 2, 17 };
	static int[] water6 = { 3, 13 };
	static int[] water7 = { 4, 13 };
	static int[] water8 = { 5, 13 };
	static int[] water9 = { 6, 13 };
	static int[] water10 = { 6, 14 };
	static int[] water11 = { 6, 15 };
	static int[] water12 = { 6, 16 };
	static int[] water13 = { 6, 17 };
	static int[] water14 = { 5, 17 };
	static int[] water15 = { 4, 17 };
	static int[] water16 = { 3, 17 };
	
	
	static int[] _dodo = { 3, 5 };
	static int[] _is1 = { 3, 6 };
	static int[] _you = { 3, 7 };
	static int[] _fish = { 7, 5 };
	static int[] _is2 = { 5, 6 };
	static int[] _win = { 5, 7 };
	static int[] _toy = { 5, 5 };
}