package oop_project4_dodo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class YouKeyListener extends KeyAdapter {
	
	Block you;
	
	YouKeyListener(Block you) {
		this.you = you;
	}
	
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
        case KeyEvent.VK_UP:
            if(you.getY() > 0) {
                you.setLocation(you.getX(), you.getY() - 60);
            }
            break;
        case KeyEvent.VK_DOWN:
            if(you.getY() < 600) {
                you.setLocation(you.getX(), you.getY() + 60);
            }
            break;
        case KeyEvent.VK_LEFT:
            if(you.getX() > 0) {
                you.setLocation(you.getX() - 60, you.getY());
            }
            break;
        case KeyEvent.VK_RIGHT:
            if(you.getX() < 1140) {
                you.setLocation(you.getX() + 60, you.getY());
            }

        }
    }
}