package oop_project4_dodo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Grasses  {
    
    Grasses(Stage1Panel panel) {
        panel.add(new Grass(1, 2));
        panel.add(new Grass(9, 2));
        panel.add(new Grass(2, 4));
        panel.add(new Grass(10, 5));
        panel.add(new Grass(4, 7));
        panel.add(new Grass(8, 9));
        panel.add(new Grass(7, 12));
        panel.add(new Grass(8, 14));
        panel.add(new Grass(2, 15));
        panel.add(new Grass(10, 18));
        panel.add(new Grass(6, 19));
        panel.add(new Grass(3, 20));
        panel.add(new Grass(0, 22));
    }

    Grasses(Stage2Panel panel) {
        panel.add(new Grass(0, 2));
        panel.add(new Grass(8, 4));
        panel.add(new Grass(4, 3));
        panel.add(new Grass(11, 6));
        panel.add(new Grass(4, 8));
        panel.add(new Grass(7, 10));
        panel.add(new Grass(6, 11));
        panel.add(new Grass(9, 13));
        panel.add(new Grass(1, 14));
        panel.add(new Grass(9, 19));
        panel.add(new Grass(4, 16));
        panel.add(new Grass(3, 21));
        panel.add(new Grass(0, 22));
    }
    
    Grasses(Stage3Panel panel) {
        panel.add(new Grass(2, 3));
        panel.add(new Grass(7, 5));
        panel.add(new Grass(1, 4));
        panel.add(new Grass(9, 6));
        panel.add(new Grass(5, 7));
        panel.add(new Grass(8, 8));
        panel.add(new Grass(5, 12));
        panel.add(new Grass(7, 13));
        panel.add(new Grass(4, 15));
        panel.add(new Grass(9, 18));
        panel.add(new Grass(6, 17));
        panel.add(new Grass(3, 20));
        panel.add(new Grass(0, 21));
    }

    class Grass extends JLabel {

        Grass(int y, int x) {
            ImageIcon icon = new ImageIcon("img/grass.png");
            Image img = icon.getImage();
            Image changeImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon changeIcon = new ImageIcon(changeImg);
            this.setIcon(changeIcon);
            this.setBounds(x * 50, y * 60, 30, 30);
        }
    }
}
