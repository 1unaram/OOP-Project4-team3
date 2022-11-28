package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IntroPanel extends JPanel{
	
	Container contentpane;
	
	IntroPanel(Container cp) {
		contentpane = cp;
		
		JLabel title = new JLabel("DoDo is You");
		title.setForeground(Color.WHITE);
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));
		title.setBounds(0, 300, ConstantClass.FRAME_WIDTH, 80);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		this.setBackground(Color.PINK);
		this.setBounds(0, 0, ConstantClass.FRAME_WIDTH, ConstantClass.FRAME_HEIGHT);
		this.add(title);
		this.setLayout(null);
		
		contentpane.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					contentpane.removeAll();		
					contentpane.repaint();					// contentpane 초기화
					
					initStage1();
				}
			}
		});
	}
	
	public void initStage1() {
		
		contentpane.add(new Stage1Panel(contentpane));
		
	}
	
}
