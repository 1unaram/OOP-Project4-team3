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

	/* Constructor */
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

		initIcon();
		initStartPanel();

		contentpane.revalidate();
		contentpane.repaint();
	}

	/* Method */
	// Initialize Start Panel
	public void initStartPanel() {
		contentpane.add(new StartPanel(contentpane));
	}

	// Initialize Icon
	public void initIcon() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/dodo-icon.png");
		this.setIconImage(img);
	}
}
