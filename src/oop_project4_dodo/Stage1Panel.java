package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Stage1Panel extends JPanel {

	/* Member Variables */
	static ObjBlock dodo;
	static ObjBlock fish;
	static StageBlockArray stage1BlockArr;
	static ManageListener manageListener;

	Container contentpane;

	WordBlock _dodo;
	WordBlock _you;
	WordBlock _is1;
	WordBlock _fish;
	WordBlock _is2;
	WordBlock _win;

	/* Constructor */
	Stage1Panel(Container cp) {
		contentpane = cp;
		stage1BlockArr = new StageBlockArray();
		manageListener = new ManageListener(contentpane);

		this.setBackground(Color.BLACK);
		this.setBounds(20, ConstClass.BANNER_HEIGHT, ConstClass.PANEL_WIDTH, ConstClass.PANEL_HEIGHT);

		initBlock();
		initBlockArr();
		initWordBlockMemberVar();
		initBanner();

		// Add initial listener
		YouKeyListener dodoListener = new YouKeyListener(dodo);
		contentpane.addKeyListener(dodoListener);
		ManageListener.addYouKeyListener(dodoListener);
	}

	/* Method */
	// Initialize Block
	public void initBlock() {
		// Create Block
		dodo = new ObjBlock("img/dodo_right.png", stage1BlockArr);
		fish = new ObjBlock("img/fish_right.png", stage1BlockArr);
		_dodo = new WordBlock("img/_dodo.png", stage1BlockArr);
		_is1 = new WordBlock("img/_is.png", stage1BlockArr);
		_you = new WordBlock("img/_you.png", stage1BlockArr);
		_fish = new WordBlock("img/_fish.png", stage1BlockArr);
		_is2 = new WordBlock("img/_is.png", stage1BlockArr);
		_win = new WordBlock("img/_win.png", stage1BlockArr);

		// Set Block Position
		dodo.setBounds(Stage1BlockPos.dodo[1] * 60, Stage1BlockPos.dodo[0] * 60, 60, 60);
		fish.setBounds(Stage1BlockPos.fish[1] * 60, Stage1BlockPos.fish[0] * 60, 60, 60);
		_dodo.setBounds(Stage1BlockPos._dodo[1] * 60, Stage1BlockPos._dodo[0] * 60, 60, 60);
		_is1.setBounds(Stage1BlockPos._is1[1] * 60, Stage1BlockPos._is1[0] * 60, 60, 60);
		_you.setBounds(Stage1BlockPos._you[1] * 60, Stage1BlockPos._you[0] * 60, 60, 60);
		_fish.setBounds(Stage1BlockPos._fish[1] * 60, Stage1BlockPos._fish[0] * 60, 60, 60);
		_is2.setBounds(Stage1BlockPos._is2[1] * 60, Stage1BlockPos._is2[0] * 60, 60, 60);
		_win.setBounds(Stage1BlockPos._win[1] * 60, Stage1BlockPos._win[0] * 60, 60, 60);

		// Add Block to Panel
		this.add(dodo);
		this.add(fish);
		this.add(_dodo);
		this.add(_is1);
		this.add(_you);
		this.add(_fish);
		this.add(_is2);
		this.add(_win);

		// Add grass for demo
		new Grasses(this);

		setAllObjects();
	}

	// Initialize Block Array
	public void initBlockArr() {
		stage1BlockArr.initPosition(dodo, Stage1BlockPos.dodo[0], Stage1BlockPos.dodo[1], "D");
		stage1BlockArr.initPosition(fish, Stage1BlockPos.fish[0], Stage1BlockPos.fish[1], "F");
		stage1BlockArr.initPosition(_dodo, Stage1BlockPos._dodo[0], Stage1BlockPos._dodo[1], "d");
		stage1BlockArr.initPosition(_is1, Stage1BlockPos._is1[0], Stage1BlockPos._is1[1], "1");
		stage1BlockArr.initPosition(_you, Stage1BlockPos._you[0], Stage1BlockPos._you[1], "y");
		stage1BlockArr.initPosition(_fish, Stage1BlockPos._fish[0], Stage1BlockPos._fish[1], "f");
		stage1BlockArr.initPosition(_is2, Stage1BlockPos._is2[0], Stage1BlockPos._is2[1], "2");
		stage1BlockArr.initPosition(_win, Stage1BlockPos._win[0], Stage1BlockPos._win[1], "w");
	}

	// Initialize WordBlock Member Variables
	public void initWordBlockMemberVar() {
		// Set Object Block
		dodo.setisYou(true);
		fish.setIsPushable(false);

		// Set Word Block
		_dodo.setSubject();
		_is1.setVerb();
		_you.setComplement();
		_fish.setSubject();
		_is2.setVerb();
		_win.setComplement();
	}

	// Initialize Banner
	public void initBanner() {
		JLabel banner = new JLabel(new ImageIcon("img/stage1_banner.png"));
		banner.setBounds(0, 0, ConstClass.PANEL_WIDTH, ConstClass.BANNER_HEIGHT);
		contentpane.add(banner);
	}

	// Pass panel to all blocks
	public void setAllObjects() {
		dodo.setObjects(this);
		fish.setObjects(this);
		_dodo.setObjects(this);
		_is1.setObjects(this);
		_you.setObjects(this);
		_fish.setObjects(this);
		_is2.setObjects(this);
		_win.setObjects(this);
	}
}

class Stage1BlockPos {
	// y , x
	static int[] dodo = { 3, 10 };
	static int[] fish = { 4, 13 };

	static int[] _dodo = { 2, 4 };
	static int[] _is1 = { 2, 5 };
	static int[] _you = { 2, 6 };
	static int[] _fish = { 6, 7 };
	static int[] _is2 = { 5, 8 };
	static int[] _win = { 5, 9 };
}
