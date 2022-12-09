package oop_project4_dodo;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
class ObjBlock extends Block {

    /* Private Member Variables */
    // private
    private boolean isYou;
    private boolean isWin;
    private boolean isMove;
    private boolean isDefeat = false;

    // public
    Timer timer = null;

    /* Constructor */
    ObjBlock(String path, StageBlockArray stageBlockArr) {
        this.setIcon(new ImageIcon(path));
        this.stageBlockArr = stageBlockArr;
    }

    ObjBlock(String path, StageBlockArray stageBlockArr, String str) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image changeImg = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon chanIcon = new ImageIcon(changeImg);

        this.setIcon(chanIcon);
        this.stageBlockArr = stageBlockArr;
    }

    /* Method */
    // Set Character Properties
    public void setYou(boolean flag) {
        this.isYou = flag;

        // Change KeyListener for You
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

    public void setisYou(boolean b) {
        this.isYou = b;
    }

    public boolean isYou() {
        return this.isYou;
    }

    public void setMove(boolean flag) {
        this.isMove = flag;

        ImageIcon changeIcon_left = new ImageIcon("img/fish_left.png");
        ImageIcon changeIcon_right = new ImageIcon("img/fish_right.png");

        if (stage3Panel != null) {
            if (flag) {
                fish.timer = new Timer();
                TimerTask task = new TimerTask() {

                    int cnt = 0;

                    @Override
                    public void run() {

                        int weightX = 0;
                        int weightY = 0;

                        // Left
                        if (cnt % 4 == 0) {
                            weightX = -1;
                            fish.setIcon(changeIcon_left);
                            fish.moveBlock(weightX, weightY);
                        }
                        // Down
                        else if (cnt % 4 == 1) {
                            weightY = 1;
                            fish.moveBlock(weightX, weightY);
                        }
                        // Right
                        else if (cnt % 4 == 2) {
                            weightX = 1;
                            fish.setIcon(changeIcon_right);
                            fish.moveBlock(weightX, weightY);
                        }
                        // Up
                        else if (cnt % 4 == 3) {
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

    public boolean isMove() {
        return this.isMove;
    }

    public void setDefeat(boolean b) {
        this.isDefeat = b;
    }

    public boolean isDefeat() {
        return this.isDefeat;
    }
}
