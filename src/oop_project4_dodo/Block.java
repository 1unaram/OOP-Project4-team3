package oop_project4_dodo;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Block extends JLabel {
	
	/* Private member variable */
	private boolean isPushable = true;
	
	private int arrX;
	private int arrY;
	
	
	/* Constructor */
	Block() {
		
	}
	
	Block(String path) {
		this.setIcon(new ImageIcon(path));
	}
	
	
	/* Method */
	public boolean checkPushable(int n) {
		
		switch(n) {
		case KeyEvent.VK_UP :
			if(arrY == 0) isPushable = false;
			break;
		case KeyEvent.VK_DOWN :
			if(arrY == 11) isPushable = false;
			break;
		case KeyEvent.VK_LEFT :
			if(arrX == 0) isPushable = false;
			break;
		case KeyEvent.VK_RIGHT :
			if(arrX == 20) isPushable = false;
			break;
		}
		
		return isPushable;
	}
	
	public void setPos(int y, int x) {
		this.arrY = y;
		this.arrX = x;
	}
	
	public int getArrX() {
		return this.arrX;
	}
	
	public int getArrY() {
		return this.arrY;
	}
}


@SuppressWarnings("serial")
class WordBlock extends Block {
	
	/* Private member variable */
	private boolean isSubject;
	private boolean isVerb;
	private boolean isComplement;
	
	
	/* Constructor */
	WordBlock() {
		
	}
	
	WordBlock(String path) {
		this.setIcon(new ImageIcon(path));
	}
	
	
	/* Method */
	public void pushedBlock() {
		
	}
	
	public void checkSenstence() {
		
	}
}


@SuppressWarnings("serial")
class ObjBlock extends Block {
	
	/* Private member variable */
	private boolean isYou;
	private boolean isFish;
	private boolean isWin;
	
	
	/* Constructor */
	ObjBlock() {
		
	}
	
	ObjBlock(String path) {
		this.setIcon(new ImageIcon(path));
	}
	
	
	/* Method */
	public void pushedBlock() {
		
	}
	
	public void win() {
		
	}
	
	public boolean checkReached() {
		return true;
	}
	
	public boolean checkMovable(int key) {
		
		switch(key) {
		case KeyEvent.VK_UP :
			if(this.getY() > 0) {
				// 블록까지 밀어서 움직일 수 있는지 검증 필요
				return true;
			}
			
			break;
		case KeyEvent.VK_DOWN :
			
			break;
		case KeyEvent.VK_LEFT :
			
			break;
		case KeyEvent.VK_RIGHT :
			
			break;
		}
		
		return isFish;
	}
}