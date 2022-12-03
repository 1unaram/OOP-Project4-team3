package oop_project4_dodo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.text.rtf.RTFEditorKit;

@SuppressWarnings("serial")
public class Block extends JLabel {

	/* Private member variable */
	private boolean isPushable = true;

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
	// this를 움직인다.
	public void moveBlock(int weightX, int weightY) {

		// 블록의 속성에 따라 동작
		// if(block == "win") {
		// win();
		// } else if(block == "defeat") {
		// defeat();
		// } else if(isYou != "you") {
		// changeYou();
		// }

		int oldX = this.getArrX();
		int oldY = this.getArrY();

		stageBlockArr.setNewPosition(this, oldY, oldX, oldY + weightY, oldX + weightX);

		// 오브젝트의 멤버 변수 변경
		this.setPos(this.getArrY() + weightY, this.getArrX() + weightX);

		// 오브젝트의 위치 다시 그리기
		this.setLocation(this.getX() + 60 * weightX, this.getY() + 60 * weightY);
	}

	// this가 움직이는 메소드
	public boolean moveProcess(int weightX, int weightY) {

		// 이동할 칸이 프레임 안에 존재하지 않는 경우
		if (!this.checkNextInFrame(weightX, weightY))
			return false;

		// 이동할 칸이 프레임 안에 존재하는 경우
		// 다음 블록이 존재하지 않으면 this가 움직이기
		if (this.checkNextIsNull(weightX, weightY)) {
			this.moveBlock(weightX, weightY);
			return true;
		}

		// 이동할 칸이 프레임 안에 존재하는 경우
		// 다음 블록이 존재하는 경우
		// 다음 블록이 움직일 수 있는 경우
		if (this.checkNextPushable(weightX, weightY)) {
			// 다음 블록을 밀기
			if (!stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX].moveProcess(weightX,
					weightY)) {
				return false;
			}
			this.moveBlock(weightX, weightY);
		}

		return true;
	}

	public boolean checkNextPushable(int weightX, int weightY) {
		// 다음 블록이 이동 가능한지 검사
		if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() +
				weightX].isPushable) {
			return true;
		} else {
			return false;
		}
	}

	// 다음 블록이 없는 지 체크
	public boolean checkNextIsNull(int weightX, int weightY) {
		if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] == null) {
			return true;
		}
		return false;
	}

	// 다음 블록 이동 시 프레임 내에 있는지 체크
	public boolean checkNextInFrame(int weightX, int weightY) {

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

	/* Constructor */
	WordBlock() {

	}

	WordBlock(String path, StageBlockArray stageBlockArr) {
		this.setIcon(new ImageIcon(path));
		this.stageBlockArr = stageBlockArr;
	}

	/* Method */
	// 글자 속성 설정
	public void setSubject() {
		this.isSubject = true;
	}

	public void setVerb() {
		this.isVerb = true;
	}

	public void setComplement() {
		this.isComplement = true;
	}

	public boolean isSubject() {
		return this.isSubject;
	}

	public boolean isVerb() {
		return this.isVerb;
	}

	public boolean isComplement() {
		return this.isComplement;
	}

	// 문장 체크
	public void checkSenstence() {

		// 문장이 완성되었는지 체크
		if (this.isSubject) {

			System.out.println("Entered 1");

			if (this.checkVerb(1, 0)) {
				System.out.println("Entered 2");
				return;
			}

			// 동 체크
			if (this.checkVerb(1, 0) && this.checkComplement(2, 0)) {

				System.out.println("Entered");

				Block compBlock = stageBlockArr.array[this.getArrY()][this.getArrX() + 2];

				// win 체크
				if (compBlock.getText() == "w") {
					for (Block[] b1 : stageBlockArr.array) {
						for (Block b2 : b1) {
							if (b2.getText() == this.getText().toUpperCase()) {
								((ObjBlock) b2).setWin();
								System.out.println(b2.getText() + "는 Win입니다.");
							}
						}
					}
				}
			}

			// 남 체크
			if (this.checkVerb(0, 1) && this.checkComplement(0, 2)) {

			}

		} else if (isVerb) {

		} else if (isComplement) {

		}

	}

	public boolean checkSubject(int weightX, int weightY) {
		if (!this.checkNextFNW(weightX, weightY))
			return false;

		WordBlock nextBlock = (WordBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
		if (!nextBlock.isSubject())
			return false;
		return true;
	}

	public boolean checkVerb(int weightX, int weightY) {
		if (!this.checkNextFNW(weightX, weightY))
			return false;

		System.out.println("Entered 3");

		WordBlock nextBlock = (WordBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
		if (!nextBlock.isVerb())
			return false;
		return true;
	}

	public boolean checkComplement(int weightX, int weightY) {
		if (!this.checkNextFNW(weightX, weightY))
			return false;

		WordBlock nextBlock = (WordBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
		if (!nextBlock.isComplement())
			return false;
		return true;
	}

	public boolean checkNextFNW(int weightX, int weightY) {
		// 다음 블록이 프레임 안에 있는지 체크
		if (!this.checkNextInFrame(weightX, weightY))
			return false;

		// 다음 블록이 존재하는지 체크
		if (!this.checkNextIsNull(weightX, weightY)) {
			System.out.println(">" + stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX].getText());
			System.out.println("Enetered checkNextIsNull");
			return false;
		}

		// 다음 블록이 이동 가능한지 검사
		if (!(stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof WordBlock))
			return false;

		return true;
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

	ObjBlock(String path, StageBlockArray stageBlockArr) {
		this.setIcon(new ImageIcon(path));
		this.stageBlockArr = stageBlockArr;
	}

	/* Method */
	public boolean checkReached() {
		return true;
	}

	public void setYou() {
		this.isYou = true;
	}

	public void setFish() {
		this.isFish = true;
	}

	public void setWin() {
		this.isWin = true;
	}

}