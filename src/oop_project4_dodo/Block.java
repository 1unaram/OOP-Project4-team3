package oop_project4_dodo;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Block extends JLabel {

   /* Member Variables */
   // private
   private String name;
   private boolean isPushable = true;
   private int arrX;
   private int arrY;

   // public
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
   // (1) Getter, Setter
   public int getArrX() {
      return this.arrX;
   }

   public int getArrY() {
      return this.arrY;
   }

   public void setText(String name) {
      this.name = name;
   }

   public String getText() {
      return this.name;
   }

   public void setIsPushable(boolean isPushable) {
      this.isPushable = isPushable;
   }

   public Block getWeightBlock(int weightX, int weightY) {
      return stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
   }

   // (2) Position Method
   public void setPos(int y, int x) {
      this.arrY = y;
      this.arrX = x;
   }

   // (3) this push next block
   // Set block position to be moved
   public void moveBlock(int weightX, int weightY) {
      int oldX = this.getArrX();
      int oldY = this.getArrY();

      this.stageBlockArr.setNewPosition(this, oldY, oldX, oldY + weightY, oldX + weightX);

      // Change the object's member variable
      this.setPos(this.getArrY() + weightY, this.getArrX() + weightX);

      // Redraw the location of the object
      this.setLocation(this.getX() + 60 * weightX, this.getY() + 60 * weightY);
   }

   // (4) Check whether the next block is moveable and move
   public boolean moveProcess(int weightX, int weightY) {
      // Check block is in frame
      if (!this.checkNextInFrame(weightX, weightY))
         return false;

      // next block does not exists -> this move
      if (this.checkNextIsNull(weightX, weightY)) {
         this.moveBlock(weightX, weightY);
         return true;
      }

      // Now, next block can move

      // a. Set Next Stage
      if (this instanceof ObjBlock
            && stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof ObjBlock) {
         ObjBlock nextBlock = (ObjBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
         if (((ObjBlock) this).isYou() && nextBlock.isWin()) {
            MainFrame.ms.nextStage();
         }
      }

      // b. stage3 : water_reset Stage
      if (stage3Panel != null) {
         if (this instanceof ObjBlock
               && stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof ObjBlock) {
            ObjBlock nextBlock = (ObjBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
            if (((ObjBlock) this).isYou() && nextBlock.isDefeat()) {
               MainFrame.ms.resetStage();
            }
         }
      }

      // c. Check next block is pushable - recursive
      if (this.checkNextPushable(weightX, weightY)) {
         // push next block
         if (!stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX].moveProcess(weightX,
               weightY)) {
            return false;
         }
         this.moveBlock(weightX, weightY);

         // Check Unset and Set
         this.checkUnset();

         return true;
      }

      return false;
   }

   // (5) Check Next Block is Pushable
   public boolean checkNextPushable(int weightX, int weightY) {
      // Check if the next block is movable
      if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX].isPushable) {
         return true;
      } else {
         return false;
      }
   }

   // (6) Check Next Block exists
   public boolean checkNextIsNull(int weightX, int weightY) {
      if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] == null) {
         return true;
      }
      return false;
   }

   // (7) Check the next block is in the frame
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

   // (8) Check Unset and Set
   public void checkUnset() {
      // First, unset all object
      this.unsetAllObject();

      // Second, check and set all object
      for (Block[] b1 : stageBlockArr.array) {
         for (Block b2 : b1) {
            if (b2 instanceof WordBlock) {

               // Type Casting
               WordBlock subBlock = (WordBlock) b2;

               // the object is a subject
               if (subBlock.isSubject()) {

                  // 1. Right+1 is a verb
                  if (subBlock.checkNextFNW(1, 0) && subBlock.isWeightVerb(1, 0)) {

                     // 1-A. Right+2 is a complement
                     if (subBlock.checkNextFNW(2, 0) && subBlock.isWeightComplement(2, 0)) {

                        // 1-A-a. Set dodo
                        if (this.dodo.getText().equals(subBlock.getText().toUpperCase())) {
                           // Set win
                           if (subBlock.getWeightBlock(2, 0).getText().equals("w"))
                              this.dodo.setWin(true);

                           // Set you
                           if (subBlock.getWeightBlock(2, 0).getText().equals("y"))
                              this.dodo.setYou(true);
                        }
                        // 1-A-b. Set fish
                        else if (this.fish.getText().equals(subBlock.getText().toUpperCase())) {
                           // Set win
                           if (subBlock.getWeightBlock(2, 0).getText().equals("w"))
                              this.fish.setWin(true);

                           // Set you
                           if (subBlock.getWeightBlock(2, 0).getText().equals("y"))
                              this.fish.setYou(true);

                           // Set move
                           if (subBlock.getWeightBlock(2, 0).getText().equals("m"))
                              this.fish.setMove(true);
                        }
                        // 1-A-c. Set toy
                        else if (this.toy.getText().equals(subBlock.getText().toUpperCase())) {
                           // Set win
                           if (subBlock.getWeightBlock(2, 0).getText().equals("w"))
                              this.toy.setWin(true);

                           // Set you
                           if (subBlock.getWeightBlock(2, 0).getText().equals("y"))
                              this.toy.setYou(true);
                        }
                     }
                  }

                  // 2. Down+1 is a verb
                  else if (subBlock.checkNextFNW(0, 1) && subBlock.isWeightVerb(0, 1)) {

                     // 2-A. Down+2 is a complement
                     if (subBlock.checkNextFNW(0, 2) && subBlock.isWeightComplement(0, 2)) {
                        // 2-A-a. Set dodo
                        if (this.dodo.getText().equals(subBlock.getText().toUpperCase())) {
                           // Set win
                           if (subBlock.getWeightBlock(0, 2).getText().equals("w"))
                              this.dodo.setWin(true);

                           // Set you
                           if (subBlock.getWeightBlock(0, 2).getText().equals("y"))
                              this.dodo.setYou(true);
                        }
                        // 2-A-b. Set fish
                        else if (this.fish.getText().equals(subBlock.getText().toUpperCase())) {
                           // Set win
                           if (subBlock.getWeightBlock(0, 2).getText().equals("w"))
                              this.fish.setWin(true);

                           // Set you
                           if (subBlock.getWeightBlock(0, 2).getText().equals("y"))
                              this.fish.setYou(true);

                           // Set move
                           if (subBlock.getWeightBlock(2, 0).getText().equals("m"))
                              this.fish.setMove(true);
                        }
                        // 2-A-c. Set toy
                        else if (this.toy.getText().equals(subBlock.getText().toUpperCase())) {
                           // Set win
                           if (subBlock.getWeightBlock(0, 2).getText().equals("w"))
                              this.toy.setWin(true);

                           // Set you
                           if (subBlock.getWeightBlock(0, 2).getText().equals("y"))
                              this.toy.setYou(true);
                        }
                     }
                  }

               }

            }
            // inner loop break
         }
         // outer loop break
      }
   }

   // (9) Unset All Objects
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

   // (10) Set dodo, fish, toy
   public void setObjects(JPanel stagePanel) {
      // Distinction of stage
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
