package oop_project4_dodo;

import java.util.ArrayList;
import java.awt.Container;

public class ManageListener {

    ArrayList<YouKeyListener> youKeyListenerList = new ArrayList<YouKeyListener>();
    Container contentpane;

    ManageListener(Container contentpane) {
        this.contentpane = contentpane;
    }

    public void addYouKeyListener(YouKeyListener ykl) {
        youKeyListenerList.add(ykl);
    }
}
