package oop_project4_dodo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class YouKeyListener1 extends KeyAdapter {

	ObjBlock you;

	YouKeyListener1(ObjBlock you) {
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
			case 'R':
				MainFrame.ms.resetStage();
				return;
			default:
				return;
		}

		// You가 움직이기
		you.moveProcess(weightX, weightY);
	}

}
