package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DodoMain {

	public static void main(String[] args) {
	
		new MainFrame();

	}

}


@SuppressWarnings("serial")
class MainFrame extends JFrame {
	Container contentpane = getContentPane();
	
	MainFrame() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Dodo is You");
		this.setLayout(null);
		
		contentpane.setBackground(Color.BLACK);
		
		init();
	}
	
	public void init() {
		Intro intro = new Intro();
		contentpane.add(intro);
	}
}



@SuppressWarnings("serial")
class Intro extends JPanel{
	
	Intro() {
		JLabel title = new JLabel("DoDo is You");
		title.setForeground(Color.WHITE);
		title.setLocation(500, 300);
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));
		
		this.setBackground(Color.BLACK);
		this.setBounds(0,320,1200,780);
		this.add(title);
	}
}
