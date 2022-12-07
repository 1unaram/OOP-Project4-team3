package oop_project4_dodo;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Block extends JLabel {

   /* Private member variable */
   private boolean isPushable = true;

   private int arrX;
   private int arrY;

   StageBlockArray stageBlockArr;

   Stage1Panel stage1Panel = null;
   Stage2Panel stage2Panel = null;
   Stage3Panel stage3Panel = null;

   ObjBlock dodo;
   ObjBlock fish;
   ObjBlock toy;
   ObjBlock[] water;

   /* Constructor */
   Block() {
   }

   Block(String path) {
      this.setIcon(new ImageIcon(path));
   }

   /* Method */

   // (1) Position Method
   public void setPos(int y, int x) {
      this.arrY = y;
      this.arrX = x;
   }

   public int getArrX() {
      return this.arrX;
   }

   public int getArrY() {
      return this.arrY;
   }

   // (2) this push b
   // this move
   public void moveBlock(int weightX, int weightY) {

      int oldX = this.getArrX();
      int oldY = this.getArrY();

      stageBlockArr.setNewPosition(this, oldY, oldX, oldY + weightY, oldX + weightX);

      // Changing the object's member variable
      this.setPos(this.getArrY() + weightY, this.getArrX() + weightX);

      // Redraw the location of the object
      this.setLocation(this.getX() + 60 * weightX, this.getY() + 60 * weightY);

      // stageBlockArr.printArray();
   }

   // Method : this move
   public boolean moveProcess(int weightX, int weightY) {

      // The space to move does not exist in the frame
      if (!this.checkNextInFrame(weightX, weightY))
         return false;

      // The space to move exists in the frame
      // next block does not exists -> this move

      if (this.checkNextIsNull(weightX, weightY)) {
         this.moveBlock(weightX, weightY);
         return true;
      }

      // The space to move exists in the frame
      // next block exists
      // next block can move

      // Set Next Stage
      if (this instanceof ObjBlock
            && stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof ObjBlock) {
         ObjBlock nextBlock = (ObjBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
         if (((ObjBlock) this).isYou() && nextBlock.isWin()) {
            MainFrame.ms.nextStage();
         }
      }

      // stage3 : water_reset Stage
      if (stage3Panel != null) {
         if (this instanceof ObjBlock
               && stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof ObjBlock) {
            ObjBlock nextBlock = (ObjBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
            if (((ObjBlock) this).isYou() && nextBlock.isDefeat()) {
               MainFrame.ms.resetStage();
            }
         }
      }

      if (this.checkNextPushable(weightX, weightY)) {

         // push next block
         if (!stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX].moveProcess(weightX,
               weightY)) {
            return false;
         }
         this.moveBlock(weightX, weightY);

         // Check Unset
         this.checkUnset();

         return true;
      }

      return false;
   }

   public boolean checkNextPushable(int weightX, int weightY) {
      // Check if the next block is movable
      if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX].isPushable) {
         return true;
      } else {
         return false;
      }
   }

   // Check next block exists
   public boolean checkNextIsNull(int weightX, int weightY) {
      if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] == null) {
         return true;
      }
      return false;
   }

   // Check the next block moving in the frame
   public boolean checkNextInFrame(int weightX, int weightY) {

      // check_X
      if (this.getArrX() + weightX < 0 || this.getArrX() + weightX > ConstClass.ARRAY_X - 1) {
         return false;
      }

      // check_Y
      if (this.getArrY() + weightY < 0 || this.getArrY() + weightY > ConstClass.ARRAY_Y - 1) {
         return false;
      }

      return true;
   }

   // (3) getter/setter
   public void setIsPushable(boolean isPushable) {
      this.isPushable = isPushable;
   }

   // (4) Check Unset
   public void checkUnset() {

      this.unsetAllObject();

      // 모든 객체에 대해서 점검
      for (Block[] b1 : stageBlockArr.array) {
         for (Block b2 : b1) {
            if (b2 instanceof WordBlock) {

               // Type Casting
               WordBlock subBlock = (WordBlock) b2;

               // the object is a subject
               if (subBlock.isSubject()) {

                  // 동쪽 +1 블록이 동사일 경우
                  if (subBlock.checkNextFNW(1, 0) && subBlock.isWeightVerb(1, 0)) {

                     // 동쪽 +2 블록이 보어일 경우
                     if (subBlock.checkNextFNW(2, 0) && subBlock.isWeightComplement(2, 0)) {

                        // dodo setting
                        if (this.dodo.getText().equals(subBlock.getText().toUpperCase())) {
                           // win setting
                           if (subBlock.getWeightBlock(2, 0).getText().equals("w"))
                              this.dodo.setWin(true);

                           // you setting
                           if (subBlock.getWeightBlock(2, 0).getText().equals("y"))
                              this.dodo.setYou(true);
                        }
                        // fish setting
                        else if (this.fish.getText().equals(subBlock.getText().toUpperCase())) {
                           // win setting
                           if (subBlock.getWeightBlock(2, 0).getText().equals("w"))
                              this.fish.setWin(true);

                           // you setting
                           if (subBlock.getWeightBlock(2, 0).getText().equals("y"))
                              this.fish.setYou(true);

                           if (subBlock.getWeightBlock(2, 0).getText().equals("m"))
                              this.fish.setMove(true);
                        }
                        // toy setting
                        else if (this.toy.getText().equals(subBlock.getText().toUpperCase())) {
                           // win setting
                           if (subBlock.getWeightBlock(2, 0).getText().equals("w"))
                              this.toy.setWin(true);

                           // you setting
                           if (subBlock.getWeightBlock(2, 0).getText().equals("y"))
                              this.toy.setYou(true);
                        }
                     }
                  }

                  // 남쪽 +1 블록이 동사일 경우
                  else if (subBlock.checkNextFNW(0, 1) && subBlock.isWeightVerb(0, 1)) {

                     // 남쪽 +2 블록이 보어일 경우
                     if (subBlock.checkNextFNW(0, 2) && subBlock.isWeightComplement(0, 2)) {
                        // dodo setting
                        if (this.dodo.getText().equals(subBlock.getText().toUpperCase())) {
                           // win setting
                           if (subBlock.getWeightBlock(0, 2).getText().equals("w"))
                              this.dodo.setWin(true);

                           // you setting
                           if (subBlock.getWeightBlock(0, 2).getText().equals("y"))
                              this.dodo.setYou(true);
                        }
                        // fish setting
                        else if (this.fish.getText().equals(subBlock.getText().toUpperCase())) {
                           // win setting
                           if (subBlock.getWeightBlock(0, 2).getText().equals("w"))
                              this.fish.setWin(true);

                           // you setting
                           if (subBlock.getWeightBlock(0, 2).getText().equals("y"))
                              this.fish.setYou(true);

                           if (subBlock.getWeightBlock(2, 0).getText().equals("m"))
                              this.fish.setMove(true);
                        }
                        // toy setting
                        else if (this.toy.getText().equals(subBlock.getText().toUpperCase())) {
                           // win setting
                           if (subBlock.getWeightBlock(0, 2).getText().equals("w"))
                              this.toy.setWin(true);

                           // you setting
                           if (subBlock.getWeightBlock(0, 2).getText().equals("y"))
                              this.toy.setYou(true);
                        }
                     }
                  }

               }

            }
         }
      }

   }

   // (5) Unset All Object8
   public void unsetAllObject() {

      // dodo
      dodo.setYou(false);
      dodo.setWin(false);
      dodo.setMove(false);

      // fish
      fish.setYou(false);
      fish.setWin(false);
      fish.setMove(false);

      // toy
      if (stage2Panel != null) {
         toy.setYou(false);
         toy.setWin(false);
         toy.setMove(false);
      }

   }

   // (6) Get Weight Block
   public Block getWeightBlock(int weightX, int weightY) {
      return stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
   }

   // (7) Set dodo, fish, toy
   public void setObjects(JPanel stagePanel) {
      // JPanel 꽕 젙
      if (stagePanel instanceof Stage1Panel) {
         this.stage1Panel = (Stage1Panel) stagePanel;
         this.dodo = Stage1Panel.dodo;
         this.fish = Stage1Panel.fish;
      } else if (stagePanel instanceof Stage2Panel) {
         this.stage2Panel = (Stage2Panel) stagePanel;
         this.dodo = Stage2Panel.dodo;
         this.fish = Stage2Panel.fish;
         this.toy = Stage2Panel.toy;
      } else if (stagePanel instanceof Stage3Panel) {
         this.stage3Panel = (Stage3Panel) stagePanel;
         this.dodo = Stage3Panel.dodo;
         this.fish = Stage3Panel.fish;
         this.toy = Stage3Panel.toy;
         this.water = Stage3Panel.water;
         for (int i = 0; i < this.water.length; i++) {
            this.water[i].setWater(true);
         }
      }
   }

}

