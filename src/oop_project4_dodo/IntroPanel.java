package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IntroPanel extends JPanel {

	Container contentpane;

	ObjBlock dodo;
	WordBlock _is;
	WordBlock _you;

	static StageBlockArray BlockArr;

	/* Constructor */
	IntroPanel(Container cp) {
		contentpane = cp;
		BlockArr = new StageBlockArray();

		this.setBackground(Color.BLACK);
		this.setBounds(10, 10, ConstClass.FRAME_WIDTH, ConstClass.FRAME_HEIGHT);
		this.setVisible(true);

		initIntro();
		playIntro();
	}

	/* Method */
	// Initialize Intro Panel
	public void initIntro() {
		dodo = new ObjBlock("img/dodo_right.png", BlockArr, "Big");
		_is = new WordBlock("img/_is.png", BlockArr, "Big");
		_you = new WordBlock("img/_you.png", BlockArr, "Big");

		dodo.setBounds(330, 180, 120, 120);
		_is.setBounds(570, 300, 120, 120);
		_you.setBounds(690, 300, 120, 120);

		this.add(dodo);
		this.add(_is);
		this.add(_you);
	}

	// Play Intro Animation
	public void playIntro() {
		Timer t1 = new Timer();

		TimerTask task1 = new TimerTask() {

			int i = 0, j = 0, cnt = 0;

			@Override
			public void run() {

				if (cnt < 7) {
					if (cnt < 3) {
						dodo.setLocation(270, 180 + 60 * i);
						i++;
					} else {
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

	// Initialize Stage1 Panel
	public void initStage1() {
		this.removeAll();
		contentpane.removeAll();
		contentpane.repaint();
		contentpane.add(new Stage1Panel(contentpane));
		contentpane.repaint();
	}

}
