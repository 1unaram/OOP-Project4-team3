package oop_project4_dodo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
		
		// Set Next Stage
		if(this instanceof ObjBlock && stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof ObjBlock) {
			ObjBlock nextBlock = (ObjBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
			if(((ObjBlock)this).isYou() && nextBlock.isWin()) {
					System.out.println("nextStage");
			}
		}
					
					
		if (this.checkNextPushable(weightX, weightY)) {
			
			// 다음 블록을 밀기
			if (!stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX].moveProcess(weightX,
					weightY)) {
				return false;
			}
			this.moveBlock(weightX, weightY);

			// sentence 완성 여부 확인 & 멤버변수 set 해주기
			if (this.checkNextInFrame(weightX, weightY)) {
				if (this.stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof WordBlock) {
					((WordBlock) this.stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX])
							.checkSenstence();
				}
			}

			
			
			

			return true;
		}

		return false;
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

	// (3) getter/setter
	public void setIsPushable(boolean isPushable) {
		this.isPushable = isPushable;
	}

}

@SuppressWarnings("serial")
class WordBlock extends Block {

	/* Private member variable */
	private boolean isSubject;
	private boolean isVerb;
	private boolean isComplement;

	ManageListener manageListener;

	/* Constructor */
	WordBlock() {

	}

	WordBlock(String path, StageBlockArray stageBlockArr, ManageListener manageListener) {
		this.setIcon(new ImageIcon(path));
		this.stageBlockArr = stageBlockArr;
		this.manageListener = manageListener;
	}

	WordBlock(String path, StageBlockArray stageBlockArr, ManageListener manageListener, String str) {

		ImageIcon icon = new ImageIcon(path);
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon chanIcon = new ImageIcon(changeImg);

		this.setIcon(chanIcon);
		this.stageBlockArr = stageBlockArr;
		this.manageListener = manageListener;

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

			// 동 체크
			checkComplementStatus(1, 0);

			// 남 체크
			checkComplementStatus(0, 1);

		} else if (this.isVerb) {
			// 동, 서 체크
			checkVerbStatus(1, 0);

			// 남, 북 체크
			checkVerbStatus(0, 1);
		} else if (this.isComplement) {
			// 서 체크
			checkSubjectStatus(-1, 0);

			// 북 체크
			checkSubjectStatus(0, -1);
		}

	}

	// 주어 체크
	public void checkSubjectStatus(int weightX, int weightY) {

		if (this.checkVerb(weightX, weightY) && this.checkSubject(weightX * 2, weightY * 2)) {
			Block subBlock = stageBlockArr.array[this.getArrY() + weightY * 2][this.getArrX() + weightX * 2];

			// win 체크
			if (this.getText() == "w") {
				for (Block[] b1 : stageBlockArr.array) {
					for (Block b2 : b1) {
						if (b2 != null && b2.getText().equals(subBlock.getText().toUpperCase())) {
							((ObjBlock) b2).setWin();
							System.out.println("win");
						}
					}
				}
			}

			// you 체크
			if (this.getText() == "y") {
				for (Block[] b1 : stageBlockArr.array) {
					for (Block b2 : b1) {
						if (b2 != null && b2.getText().equals(subBlock.getText().toUpperCase())) {
							((ObjBlock) b2).setYou();
							System.out.println("you");
						}
					}
				}
			}
		}

	}

	// 동사 체크
	public void checkVerbStatus(int weightX, int weightY) {

		if (this.checkSubject(weightX * -1, weightY * -1) && this.checkComplement(weightX, weightY)) {
			Block subBlock = stageBlockArr.array[this.getArrY() + weightY * -1][this.getArrX() + weightX * -1];
			Block compBlock = stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];

			// win 체크
			if (compBlock.getText() == "w") {
				for (Block[] b1 : stageBlockArr.array) {
					for (Block b2 : b1) {
						if (b2 != null && b2.getText().equals(subBlock.getText().toUpperCase())) {
							((ObjBlock) b2).setWin();
							System.out.println("win");
						}
					}
				}
			}

			// you 체크
			if (compBlock.getText() == "y") {
				for (Block[] b1 : stageBlockArr.array) {
					for (Block b2 : b1) {
						if (b2 != null && b2.getText().equals(subBlock.getText().toUpperCase())) {
							((ObjBlock) b2).setYou();
							System.out.println("you");
						}
					}
				}
			}
		}

	}

	// 보어 체크
	public void checkComplementStatus(int weightX, int weightY) {

		if (this.checkVerb(weightX, weightY) && this.checkComplement(weightX * 2, weightY * 2)) {
			Block compBlock = stageBlockArr.array[this.getArrY() + weightY * 2][this.getArrX() + weightX * 2];

			// win 체크
			if (compBlock.getText() == "w") {
				for (Block[] b1 : stageBlockArr.array) {
					for (Block b2 : b1) {
						if (b2 != null && b2.getText().equals(this.getText().toUpperCase())) {
							((ObjBlock) b2).setWin();
							System.out.println("win");
						}
					}
				}
			}

			// you 체크
			if (compBlock.getText() == "y") {
				for (Block[] b1 : stageBlockArr.array) {
					for (Block b2 : b1) {
						if (b2 != null && b2.getText().equals(this.getText().toUpperCase())) {
							((ObjBlock) b2).setYou();
							System.out.println("you");
						}
					}
				}
			}
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
		if (this.checkNextIsNull(weightX, weightY)) {
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
	private boolean isWin;

	ManageListener manageListener;

	/* Constructor */
	ObjBlock() {

	}

	ObjBlock(String path, StageBlockArray stageBlockArr, ManageListener manageListener) {
		this.setIcon(new ImageIcon(path));
		this.stageBlockArr = stageBlockArr;
		this.manageListener = manageListener;
	}

	ObjBlock(String path, StageBlockArray stageBlockArr, ManageListener manageListener, String str) {

		ImageIcon icon = new ImageIcon(path);
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon chanIcon = new ImageIcon(changeImg);

		this.setIcon(chanIcon);
		this.stageBlockArr = stageBlockArr;
		this.manageListener = manageListener;

	}

	/* Method */
	public boolean checkReached() {
		return true;
	}

	public void setYou() {
		this.isYou = true;

		for (YouKeyListener1 ykl : manageListener.YouKeyListener1List) {
			manageListener.contentpane.removeKeyListener(ykl);
		}

		YouKeyListener1 ykl = new YouKeyListener1(this);

		// 키 리스너를 실제 다는 동작
		manageListener.contentpane.addKeyListener(ykl);

		// 키 리스너 관리 대상에 들어간다
		manageListener.addYouKeyListener1(ykl);
	}

	public void setWin() {
		this.isWin = true;
	}
	
	public boolean isWin() {
		return this.isWin;
	}
	
	public boolean isYou() {
		return this.isYou;
	}
	
	public void setisYou(boolean b) {
		this.isYou = b;
	}

}