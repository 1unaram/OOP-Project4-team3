package oop_project4_dodo;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
class ObjBlock extends Block {

    /* Private Member Variables */
    private boolean isYou;
    private boolean isWin;
    private boolean isMove;
    private boolean isWater = false;

    ManageListener manageListener;

    Timer timer = null;

    /* Constructor */
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
