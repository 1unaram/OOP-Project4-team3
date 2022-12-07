package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Stage3Panel extends JPanel {

   /* Member Variables */
   static ObjBlock dodo;
   static ObjBlock fish;
   static ObjBlock toy;
   static ObjBlock[] water;
   static StageBlockArray stage3BlockArr;
   static ManageListener manageListener;

   Container contentpane;

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

   /* Constructor */
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

      YouKeyListener dodoListener = new YouKeyListener(dodo);
      contentpane.addKeyListener(dodoListener);

      ManageListener.addYouKeyListener(dodoListener);
   }

   // Initialize Block
   public void initBlock() {
      // Create Block
      dodo = new ObjBlock("img/dodo_right.png", stage3BlockArr);
      fish = new ObjBlock("img/fish_right.png", stage3BlockArr);
      toy = new ObjBlock("img/toy.png", stage3BlockArr);
      water = new ObjBlock[24];
      for (int i = 0; i < water.length; i++) {
         water[i] = new ObjBlock("img/water.png", stage3BlockArr);
      }
      _dodo = new WordBlock("img/_dodo.png", stage3BlockArr);
      _is1 = new WordBlock("img/_is.png", stage3BlockArr);
      _you = new WordBlock("img/_you.png", stage3BlockArr);
      _toy = new WordBlock("img/_toy.png", stage3BlockArr);
      _is2 = new WordBlock("img/_is.png", stage3BlockArr);
      _win = new WordBlock("img/_win.png", stage3BlockArr);
      _fish = new WordBlock("img/_fish.png", stage3BlockArr);
      _is3 = new WordBlock("img/_is.png", stage3BlockArr);
      _move = new WordBlock("img/_move.png", stage3BlockArr);
      _water = new WordBlock("img/_water.png", stage3BlockArr);
      _is4 = new WordBlock("img/_is.png", stage3BlockArr);
      _defeat = new WordBlock("img/_defeat.png", stage3BlockArr);

      // Set Block Position
      dodo.setBounds(Stage3BlockPos.dodo[1] * 60, Stage3BlockPos.dodo[0] * 60, 60, 60);
      fish.setBounds(Stage3BlockPos.fish[1] * 60, Stage3BlockPos.fish[0] * 60, 60, 60);
      toy.setBounds(Stage3BlockPos.toy[1] * 60, Stage3BlockPos.toy[0] * 60, 60, 60);
      for (int i = 0; i < water.length; i++) {
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
      this.add(_toy);
      this.add(_is2);
      this.add(_win);
      this.add(_fish);
      this.add(_is3);
      this.add(_move);
      this.add(_water);
      this.add(_is4);
      this.add(_defeat);

      setAllObjects();
   }

   // Initialize Block Array
   public void initBlockArr() {
      stage3BlockArr.initPosition(dodo, Stage3BlockPos.dodo[0], Stage3BlockPos.dodo[1], "D");
      stage3BlockArr.initPosition(fish, Stage3BlockPos.fish[0], Stage3BlockPos.fish[1], "F");
      stage3BlockArr.initPosition(toy, Stage3BlockPos.toy[0], Stage3BlockPos.toy[1], "T");
      for (int i = 0; i < water.length; i++) {
         stage3BlockArr.initPosition(water[i], Stage3BlockPos.water[i][0], Stage3BlockPos.water[i][1],
               "W" + Integer.toString(i + 1));
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
   }

   // Initialize WordBlock Member Variables
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

      dodo.setisYou(true);
      fish.setIsPushable(false);
      fish.setMove(true);
      for (int i = 0; i < water.length; i++) {
         water[i].setIsPushable(false);
      }
   }

   // Initialize Banner
   public void initBanner() {
      JLabel banner = new JLabel(new ImageIcon("img/stage3_banner.png"));
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
   static int[] toy = { 6, 13 };
   static int[][] water = { { 2, 11 }, { 2, 12 }, { 2, 13 }, { 2, 14 }, { 2, 15 }, { 2, 16 }, { 2, 17 }, { 3, 11 },
         { 4, 11 }, { 5, 11 }, { 6, 11 },
         { 7, 11 }, { 8, 11 }, { 8, 12 }, { 8, 13 }, { 8, 14 }, { 8, 15 }, { 8, 16 }, { 8, 17 }, { 7, 17 }, { 6, 17 },
         { 5, 17 }, { 4, 17 }, { 3, 17 } };

   static int[] _dodo = { 1, 2 };
   static int[] _is1 = { 1, 3 };
   static int[] _you = { 1, 4 };
   static int[] _toy = { 4, 5 };
   static int[] _is2 = { 4, 6 };
   static int[] _win = { 4, 7 };
   static int[] _fish = { 7, 3 };
   static int[] _is3 = { 7, 4 };
   static int[] _move = { 7, 5 };
   static int[] _water = { 0, 14 };
   static int[] _is4 = { 0, 15 };
   static int[] _defeat = { 0, 16 };
}