@SuppressWarnings("serial")
class WordBlock extends Block {

   /* Private member variable */
   private boolean isSubject;
   private boolean isVerb;
   private boolean isComplement;

   ManageListener manageListener;

   /* Constructor */
   WordBlock() {

   }

   WordBlock(String path, StageBlockArray stageBlockArr, ManageListener manageListener) {
      this.setIcon(new ImageIcon(path));
      this.stageBlockArr = stageBlockArr;
      this.manageListener = manageListener;
   }

   WordBlock(String path, StageBlockArray stageBlockArr, ManageListener manageListener, String str) {

      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage();
      Image changeImg = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
      ImageIcon chanIcon = new ImageIcon(changeImg);

      this.setIcon(chanIcon);
      this.stageBlockArr = stageBlockArr;
      this.manageListener = manageListener;
   }

   /* Method */
   // Set Character Properties
   public void setSubject() {
      this.isSubject = true;
   }

   public void setVerb() {
      this.isVerb = true;
   }

   public void setComplement() {
      this.isComplement = true;
   }

   public boolean isSubject() {
      return this.isSubject;
   }

   public boolean isVerb() {
      return this.isVerb;
   }

   public boolean isComplement() {
      return this.isComplement;
   }

   // check weightX, weightY
   public boolean isWeightSubject(int weightX, int weightY) {
      if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof WordBlock) {
         return ((WordBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX]).isSubject();
      }
      return false;
   }

   public boolean isWeightVerb(int weightX, int weightY) {
      if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof WordBlock) {
         return ((WordBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX]).isVerb();
      }
      return false;
   }

   public boolean isWeightComplement(int weightX, int weightY) {
      if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof WordBlock) {
         return ((WordBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX]).isComplement();
      }
      return false;
   }

   public boolean checkNextFNW(int weightX, int weightY) {
      // Check if the next block is in the frame
      if (!this.checkNextInFrame(weightX, weightY))
         return false;

      // Check if the next block exists
      if (this.checkNextIsNull(weightX, weightY)) {
         return false;
      }
      // Check if the next block is WordBlock
      if (!(stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof WordBlock))
         return false;

      return true;
   }
}

