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

   ObjBlock water1;
   ObjBlock water2;
   ObjBlock water3;
   ObjBlock water4;
   ObjBlock water5;
   ObjBlock water6;
   ObjBlock water7;
   ObjBlock water8;
   ObjBlock water9;
   ObjBlock water10;
   ObjBlock water11;
   ObjBlock water12;
   ObjBlock water13;
   ObjBlock water14;
   ObjBlock water15;
   ObjBlock water16;
   ObjBlock water17;
   ObjBlock water18;
   ObjBlock water19;
   ObjBlock water20;
   ObjBlock water21;
   ObjBlock water22;
   ObjBlock water23;
   ObjBlock water24;

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
      water1 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water2 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water3 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water4 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water5 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water6 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water7 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water8 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water9 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water10 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water11 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water12 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water13 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water14 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water15 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water16 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water17 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water18 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water19 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water20 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water21 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water22 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water23 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      water24 = new ObjBlock("img/water.png", stage3BlockArr, manageListener);
      

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
      water1.setBounds(Stage3BlockPos.water1[1] * 60, Stage3BlockPos.water1[0] * 60, 60, 60);
      water2.setBounds(Stage3BlockPos.water2[1] * 60, Stage3BlockPos.water2[0] * 60, 60, 60);
      water3.setBounds(Stage3BlockPos.water3[1] * 60, Stage3BlockPos.water3[0] * 60, 60, 60);
      water4.setBounds(Stage3BlockPos.water4[1] * 60, Stage3BlockPos.water4[0] * 60, 60, 60);
      water5.setBounds(Stage3BlockPos.water5[1] * 60, Stage3BlockPos.water5[0] * 60, 60, 60);
      water6.setBounds(Stage3BlockPos.water6[1] * 60, Stage3BlockPos.water6[0] * 60, 60, 60);
      water7.setBounds(Stage3BlockPos.water7[1] * 60, Stage3BlockPos.water7[0] * 60, 60, 60);
      water8.setBounds(Stage3BlockPos.water8[1] * 60, Stage3BlockPos.water8[0] * 60, 60, 60);
      water9.setBounds(Stage3BlockPos.water9[1] * 60, Stage3BlockPos.water9[0] * 60, 60, 60);
      water10.setBounds(Stage3BlockPos.water10[1] * 60, Stage3BlockPos.water10[0] * 60, 60, 60);
      water11.setBounds(Stage3BlockPos.water11[1] * 60, Stage3BlockPos.water11[0] * 60, 60, 60);
      water12.setBounds(Stage3BlockPos.water12[1] * 60, Stage3BlockPos.water12[0] * 60, 60, 60);
      water13.setBounds(Stage3BlockPos.water13[1] * 60, Stage3BlockPos.water13[0] * 60, 60, 60);
      water14.setBounds(Stage3BlockPos.water14[1] * 60, Stage3BlockPos.water14[0] * 60, 60, 60);
      water15.setBounds(Stage3BlockPos.water15[1] * 60, Stage3BlockPos.water15[0] * 60, 60, 60);
      water16.setBounds(Stage3BlockPos.water16[1] * 60, Stage3BlockPos.water16[0] * 60, 60, 60);
      water17.setBounds(Stage3BlockPos.water17[1] * 60, Stage3BlockPos.water17[0] * 60, 60, 60);
      water18.setBounds(Stage3BlockPos.water18[1] * 60, Stage3BlockPos.water18[0] * 60, 60, 60);
      water19.setBounds(Stage3BlockPos.water19[1] * 60, Stage3BlockPos.water19[0] * 60, 60, 60);
      water20.setBounds(Stage3BlockPos.water20[1] * 60, Stage3BlockPos.water20[0] * 60, 60, 60);
      water21.setBounds(Stage3BlockPos.water21[1] * 60, Stage3BlockPos.water21[0] * 60, 60, 60);
      water22.setBounds(Stage3BlockPos.water22[1] * 60, Stage3BlockPos.water22[0] * 60, 60, 60);
      water23.setBounds(Stage3BlockPos.water23[1] * 60, Stage3BlockPos.water23[0] * 60, 60, 60);
      water24.setBounds(Stage3BlockPos.water24[1] * 60, Stage3BlockPos.water24[0] * 60, 60, 60);

      
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
      this.add(water17);
      this.add(water18);
      this.add(water19);
      this.add(water20);
      this.add(water21);
      this.add(water22);
      this.add(water23);
      this.add(water24);
   
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
      stage3BlockArr.initPosition(water1, Stage3BlockPos.water1[0], Stage3BlockPos.water1[1], "W1");
      stage3BlockArr.initPosition(water2, Stage3BlockPos.water2[0], Stage3BlockPos.water2[1], "W2");
      stage3BlockArr.initPosition(water3, Stage3BlockPos.water3[0], Stage3BlockPos.water3[1], "W3");
      stage3BlockArr.initPosition(water4, Stage3BlockPos.water4[0], Stage3BlockPos.water4[1], "W4");
      stage3BlockArr.initPosition(water5, Stage3BlockPos.water5[0], Stage3BlockPos.water5[1], "W5");
      stage3BlockArr.initPosition(water6, Stage3BlockPos.water6[0], Stage3BlockPos.water6[1], "W6");
      stage3BlockArr.initPosition(water7, Stage3BlockPos.water7[0], Stage3BlockPos.water7[1], "W7");
      stage3BlockArr.initPosition(water8, Stage3BlockPos.water8[0], Stage3BlockPos.water8[1], "W8");
      stage3BlockArr.initPosition(water9, Stage3BlockPos.water9[0], Stage3BlockPos.water9[1], "W9");
      stage3BlockArr.initPosition(water10, Stage3BlockPos.water10[0], Stage3BlockPos.water10[1], "W10");
      stage3BlockArr.initPosition(water11, Stage3BlockPos.water11[0], Stage3BlockPos.water11[1], "W11");
      stage3BlockArr.initPosition(water12, Stage3BlockPos.water12[0], Stage3BlockPos.water12[1], "W12");
      stage3BlockArr.initPosition(water13, Stage3BlockPos.water13[0], Stage3BlockPos.water13[1], "W13");
      stage3BlockArr.initPosition(water14, Stage3BlockPos.water14[0], Stage3BlockPos.water14[1], "W14");
      stage3BlockArr.initPosition(water15, Stage3BlockPos.water15[0], Stage3BlockPos.water15[1], "W15");
      stage3BlockArr.initPosition(water16, Stage3BlockPos.water16[0], Stage3BlockPos.water16[1], "W16");
      stage3BlockArr.initPosition(water17, Stage3BlockPos.water17[0], Stage3BlockPos.water17[1], "W17");
      stage3BlockArr.initPosition(water18, Stage3BlockPos.water18[0], Stage3BlockPos.water18[1], "W18");
      stage3BlockArr.initPosition(water19, Stage3BlockPos.water19[0], Stage3BlockPos.water19[1], "W19");
      stage3BlockArr.initPosition(water20, Stage3BlockPos.water20[0], Stage3BlockPos.water20[1], "W20");
      stage3BlockArr.initPosition(water21, Stage3BlockPos.water21[0], Stage3BlockPos.water21[1], "W21");
      stage3BlockArr.initPosition(water22, Stage3BlockPos.water22[0], Stage3BlockPos.water22[1], "W22");
      stage3BlockArr.initPosition(water23, Stage3BlockPos.water23[0], Stage3BlockPos.water23[1], "W23");
      stage3BlockArr.initPosition(water24, Stage3BlockPos.water24[0], Stage3BlockPos.water24[1], "W24");

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
      water17.setObjects(this);
      water18.setObjects(this);
      water19.setObjects(this);
      water20.setObjects(this);
      water21.setObjects(this);
      water22.setObjects(this);
      water23.setObjects(this);
      water24.setObjects(this);
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
   static int[] water1 = { 2, 11 };
   static int[] water2 = { 2, 12 };
   static int[] water3 = { 2, 13 };
   static int[] water4 = { 2, 14 };
   static int[] water5 = { 2, 15 };
   static int[] water6 = { 2, 16 };
   static int[] water7 = { 2, 17 };
   static int[] water8 = { 3, 11 };
   static int[] water9 = { 4, 11 };
   static int[] water10 = { 5, 11 };
   static int[] water11 = { 6, 11 };
   static int[] water12 = { 7, 11 };
   static int[] water13 = { 8, 11 };
   static int[] water14 = { 8, 12 };
   static int[] water15 = { 8, 13 };
   static int[] water16 = { 8, 14 };
   static int[] water17 = { 8, 15 };
   static int[] water18 = { 8, 16 };
   static int[] water19 = { 8, 17 };
   static int[] water20 = { 7, 17 };
   static int[] water21 = { 6, 17 };
   static int[] water22 = { 5, 17 };
   static int[] water23 = { 4, 17 };
   static int[] water24 = { 3, 17 };
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