package oop_project4_dodo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

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
				// this.reverseYou(0);
				break;
			case KeyEvent.VK_DOWN:
				weightY = 1;
				// this.reverseYou(1);
				break;
			case KeyEvent.VK_LEFT:
				weightX = -1;
				this.reverseYou(2);
				break;
			case KeyEvent.VK_RIGHT:
				weightX = 1;
				this.reverseYou(3);
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

	public void reverseYou(int direction) {
		// 상하좌우 : 0123
		switch (direction) {
			case 0:
				if (you.getText().equals("D")) {
					you.setIcon(new ImageIcon("img/dodo_up.png"));
				} else if (you.getText().equals("F")) {
					you.setIcon(new ImageIcon("img/fish_right.png"));
				}
				break;
			case 1:
				if (you.getText().equals("D")) {
					you.setIcon(new ImageIcon("img/dodo_down.png"));
				} else if (you.getText().equals("F")) {
					you.setIcon(new ImageIcon("img/fish_right.png"));
				}
				break;
			case 2:
				if (you.getText().equals("D")) {
					you.setIcon(new ImageIcon("img/dodo_left.png"));
				} else if (you.getText().equals("F")) {
					you.setIcon(new ImageIcon("img/fish_left.png"));
				}
				break;
			case 3:
				if (you.getText().equals("D")) {
					you.setIcon(new ImageIcon("img/dodo_right.png"));
				} else if (you.getText().equals("F")) {
					you.setIcon(new ImageIcon("img/fish_right.png"));
				}
		}

	}

}