@SuppressWarnings("serial")
class ObjBlock extends Block {

   /* Private member variable */
   private boolean isYou;
   private boolean isWin;
   private boolean isMove;
   private boolean isWater = false;

   ManageListener manageListener;

   Timer timer = null;

   /* Constructor */
   ObjBlock() {

   }

   ObjBlock(String path, StageBlockArray stageBlockArr, ManageListener manageListener) {
      this.setIcon(new ImageIcon(path));
      this.stageBlockArr = stageBlockArr;
      this.manageListener = manageListener;
   }

   ObjBlock(String path, StageBlockArray stageBlockArr, ManageListener manageListener, String str) {

      ImageIcon icon = new ImageIcon(path);
      Image img = icon.getImage();
      Image changeImg = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
      ImageIcon chanIcon = new ImageIcon(changeImg);

      this.setIcon(chanIcon);
      this.stageBlockArr = stageBlockArr;
      this.manageListener = manageListener;

   }

   /* Method */

   public void setYou(boolean flag) {
      this.isYou = flag;

      for (YouKeyListener ykl : ManageListener.YouKeyListenerList) {
         ManageListener.contentpane.removeKeyListener(ykl);
      }

      if (flag) {

         YouKeyListener ykl = new YouKeyListener(this);

         ManageListener.contentpane.addKeyListener(ykl);

         ManageListener.addYouKeyListener(ykl);
      }
   }

   public void setWin(boolean flag) {
      this.isWin = flag;
   }

   public boolean isWin() {
      return this.isWin;
   }

   public boolean isYou() {
      return this.isYou;
   }

   public boolean isDefeat() {
      return this.isWater;
   }

   public void setWater(boolean b) {
      this.isWater = b;
   }

   public void setisYou(boolean b) {
      this.isYou = b;
   }

   public boolean isMove() {
      return this.isMove;
   }

   public void setMove(boolean flag) {
      this.isMove = flag;

      ImageIcon icon_left = new ImageIcon("img/fish_left.png");
      Image img_left = icon_left.getImage();
      Image changeImg_left = img_left.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
      ImageIcon changeIcon_left = new ImageIcon(changeImg_left);

      ImageIcon icon_right = new ImageIcon("img/fish_right.png");
      Image img_right = icon_right.getImage();
      Image changeImg_right = img_right.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
      ImageIcon changeIcon_right = new ImageIcon(changeImg_right);

      if (stage3Panel != null) {
         if (flag) {
            fish.timer = new Timer();
            TimerTask task = new TimerTask() {

               int cnt = 0;

               @Override
               public void run() {

                  int weightX = 0;
                  int weightY = 0;

                  if (cnt % 4 == 0) {
                     weightX = -1;
                     fish.setIcon(changeIcon_left);
                     fish.moveBlock(weightX, weightY);
                  } else if (cnt % 4 == 1) {
                     weightY = 1;
                     fish.moveBlock(weightX, weightY);
                  } else if (cnt % 4 == 2) {
                     weightX = 1;
                     fish.setIcon(changeIcon_right);
                     fish.moveBlock(weightX, weightY);
                  } else if (cnt % 4 == 3) {
                     weightY = -1;
                     fish.moveBlock(weightX, weightY);
                  }
                  cnt++;
               }

            };
            fish.timer.schedule(task, 0, 500);
         } else {
            if (fish.timer != null)
               fish.timer.cancel();
         }
      }

   }

}