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

		int weightX = 0;
		int weightY = 0;

		switch (keyCode) {

			case KeyEvent.VK_UP:
				weightY = -1;
				break;
			case KeyEvent.VK_DOWN:
				weightY = 1;
				break;
			case KeyEvent.VK_LEFT:
				weightX = -1;
				break;
			case KeyEvent.VK_RIGHT:
				weightX = 1;
				break;
			default:
				return;
		}

		// You가 움직이기
		you.moveProcess(weightX, weightY);

	}

}
