package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Stage2Panel extends JPanel {

	/* Member Variables */
	static ObjBlock dodo;
	static ObjBlock fish;
	static ObjBlock toy;
	static ObjBlock[] water;
	static StageBlockArray stage2BlockArr;
	static ManageListener manageListener;

	Container contentpane;

	WordBlock _dodo;
	WordBlock _you;
	WordBlock _is1;
	WordBlock _fish;
	WordBlock _is2;
	WordBlock _win;
	WordBlock _toy;
	WordBlock _water;
	WordBlock _is3;
	WordBlock _wall;

	/* Constructor */
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

		YouKeyListener dodoListener = new YouKeyListener(dodo);
		contentpane.addKeyListener(dodoListener);
		ManageListener.addYouKeyListener(dodoListener);
	}

	/* Method */
	// Initialize Block
	public void initBlock() {
		// Create Block
		dodo = new ObjBlock("img/dodo_right.png", stage2BlockArr);
		fish = new ObjBlock("img/fish_right.png", stage2BlockArr);
		toy = new ObjBlock("img/toy.png", stage2BlockArr);
		water = new ObjBlock[16];
		for (int i = 0; i < water.length; i++) {
			water[i] = new ObjBlock("img/water.png", stage2BlockArr);
		}
		_dodo = new WordBlock("img/_dodo.png", stage2BlockArr);
		_is1 = new WordBlock("img/_is.png", stage2BlockArr);
		_you = new WordBlock("img/_you.png", stage2BlockArr);
		_fish = new WordBlock("img/_fish.png", stage2BlockArr);
		_is2 = new WordBlock("img/_is.png", stage2BlockArr);
		_win = new WordBlock("img/_win.png", stage2BlockArr);
		_toy = new WordBlock("img/_toy.png", stage2BlockArr);
		_water = new WordBlock("img/_water.png", stage2BlockArr);
		_is3 = new WordBlock("img/_is.png", stage2BlockArr);
		_wall = new WordBlock("img/_wall.png", stage2BlockArr);

		// Set Block Position
		dodo.setBounds(Stage2BlockPos.dodo[1] * 60, Stage2BlockPos.dodo[0] * 60, 60, 60);
		fish.setBounds(Stage2BlockPos.fish[1] * 60, Stage2BlockPos.fish[0] * 60, 60, 60);
		toy.setBounds(Stage2BlockPos.toy[1] * 60, Stage2BlockPos.toy[0] * 60, 60, 60);
		for (int i = 0; i < water.length; i++) {
			water[i].setBounds(Stage2BlockPos.water[i][1] * 60, Stage2BlockPos.water[i][0] * 60, 60, 60);
		}
		_dodo.setBounds(Stage2BlockPos._dodo[1] * 60, Stage2BlockPos._dodo[0] * 60, 60, 60);
		_is1.setBounds(Stage2BlockPos._is1[1] * 60, Stage2BlockPos._is1[0] * 60, 60, 60);
		_you.setBounds(Stage2BlockPos._you[1] * 60, Stage2BlockPos._you[0] * 60, 60, 60);
		_fish.setBounds(Stage2BlockPos._fish[1] * 60, Stage2BlockPos._fish[0] * 60, 60, 60);
		_is2.setBounds(Stage2BlockPos._is2[1] * 60, Stage2BlockPos._is2[0] * 60, 60, 60);
		_win.setBounds(Stage2BlockPos._win[1] * 60, Stage2BlockPos._win[0] * 60, 60, 60);
		_toy.setBounds(Stage2BlockPos._toy[1] * 60, Stage2BlockPos._toy[0] * 60, 60, 60);
		_water.setBounds(Stage2BlockPos._water[1] * 60, Stage2BlockPos._water[0] * 60, 60, 60);
		_is3.setBounds(Stage2BlockPos._is3[1] * 60, Stage2BlockPos._is3[0] * 60, 60, 60);
		_wall.setBounds(Stage2BlockPos._wall[1] * 60, Stage2BlockPos._wall[0] * 60, 60, 60);

		// Add Block to Panel
		this.add(dodo);
		this.add(fish);
		this.add(toy);
		for (int i = 0; i < water.length; i++) {
			this.add(water[i]);
		}
		this.add(_dodo);
		this.add(_is1);
		this.add(_you);
		this.add(_fish);
		this.add(_is2);
		this.add(_win);
		this.add(_toy);
		this.add(_water);
		this.add(_is3);
		this.add(_wall);

		setAllObjects();
	}

	// Initialize Block Array
	public void initBlockArr() {
		stage2BlockArr.initPosition(dodo, Stage2BlockPos.dodo[0], Stage2BlockPos.dodo[1], "D");
		stage2BlockArr.initPosition(fish, Stage2BlockPos.fish[0], Stage2BlockPos.fish[1], "F");
		stage2BlockArr.initPosition(toy, Stage2BlockPos.toy[0], Stage2BlockPos.toy[1], "T");
		for (int i = 0; i < water.length; i++) {
			stage2BlockArr.initPosition(water[i], Stage2BlockPos.water[i][0], Stage2BlockPos.water[i][1], "WATER");
		}
		stage2BlockArr.initPosition(_dodo, Stage2BlockPos._dodo[0], Stage2BlockPos._dodo[1], "d");
		stage2BlockArr.initPosition(_is1, Stage2BlockPos._is1[0], Stage2BlockPos._is1[1], "1");
		stage2BlockArr.initPosition(_you, Stage2BlockPos._you[0], Stage2BlockPos._you[1], "y");
		stage2BlockArr.initPosition(_fish, Stage2BlockPos._fish[0], Stage2BlockPos._fish[1], "f");
		stage2BlockArr.initPosition(_is2, Stage2BlockPos._is2[0], Stage2BlockPos._is2[1], "2");
		stage2BlockArr.initPosition(_win, Stage2BlockPos._win[0], Stage2BlockPos._win[1], "w");
		stage2BlockArr.initPosition(_toy, Stage2BlockPos._toy[0], Stage2BlockPos._toy[1], "t");
		stage2BlockArr.initPosition(_water, Stage2BlockPos._water[0], Stage2BlockPos._water[1], "water");
		stage2BlockArr.initPosition(_is3, Stage2BlockPos._is3[0], Stage2BlockPos._is3[1], "3");
		stage2BlockArr.initPosition(_wall, Stage2BlockPos._wall[0], Stage2BlockPos._wall[1], "wl");
	}

	// Initialize WordBlock Member Variables
	public void initWordBlockMemberVar() {
		// Set Object Block
		dodo.setisYou(true);
		fish.setIsPushable(false);
		toy.setIsPushable(false);
		for (int i = 0; i < water.length; i++) {
			water[i].setIsPushable(false);
		}

		// Set Word Block
		_dodo.setSubject();
		_is1.setVerb();
		_you.setComplement();
		_fish.setSubject();
		_toy.setSubject();
		_is2.setVerb();
		_win.setComplement();
		_water.setSubject();
		_is3.setVerb();
		_wall.setComplement();
	}

	// Initialize Banner
	public void initBanner() {
		JLabel banner = new JLabel(new ImageIcon("img/stage2_banner.png"));
		banner.setBounds(0, 0, ConstClass.PANEL_WIDTH, ConstClass.BANNER_HEIGHT);
		contentpane.add(banner);
	}

	// Pass panel to all blocks
	public void setAllObjects() {
		dodo.setObjects(this);
		fish.setObjects(this);
		toy.setObjects(this);
		for (int i = 0; i < water.length; i++) {
			water[i].setObjects(this);
		}
		_dodo.setObjects(this);
		_is1.setObjects(this);
		_you.setObjects(this);
		_fish.setObjects(this);
		_is2.setObjects(this);
		_win.setObjects(this);
		_toy.setObjects(this);
		_water.setObjects(this);
		_is3.setObjects(this);
		_wall.setObjects(this);
	}
}

class Stage2BlockPos {
	// y , x
	static int[] dodo = { 4, 10 };
	static int[] fish = { 3, 16 };
	static int[] toy = { 5, 14 };
	static int[][] water = { { 2, 13 }, { 2, 14 }, { 2, 15 }, { 2, 16 }, { 2, 17 }, { 3, 13 }, { 4, 13 }, { 5, 13 },
			{ 6, 13 }, { 6, 14 }, { 6, 15 }, { 6, 16 }, { 6, 17 }, { 5, 17 }, { 4, 17 }, { 3, 17 } };

	static int[] _dodo = { 2, 3 };
	static int[] _is1 = { 2, 4 };
	static int[] _you = { 2, 5 };
	static int[] _fish = { 7, 5 };
	static int[] _is2 = { 5, 6 };
	static int[] _win = { 5, 7 };
	static int[] _toy = { 5, 5 };
	static int[] _water = { 10, 17 };
	static int[] _is3 = { 10, 18 };
	static int[] _wall = { 10, 19 };
}