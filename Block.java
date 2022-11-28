package oop_project4_dodo;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Block extends JLabel {
	
	/* Private member variable */
	private int width;
	private int height;
	private boolean isPusable;
	
	
	/* Constructor */
	Block() {
		this.setIcon(null);
	}
	
	
	/* Method */
	public boolean checkPushable() {
		return isPusable;
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
	
	
	/* Method */
	public void pushedBlock() {
		
	}
	
	public void win() {
		
	}
	
	public boolean checkReached() {
		return true;
	}
}