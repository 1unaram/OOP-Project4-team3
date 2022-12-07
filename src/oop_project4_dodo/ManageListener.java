package oop_project4_dodo;

import java.util.ArrayList;
import java.awt.Container;

public class ManageListener {

    /* Member Variables */
    static ArrayList<YouKeyListener> YouKeyListenerList = new ArrayList<YouKeyListener>();
    static Container contentpane;

    /* Constructor */
    ManageListener(Container contentpane) {
        ManageListener.contentpane = contentpane;
    }

    // Add You Listener
    static public void addYouKeyListener(YouKeyListener ykl) {
        YouKeyListenerList.add(ykl);
    }

    // Remove All Listener
    static public void removeAllListener() {
        for (YouKeyListener ykl : YouKeyListenerList) {
            contentpane.removeKeyListener(ykl);
        }
    }

}
