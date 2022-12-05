package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartPanel extends JPanel {

	Container contentpane;
	KeyAdapter enterKey = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				initIntro();
			}
		}
	};

	StartPanel(Container cp) {
		contentpane = cp;
		
		JLabel start = new JLabel(new ImageIcon("img/intro.png"));
		start.setBounds(0, 40, ConstClass.FRAME_WIDTH, ConstClass.FRAME_HEIGHT);

		this.setBackground(Color.BLACK);
		this.setBounds(0, 0, ConstClass.FRAME_WIDTH, ConstClass.FRAME_HEIGHT);
		this.add(start);
		this.setLayout(null);

		contentpane.addKeyListener(enterKey);

	}

	public void initIntro() {

		this.removeAll();
		contentpane.removeKeyListener(enterKey);
		contentpane.removeAll();
		contentpane.repaint();
		contentpane.add(new IntroPanel(contentpane));
		contentpane.repaint();
	}

}