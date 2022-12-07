package oop_project4_dodo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DodoMain {

	public static void main(String[] args) {

		new MainFrame();

	}

}

@SuppressWarnings("serial")
class MainFrame extends JFrame {
	Container contentpane = getContentPane();

	static ManageStage ms;

	MainFrame() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(ConstClass.FRAME_WIDTH, ConstClass.FRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Dodo is You");
		this.setLayout(null);

		contentpane.setBackground(Color.BLACK);
		contentpane.requestFocus();
		contentpane.setFocusable(true);

		ms = new ManageStage(contentpane);

		iconinit();
		init();

		contentpane.revalidate();
		contentpane.repaint();
	}

	public void init() {
		contentpane.add(new StartPanel(contentpane));
	}

	public void iconinit() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/dodo-icon.png");
		this.setIconImage(img);
	}
}
