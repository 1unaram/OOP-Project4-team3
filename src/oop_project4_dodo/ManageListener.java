package oop_project4_dodo;

import java.util.ArrayList;
import java.awt.Container;

public class ManageListener {

    static ArrayList<YouKeyListener> YouKeyListenerList = new ArrayList<YouKeyListener>();
    static Container contentpane;

    ManageListener(Container contentpane) {
        ManageListener.contentpane = contentpane;
    }

    static public void addYouKeyListener(YouKeyListener ykl) {
        YouKeyListenerList.add(ykl);
    }

    static public void removeAllListener() {
        for (YouKeyListener ykl : YouKeyListenerList) {
            contentpane.removeKeyListener(ykl);
        }
    }

}
