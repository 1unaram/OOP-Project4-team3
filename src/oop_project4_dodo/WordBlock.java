package oop_project4_dodo;

import java.awt.Image;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
class WordBlock extends Block {

    /* Private Member Variables */
    // private
    private boolean isSubject;
    private boolean isVerb;
    private boolean isComplement;

    // public
    ManageListener manageListener;

    /* Constructor */
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
