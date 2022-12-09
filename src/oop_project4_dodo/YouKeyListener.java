package oop_project4_dodo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class YouKeyListener extends KeyAdapter {

	/* Member Variables */
	ObjBlock you;

	/* Constructor */
	YouKeyListener(ObjBlock you) {
		this.you = you;
	}

	/* Methods */
	// Manage Key Event
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();
		int weightX = 0;
		int weightY = 0;

		switch (keyCode) {
			case KeyEvent.VK_UP:
				weightY = -1;
				this.reverseYou(0);
				break;
			case KeyEvent.VK_DOWN:
				weightY = 1;
				this.reverseYou(1);
				break;
			case KeyEvent.VK_LEFT:
				weightX = -1;
				this.reverseYou(2);
				break;
			case KeyEvent.VK_RIGHT:
				weightX = 1;
				this.reverseYou(3);
				break;
			default:
				return;
		}

		// Move You
		you.moveProcess(weightX, weightY);
	}

	// Reverse You's Image
	public void reverseYou(int direction) {
		switch (direction) {
			// Up
			case 0:
				if (you.getText().equals("D")) {
					you.setIcon(new ImageIcon("img/dodo_up.png"));
				} else if (you.getText().equals("F")) {
					you.setIcon(new ImageIcon("img/fish_right.png"));
				}
				break;
			// Down
			case 1:
				if (you.getText().equals("D")) {
					you.setIcon(new ImageIcon("img/dodo_down.png"));
				} else if (you.getText().equals("F")) {
					you.setIcon(new ImageIcon("img/fish_right.png"));
				}
				break;
			// Left
			case 2:
				if (you.getText().equals("D")) {
					you.setIcon(new ImageIcon("img/dodo_left.png"));
				} else if (you.getText().equals("F")) {
					you.setIcon(new ImageIcon("img/fish_left.png"));
				}
				break;
			// Right
			case 3:
				if (you.getText().equals("D")) {
					you.setIcon(new ImageIcon("img/dodo_right.png"));
				} else if (you.getText().equals("F")) {
					you.setIcon(new ImageIcon("img/fish_right.png"));
				}
		}
	}

}
