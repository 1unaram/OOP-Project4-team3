package oop_project4_dodo;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Block extends JLabel {
	
	/* Private member variable */
	private boolean isPushable = true;
	private boolean isMovable;
	
	private int arrX;
	private int arrY;
	
	StageBlockArray stageBlockArr;
	
	
	/* Constructor */
	Block() {
	}
	
	Block(String path) {
		this.setIcon(new ImageIcon(path));
	}
	
	/* Method */

	// (1) Position 관련 메소드
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
	
	// (2) this가 b를 미는 메소드
	public void pushBlock(Block b, int direction) {

		// 다음 블록을 밀어야 하는지 검사
		int currentX = this.getArrX();
		int currentY = this.getArrY();
		
		int weightX = 0;
		int weightY = 0;
		
		boolean isPushable = true;
		
		switch (direction) {
		case ConstClass.UP:
			weightY =  -1;
			break;
		case ConstClass.DOWN:
			weightY =  1;
			break;
		case ConstClass.LEFT:
			weightX =  -1;
			break;
		case ConstClass.RIGHT:
			weightX =  1;
			break;
		default:
			isPushable = false;
		}
		
		if(isPushable) {	
			System.out.print(direction + ": ");
			System.out.print(currentY + weightY);
			System.out.print(" / ");
			System.out.println(currentX + weightX);
			if(stageBlockArr.array[currentY + weightY][currentX + weightX] != null) {
				b.pushBlock(stageBlockArr.array[currentY + weightY][currentX + weightX], direction);
				b.moveBlock(direction);
			}
		}
		
	}
	
	// this를 움직인다.
	public void moveBlock(int direction) {
		
		int oldX = this.getArrX();
		int oldY = this.getArrY();
		
		int weightX = 0;
		int weightY = 0;
		
		// 다음 블록을 밀어야 하는지 검사
		switch (direction) {
		case ConstClass.UP:
			weightY =  -1;
			break;
		case ConstClass.DOWN:
			weightY =  +1;
			break;
		case ConstClass.LEFT:
			weightX =  -1;
			break;
		case ConstClass.RIGHT:
			weightX =  1;
			break;
		}
		
		stageBlockArr.setNewPosition(this, oldY, oldX, oldY + weightY, oldX + weightX);
		
		// 오브젝트의 멤버 변수 변경
		this.setPos(this.getArrY() + weightY, this.getArrX() + weightX);
		
		// 오브젝트의 위치 다시 그리기
		this.setLocation(this.getX() + 60 * weightX, this.getY() + 60 * weightY);
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
	
	WordBlock(String path, StageBlockArray stageBlockArr) {
		this.setIcon(new ImageIcon(path));
		this.stageBlockArr = stageBlockArr;
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
	private boolean isMovable;
	
	
	/* Constructor */
	ObjBlock() {
		
	}
	
	ObjBlock(String path, StageBlockArray stageBlockArr) {
		this.setIcon(new ImageIcon(path));
		this.stageBlockArr = stageBlockArr;
	}

	
	/* Method */
	public void pushedBlock() {
		
		int oldX = this.getArrX();
		int oldY = this.getArrY();
		
		this.stageBlockArr.setNewPosition(this, oldY, oldX, oldY, oldX + 1);
		
		// 오브젝트의 멤버 변수 변경
		this.setPos(this.getArrY(), this.getArrX() + 1);
		
		// 오브젝트의 위치 다시 그리기
		this.setLocation(this.getX() + 60, this.getY());
	}
	
	public void win() {
		
	}
	
	public boolean checkReached() {
		return true;
	}
	
	// 해당 블록이 해당 방향으로 움직일 수 있는지 체크
	public boolean checkMovable(int direction) {
		
		isMovable = false;
		
		switch(direction) {
		case ConstClass.UP:
			if(this.getY() > 0) {
				
				// 위에 오브젝트가 없으면 이동 가능
				if(this.stageBlockArr.array[this.getArrY() - 1][this.getArrX()] == null) {					
					isMovable = true;
				}
				
			}
			break;
		case ConstClass.DOWN :
			if(this.getY() < 600) {
				
				// 아래에 오브젝트가 없으면 이동 가능
				if(this.stageBlockArr.array[this.getArrY() + 1][this.getArrX()] == null) {					
					isMovable = true;
				}
				
			}
			
			break;
		case ConstClass.LEFT :
			if(this.getX() > 0) {
				
				// 왼쪽에 오브젝트가 없으면 이동 가능
				if(this.stageBlockArr.array[this.getArrY()][this.getArrX() - 1] == null) {					
					isMovable = true;
				}
				
			}
			break;
		case ConstClass.RIGHT :
			if(this.getX() < 1140) {
				
				// 오른쪽에 오브젝트가 없으면 이동 가능
				if(this.stageBlockArr.array[this.getArrY()][this.getArrX() + 1] == null) {					
					isMovable = true;
				}
				
			}
			break;
		}
		
		return isMovable;
	}
}