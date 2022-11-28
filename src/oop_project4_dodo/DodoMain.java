package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class DodoMain {

	public static void main(String[] args) {
	
		new MainFrame();

	}

}


@SuppressWarnings("serial")
class MainFrame extends JFrame{
	Container contentpane = getContentPane();
	
	MainFrame() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1200, 840);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Dodo is You");
		this.setLayout(null);
		
		contentpane.setBackground(Color.BLACK);
	
		init();
	}
	
	public void init() {
		IntroPanel intro = new IntroPanel();
		
		intro.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					contentpane.removeAll();		
					contentpane.repaint();					// contentpane 초기화
					
					// Stage1 Panel
					Stage1Panel s1p = new Stage1Panel();
					contentpane.add(s1p);
				}
			}
		});
		
		
		contentpane.add(intro);
	}
}

		