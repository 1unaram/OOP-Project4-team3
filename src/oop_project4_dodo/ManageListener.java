package oop_project4_dodo;

import java.util.ArrayList;
import java.awt.Container;

public class ManageListener {

    ArrayList<YouKeyListener1> YouKeyListener1List = new ArrayList<YouKeyListener1>();
    Container contentpane;

    ManageListener(Container contentpane) {
        this.contentpane = contentpane;
    }

    public void addYouKeyListener1(YouKeyListener1 ykl) {
        YouKeyListener1List.add(ykl);
    }
}
