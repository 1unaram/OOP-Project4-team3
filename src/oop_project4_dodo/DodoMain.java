package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class DodoMain {
	
	public static void main(String[] args) {
	
		new MainFrame();

	}

}

class ConstantClass {
	static int FRAME_WIDTH = 1260;
	static int FRAME_HEIGHT = 800;
	static int PANEL_WIDTH = 1200;
	static int PANEL_HEIGHT = 660;
	static int BANNER_HEIGHT = 80;
}


@SuppressWarnings("serial")
class MainFrame extends JFrame{
	Container contentpane = getContentPane();
	
	MainFrame() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(ConstantClass.FRAME_WIDTH, ConstantClass.FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Dodo is You");
		this.setLayout(null);
		
		contentpane.setBackground(Color.BLACK);
		contentpane.requestFocus();
		contentpane.setFocusable(true);
	
		init();
	}
	
	public void init() {
		IntroPanel intro = new IntroPanel(contentpane);
		contentpane.add(intro);
	}
}

		