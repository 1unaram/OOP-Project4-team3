package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Stage3Panel extends JPanel{
   Container contentpane;
   
   static ObjBlock dodo;
   static ObjBlock fish;
   static ObjBlock toy;

   ObjBlock[] water = new ObjBlock[24];

   WordBlock _dodo;
   WordBlock _is1;
   WordBlock _you;
   WordBlock _toy;
   WordBlock _is2;
   WordBlock _win;
   WordBlock _fish;
   WordBlock _is3;
   WordBlock _move;
   WordBlock _water;
   WordBlock _is4;
   WordBlock _defeat;
   
   static StageBlockArray stage3BlockArr;
   static ManageListener manageListener;

   Stage3Panel(Container cp) {
      contentpane = cp;
      stage3BlockArr = new StageBlockArray();
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

      dodo = new ObjBlock("img/dodo_right.png", stage3BlockArr, manageListener);
      fish = new ObjBlock("img/fish_right.png", stage3BlockArr, manageListener);
      toy = new ObjBlock("img/toy.png", stage3BlockArr, manageListener);
      for(int i=0; i<water.length; i++) {
    	  water[i] = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      }

      _dodo = new WordBlock("img/_dodo.png", stage3BlockArr, manageListener);
      _is1 = new WordBlock("img/_is.png", stage3BlockArr, manageListener);
      _you = new WordBlock("img/_you.png", stage3BlockArr, manageListener);
      _toy = new WordBlock("img/_toy.png", stage3BlockArr, manageListener);
      _is2 = new WordBlock("img/_is.png", stage3BlockArr, manageListener);
      _win = new WordBlock("img/_win.png", stage3BlockArr, manageListener);
      _fish = new WordBlock("img/_fish.png", stage3BlockArr, manageListener);
      _is3 = new WordBlock("img/_is.png", stage3BlockArr, manageListener);
      _move = new WordBlock("img/_move.png", stage3BlockArr, manageListener);
      _water = new WordBlock("img/_water.png", stage3BlockArr, manageListener);
      _is4 = new WordBlock("img/_is.png", stage3BlockArr, manageListener);
      _defeat = new WordBlock("img/_defeat.png", stage3BlockArr, manageListener);

      setAllObjects();
      
      
      dodo.setBounds(Stage3BlockPos.dodo[1] * 60, Stage3BlockPos.dodo[0] * 60, 60, 60);
      fish.setBounds(Stage3BlockPos.fish[1] * 60, Stage3BlockPos.fish[0] * 60, 60, 60);
      toy.setBounds(Stage3BlockPos.toy[1] * 60, Stage3BlockPos.toy[0] * 60, 60, 60);
      for(int i=0; i<water.length; i++) {
    	  water[i].setBounds(Stage3BlockPos.water[i][1] * 60, Stage3BlockPos.water[i][0] * 60, 60, 60);	
      }
      
      _dodo.setBounds(Stage3BlockPos._dodo[1] * 60, Stage3BlockPos._dodo[0] * 60, 60, 60);
      _is1.setBounds(Stage3BlockPos._is1[1] * 60, Stage3BlockPos._is1[0] * 60, 60, 60);
      _you.setBounds(Stage3BlockPos._you[1] * 60, Stage3BlockPos._you[0] * 60, 60, 60);
      _toy.setBounds(Stage3BlockPos._toy[1] * 60, Stage3BlockPos._toy[0] * 60, 60, 60);
      _is2.setBounds(Stage3BlockPos._is2[1] * 60, Stage3BlockPos._is2[0] * 60, 60, 60);
      _win.setBounds(Stage3BlockPos._win[1] * 60, Stage3BlockPos._win[0] * 60, 60, 60);
      _fish.setBounds(Stage3BlockPos._fish[1] * 60, Stage3BlockPos._fish[0] * 60, 60, 60);
      _is3.setBounds(Stage3BlockPos._is3[1] * 60, Stage3BlockPos._is3[0] * 60, 60, 60);
      _move.setBounds(Stage3BlockPos._move[1] * 60, Stage3BlockPos._move[0] * 60, 60, 60);
      _water.setBounds(Stage3BlockPos._water[1] * 60, Stage3BlockPos._water[0] * 60, 60, 60);
      _is4.setBounds(Stage3BlockPos._is4[1] * 60, Stage3BlockPos._is4[0] * 60, 60, 60);
      _defeat.setBounds(Stage3BlockPos._defeat[1] * 60, Stage3BlockPos._defeat[0] * 60, 60, 60);
      

      this.add(dodo);
      this.add(fish);
      this.add(toy);
      for(int i=0; i<water.length; i++) {
    	  this.add(water[i]);
      }
   
      this.add(_dodo);
      this.add(_is1);
      this.add(_you);
      this.add(_toy);
      this.add(_is2);
      this.add(_win);
      this.add(_fish);
      this.add(_is3);
      this.add(_move);
      this.add(_water);
      this.add(_is4);
      this.add(_defeat);

   }

   // Block 배열 초기화
   public void initBlockArr() {

      stage3BlockArr.initPosition(dodo, Stage3BlockPos.dodo[0], Stage3BlockPos.dodo[1], "D");
      stage3BlockArr.initPosition(fish, Stage3BlockPos.fish[0], Stage3BlockPos.fish[1], "F");
      stage3BlockArr.initPosition(toy, Stage3BlockPos.toy[0], Stage3BlockPos.toy[1], "T");
      for(int i=0; i<water.length; i++) {
    	  String W = "W" + (char)(i+1);
    	  stage3BlockArr.initPosition(water[i], Stage3BlockPos.water[i][0], Stage3BlockPos.water[i][1], W);
      }

      stage3BlockArr.initPosition(_dodo, Stage3BlockPos._dodo[0], Stage3BlockPos._dodo[1], "d");
      stage3BlockArr.initPosition(_is1, Stage3BlockPos._is1[0], Stage3BlockPos._is1[1], "1");
      stage3BlockArr.initPosition(_you, Stage3BlockPos._you[0], Stage3BlockPos._you[1], "y");
      stage3BlockArr.initPosition(_toy, Stage3BlockPos._toy[0], Stage3BlockPos._toy[1], "t");
      stage3BlockArr.initPosition(_is2, Stage3BlockPos._is2[0], Stage3BlockPos._is2[1], "2");
      stage3BlockArr.initPosition(_win, Stage3BlockPos._win[0], Stage3BlockPos._win[1], "w");
      stage3BlockArr.initPosition(_fish, Stage3BlockPos._fish[0], Stage3BlockPos._fish[1], "f");
      stage3BlockArr.initPosition(_is3, Stage3BlockPos._is3[0], Stage3BlockPos._is3[1], "3");
      stage3BlockArr.initPosition(_move, Stage3BlockPos._move[0], Stage3BlockPos._move[1], "m");
      stage3BlockArr.initPosition(_water, Stage3BlockPos._water[0], Stage3BlockPos._water[1], "a");
      stage3BlockArr.initPosition(_is4, Stage3BlockPos._is4[0], Stage3BlockPos._is4[1], "4");
      stage3BlockArr.initPosition(_defeat, Stage3BlockPos._defeat[0], Stage3BlockPos._defeat[1], "d");

      // stage3BlockArr.printArray();
   }

   public void initWordBlockMemberVar() {

      _dodo.setSubject();
      _is1.setVerb();
      _you.setComplement();
      _toy.setSubject();
      _is2.setVerb();
      _win.setComplement();
      _fish.setSubject();
      _is3.setVerb();
      _move.setComplement();
      _water.setSubject();
      _is4.setVerb();
      _defeat.setComplement();
      
      fish.setIsPushable(false);
      
      dodo.setisYou(true);
   }

   // 배너 추가
   public void initBanner() {
      JLabel banner = new JLabel(new ImageIcon("img/stage3_banner.png"));
      banner.setBounds(0, 0, ConstClass.PANEL_WIDTH, ConstClass.BANNER_HEIGHT);
      contentpane.add(banner);
   }

   public void setAllObjects() {
      dodo.setObjects(this);
      fish.setObjects(this);
      toy.setObjects(this);
      for(int i=0; i<water.length; i++) {
    	  water[i].setObjects(this);
      }
      _dodo.setObjects(this);
      _is1.setObjects(this);
      _you.setObjects(this);
      _toy.setObjects(this);
      _is2.setObjects(this);
      _win.setObjects(this);
      _fish.setObjects(this);
      _is3.setObjects(this);
      _move.setObjects(this);
      _water.setObjects(this);
      _is4.setObjects(this);
      _defeat.setObjects(this);
   }
}

