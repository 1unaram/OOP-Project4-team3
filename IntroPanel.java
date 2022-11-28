package oop_project4_dodo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IntroPanel extends JPanel{
	
	IntroPanel() {
		JLabel title = new JLabel("DoDo is You");
		title.setForeground(Color.WHITE);
		title.setLocation(500, 300);
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));
		
		this.requestFocus();
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		this.setBounds(0,320,1200,780);
		this.add(title);
	}
	
}
