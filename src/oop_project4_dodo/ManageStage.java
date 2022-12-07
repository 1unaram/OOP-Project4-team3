package oop_project4_dodo;

import java.awt.Container;

public class ManageStage {

    int stageNum;
    Container contentpane;

    ManageStage(Container contentpane) {
        stageNum = 1;
        this.contentpane = contentpane;
    }

    public void nextStage() {

        switch (stageNum) {
            case 1:
                this.resetContentpane();
                contentpane.add(new Stage2Panel(contentpane));
                contentpane.repaint();
                break;
            case 2:
                this.resetContentpane();
                contentpane.add(new Stage3Panel(contentpane));
                contentpane.repaint();
                break;
            case 3:
                this.resetContentpane();
                contentpane.add(new EndPanel(contentpane));
                contentpane.repaint();
                break;
        }
        stageNum++;
    }

    public void resetStage() {
        switch (stageNum) {
            case 1:
                this.resetContentpane();
                contentpane.add(new Stage1Panel(contentpane));
                contentpane.repaint();
                break;
            case 2:
                this.resetContentpane();
                contentpane.add(new Stage2Panel(contentpane));
                contentpane.repaint();
                break;
            case 3:
                this.resetContentpane();
                contentpane.add(new Stage3Panel(contentpane));
                contentpane.repaint();
                break;
        }
    }

    public void resetContentpane() {

        ManageListener.removeAllListener();

        contentpane.removeAll();
        contentpane.repaint();
    }
}
