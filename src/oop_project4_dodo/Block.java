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
				weightY = -1;
				break;
			case ConstClass.DOWN:
				weightY = 1;
				break;
			case ConstClass.LEFT:
				weightX = -1;
				break;
			case ConstClass.RIGHT:
				weightX = 1;
				break;
			default:
				isPushable = false;
		}

		// 방향키만 움직일 수 있도록 처리
		if (isPushable) {
			System.out.print(direction + ": ");
			System.out.print(currentY + weightY);
			System.out.print(" / ");
			System.out.println(currentX + weightX);

			// 다음 블록이 이동 가능한지 검사
			System.out.println(stageBlockArr.array[currentY + weightY][currentX + weightX]);
			if (stageBlockArr.array[currentY + weightY][currentX + weightX] != null) {
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

		// 블록을 밀어야하는 방향 설정
		switch (direction) {
			case ConstClass.UP:
				weightY = -1;
				break;
			case ConstClass.DOWN:
				weightY = +1;
				break;
			case ConstClass.LEFT:
				weightX = -1;
				break;
			case ConstClass.RIGHT:
				weightX = 1;
				break;
		}

		stageBlockArr.setNewPosition(this, oldY, oldX, oldY + weightY, oldX + weightX);

		// 오브젝트의 멤버 변수 변경
		this.setPos(this.getArrY() + weightY, this.getArrX() + weightX);

		// 오브젝트의 위치 다시 그리기
		this.setLocation(this.getX() + 60 * weightX, this.getY() + 60 * weightY);
	}

	// this가 해당 방향으로 움직일 수 있는지 체크
	public boolean checkMovable(int weightX, int weightY) {

		boolean isMovable = false;

		// 다음 이동 시 프레임 안에 존재하는지 체크
		if (checkInFrame(weightX, weightY)) {

			// 다음 이동 시 블록이 존재하는지 체크
			if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] == null) {
				isMovable = true;
			}
		}

		return isMovable;
	}

	public boolean checkInFrame(int weightX, int weightY) {

		// X 방향 체크
		if (this.getArrX() + weightX < 0 || this.getArrX() + weightX > ConstClass.ARRAY_X - 1) {
			return false;
		}

		// Y 방향 체크
		if (this.getArrY() + weightY < 0 || this.getArrY() + weightY > ConstClass.ARRAY_Y - 1) {
			return false;
		}

		return true;
	}

}

@SuppressWarnings("serial")
class WordBlock extends Block {

	/* Private member variable */
	private boolean isSubject;
	private boolean isVerb;
	private boolean isComplement;
	private boolean isMovable = true;

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

	// public boolean checkMovable() {
	// return isMovable;
	// }
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

	ObjBlock(String path, StageBlockArray stageBlockArr) {
		this.setIcon(new ImageIcon(path));
		this.stageBlockArr = stageBlockArr;
	}

	/* Method */

	public void win() {

	}

	public boolean checkReached() {
		return true;
	}

}