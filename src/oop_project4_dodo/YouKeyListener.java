package oop_project4_dodo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class YouKeyListener extends KeyAdapter {
	
	ObjBlock you;
	
	YouKeyListener(ObjBlock you) {
		this.you = you;
	}
	
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
        
        // 상
        case KeyEvent.VK_UP:
        	if(you.checkMovable(keyCode)) {
        		you.setLocation(you.getX(), you.getY() - 60);
        	}
        	
            if(you.getY() > 0) {
            	if(you.checkPushable(KeyEvent.VK_UP)) {            		
            		you.setLocation(you.getX(), you.getY() - 60);
            	}
            }
            break;
        
        // 하
        case KeyEvent.VK_DOWN:
            if(you.getY() < 600) {
            	if(you.checkPushable(KeyEvent.VK_DOWN)) {            		
            		you.setLocation(you.getX(), you.getY() + 60);
            	}
            }
            break;
            
        // 좌
        case KeyEvent.VK_LEFT:
            if(you.getX() > 0) {
            	if(you.checkPushable(KeyEvent.VK_LEFT)) {            		
            		you.setLocation(you.getX() - 60, you.getY());
            	}
            }
            break;
            
        // 우
        case KeyEvent.VK_RIGHT:
            if(you.getX() < 1140) {
            	if(you.checkPushable(KeyEvent.VK_RIGHT)) {            		
            		you.setLocation(you.getX() + 60, you.getY());
            	}
            }

        }
    }
 
}