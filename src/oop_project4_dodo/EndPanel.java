package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EndPanel extends JPanel {

	/* Member Variables */
	Container contentpane;

	/* Constructor */
	EndPanel(Container cp) {
		contentpane = cp;

		JLabel end = new JLabel(new ImageIcon("img/end.png"));
		end.setBounds(0, 40, ConstClass.FRAME_WIDTH, ConstClass.FRAME_HEIGHT);

		this.setBackground(Color.BLACK);
		this.setBounds(0, 0, ConstClass.FRAME_WIDTH, ConstClass.FRAME_HEIGHT);
		this.add(end);
		this.setLayout(null);
	}

}