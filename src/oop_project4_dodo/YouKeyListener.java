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
		if (you.moveProcess(weightX, weightY)) {

			// 블록이 움직였을 때만
		}

		// sentence 완성 여부 확인 & 멤버변수 set 해주기
		if (you.checkNextInFrame(weightX, weightY)) {
			if (you.stageBlockArr.array[you.getArrY() + weightY][you.getArrX() + weightX] instanceof WordBlock) {
				((WordBlock) you.stageBlockArr.array[you.getArrY() + weightY][you.getArrX() + weightX])
						.checkSenstence();
			}
		} else {
			return;
		}
	}

}