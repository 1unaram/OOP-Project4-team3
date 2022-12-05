package oop_project4_dodo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

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
				System.out.println("Retry");
				// stagePanel.contentpane.remove(stagePanel);
				// Stage1Panel newPanel = new Stage1Panel(stagePanel.contentpane);
				// stagePanel.contentpane.add(newPanel);
				// stagePanel.contentpane.removeKeyListener(this);
				return;
			default:
				return;
		}

		// You가 움직이기
		you.moveProcess(weightX, weightY);

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
