package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IntroPanel extends JPanel {

	Container contentpane;

	ObjBlock dodo;
	WordBlock _is;
	WordBlock _win;

	static StageBlockArray BlockArr;

	IntroPanel(Container cp) {
		contentpane = cp;
		BlockArr = new StageBlockArray();

		this.setBackground(Color.BLACK);
		this.setBounds(10, 10, ConstClass.FRAME_WIDTH, ConstClass.FRAME_HEIGHT);
		this.setVisible(true);

		initIntro();
		playIntro();

	}

	public void initIntro() {

		dodo = new ObjBlock("img/dodo_right.png", BlockArr, null, "Big");
		_is = new WordBlock("img/_is.png", BlockArr, null, "Big");
		_win = new WordBlock("img/_you.png", BlockArr, null, "Big");

		dodo.setBounds(330, 180, 120, 120);
		_is.setBounds(570, 300, 120, 120);
		_win.setBounds(690, 300, 120, 120);

		this.add(dodo);
		this.add(_is);
		this.add(_win);

	}

	public void playIntro() {
		Timer t1 = new Timer();

		ImageIcon icon_down = new ImageIcon("img/dodo_down.png");
		Image img_down = icon_down.getImage();
		Image changeImg_down = img_down.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon changeIcon_down = new ImageIcon(changeImg_down);
		
		ImageIcon icon_right = new ImageIcon("img/dodo_right.png");
		Image img_right = icon_right.getImage();
		Image changeImg_right = img_right.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon changeIcon_right = new ImageIcon(changeImg_right);

		TimerTask task1 = new TimerTask() {

			int i = 0, j = 0, cnt = 0;

			@Override
			public void run() {

				if (cnt < 7) {
					if (cnt < 3) {
						dodo.setIcon(changeIcon_down);
						dodo.setLocation(270, 180 + 60 * i);
						i++;
					} else {
						dodo.setIcon(changeIcon_right);
						dodo.setLocation(270 + 60 * j, 300);
						j++;
					}
					cnt++;
				} else {
					initStage1();
					t1.cancel();
				}
			}
		};

		t1.schedule(task1, 0, 500);
	}

	public void initStage1() {

		this.removeAll();
		contentpane.removeAll();
		contentpane.repaint();
		contentpane.add(new Stage1Panel(contentpane));
		contentpane.repaint();

	}

}