class Stage3BlockPos {
   // y , x
   static int[] dodo = { 4, 9 };
   static int[] fish = { 3, 16 };
   static int[] toy = { 7, 12 };
   static int[][] water = {{ 2, 11 }, { 2, 12 }, { 2, 13 }, { 2, 14 }, { 2, 15 }, { 2, 16 }, { 2, 17 }, { 3, 11 }, { 4, 11 }, { 5, 11 }, { 6, 11 }, 
		   { 7, 11 }, { 8, 11 }, { 8, 12 }, { 8, 13 }, { 8, 14 }, { 8, 15 }, { 8, 16 }, { 8, 17 }, { 7, 17 }, { 6, 17 }, { 5, 17 }, { 4, 17 }, { 3, 17 }};
   static int[] _dodo = { 2, 5 };
   static int[] _is1 = { 2, 6 };
   static int[] _you = { 2, 7 };
   static int[] _toy = { 5, 5 };
   static int[] _is2 = { 5, 6 };
   static int[] _win = { 5, 7 };
   static int[] _fish = { 8, 5 };
   static int[] _is3 = { 8, 6 };
   static int[] _move = { 8, 7 };
   static int[] _water = { 0, 15 };
   static int[] _is4 = { 0, 16 };
   static int[] _defeat = { 0, 17 };
}