package oop_project4_dodo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Block extends JLabel {

	/* Private member variable */
	private boolean isPushable = true;

	private int arrX;
	private int arrY;

	StageBlockArray stageBlockArr;

	Stage1Panel stage1Panel = null;
	Stage2Panel stage2Panel = null;
	Stage3Panel stage3Panel = null;

	ObjBlock dodo;
	ObjBlock fish;
	ObjBlock toy;

	/* Constructor */
	Block() {
	}

	Block(String path) {
		this.setIcon(new ImageIcon(path));
	}

	/* Method */

	// (1) Position 愿��젴 硫붿냼�뱶
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

	// (2) this媛� b瑜� 誘몃뒗 硫붿냼�뱶
	// this瑜� ��吏곸씤�떎.
	public void moveBlock(int weightX, int weightY) {	

		int oldX = this.getArrX();
		int oldY = this.getArrY();

		stageBlockArr.setNewPosition(this, oldY, oldX, oldY + weightY, oldX + weightX);

		// �삤釉뚯젥�듃�쓽 硫ㅻ쾭 蹂��닔 蹂�寃�
		this.setPos(this.getArrY() + weightY, this.getArrX() + weightX);

		// �삤釉뚯젥�듃�쓽 �쐞移� �떎�떆 洹몃━湲�
		this.setLocation(this.getX() + 60 * weightX, this.getY() + 60 * weightY);
	}

	// this媛� ��吏곸씠�뒗 硫붿냼�뱶
	public boolean moveProcess(int weightX, int weightY) {

		// �씠�룞�븷 移몄씠 �봽�젅�엫 �븞�뿉 議댁옱�븯吏� �븡�뒗 寃쎌슦
		if (!this.checkNextInFrame(weightX, weightY))
			return false;

		// �씠�룞�븷 移몄씠 �봽�젅�엫 �븞�뿉 議댁옱�븯�뒗 寃쎌슦
		// �떎�쓬 釉붾줉�씠 議댁옱�븯吏� �븡�쑝硫� this媛� ��吏곸씠湲�
		if (this.checkNextIsNull(weightX, weightY)) {
			this.moveBlock(weightX, weightY);
			return true;
		}

		// �씠�룞�븷 移몄씠 �봽�젅�엫 �븞�뿉 議댁옱�븯�뒗 寃쎌슦
		// �떎�쓬 釉붾줉�씠 議댁옱�븯�뒗 寃쎌슦
		// �떎�쓬 釉붾줉�씠 ��吏곸씪 �닔 �엳�뒗 寃쎌슦
		
		// Set Next Stage
		if(this instanceof ObjBlock && stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof ObjBlock) {
			ObjBlock nextBlock = (ObjBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
			if(((ObjBlock)this).isYou() && nextBlock.isWin()) {
					MainFrame.ms.nextStage();
			}
		}
		
		/*if(stage3Panel != null) {
			if(this instanceof ObjBlock && stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof ObjBlock) {
				ObjBlock nextBlock = (ObjBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
				if(((ObjBlock)this).isYou() && nextBlock.isDefeat()) {
						MainFrame.ms.resetStage();
				}
			}
		}*/

					
					
		if (this.checkNextPushable(weightX, weightY)) {
			
			// �떎�쓬 釉붾줉�쓣 諛�湲�
			if (!stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX].moveProcess(weightX,
					weightY)) {
				return false;
			}
			this.moveBlock(weightX, weightY);

			// Check Unset
			this.checkUnset();

			return true;
		}

		return false;
	}

	public boolean checkNextPushable(int weightX, int weightY) {
		// �떎�쓬 釉붾줉�씠 �씠�룞 媛��뒫�븳吏� 寃��궗
		if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() +
				weightX].isPushable) {
			return true;
		} else {
			return false;
		}
	}

	// �떎�쓬 釉붾줉�씠 �뾾�뒗 吏� 泥댄겕
	public boolean checkNextIsNull(int weightX, int weightY) {
		if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] == null) {
			return true;
		}
		return false;
	}

	// �떎�쓬 釉붾줉 �씠�룞 �떆 �봽�젅�엫 �궡�뿉 �엳�뒗吏� 泥댄겕
	public boolean checkNextInFrame(int weightX, int weightY) {

		// X 諛⑺뼢 泥댄겕
		if (this.getArrX() + weightX < 0 || this.getArrX() + weightX > ConstClass.ARRAY_X - 1) {
			return false;
		}

		// Y 諛⑺뼢 泥댄겕
		if (this.getArrY() + weightY < 0 || this.getArrY() + weightY > ConstClass.ARRAY_Y - 1) {
			return false;
		}

		return true;
	}

	// (3) getter/setter
	public void setIsPushable(boolean isPushable) {
		this.isPushable = isPushable;
	}


	// (4) Check Unset
	public void checkUnset() {

		this.unsetAllObject();
		
		// 紐⑤뱺 媛앹껜�뿉 ���빐�꽌 �젏寃�
		for(Block[] b1 : stageBlockArr.array) {
			for(Block b2 : b1) {
				if(b2 instanceof WordBlock) {


					// Type Casting
					WordBlock subBlock = (WordBlock) b2;
					
					// �빐�떦 媛앹껜媛� 二쇱뼱�씪 寃쎌슦
					if(subBlock.isSubject()) {

						// �룞履� +1 釉붾줉�씠 �룞�궗�씪 寃쎌슦
						if(subBlock.checkNextFNW(1, 0) && subBlock.isWeightVerb(1, 0)) {
							
								// �룞履� +2 釉붾줉�씠 蹂댁뼱�씪 寃쎌슦
								if(subBlock.checkNextFNW(2, 0) && subBlock.isWeightComplement(2, 0)) {

									// dodo �꽭�똿
									if(this.dodo.getText().equals(subBlock.getText().toUpperCase())) {
										// win �꽭�똿
										if(subBlock.getWeightBlock(2, 0).getText().equals("w"))
											this.dodo.setWin(true);
										
										// you �꽭�똿
										if(subBlock.getWeightBlock(2, 0).getText().equals("y"))
											this.dodo.setYou(true);
									} 
									// fish �꽭�똿
									else if(this.fish.getText().equals(subBlock.getText().toUpperCase())) {
										// win �꽭�똿
										if(subBlock.getWeightBlock(2, 0).getText().equals("w"))
											this.fish.setWin(true);
										
										// you �꽭�똿
										if(subBlock.getWeightBlock(2, 0).getText().equals("y"))
											this.fish.setYou(true);
									}
									// toy �꽭�똿																
									else if(this.toy.getText().equals(subBlock.getText().toUpperCase())) {
										// win �꽭�똿
										if(subBlock.getWeightBlock(2, 0).getText().equals("w"))
											this.toy.setWin(true);
										
										// you �꽭�똿
										if(subBlock.getWeightBlock(2, 0).getText().equals("y"))
											this.toy.setYou(true);
									}
								}
						}

						// �궓履� +1 釉붾줉�씠 �룞�궗�씪 寃쎌슦
						else if(subBlock.checkNextFNW(0, 1) && subBlock.isWeightVerb(0, 1)) {
							
							// �궓履� +2 釉붾줉�씠 蹂댁뼱�씪 寃쎌슦
							if(subBlock.checkNextFNW(0, 2) && subBlock.isWeightComplement(0, 2)) {
								// dodo �꽭�똿
								if(this.dodo.getText().equals(subBlock.getText().toUpperCase())) {
									// win �꽭�똿
									if(subBlock.getWeightBlock(0, 2).getText().equals("w"))
										this.dodo.setWin(true);
									
									// you �꽭�똿
									if(subBlock.getWeightBlock(0, 2).getText().equals("y"))
										this.dodo.setYou(true);
								} 
								// fish �꽭�똿
								else if(this.fish.getText().equals(subBlock.getText().toUpperCase())) {
									// win �꽭�똿
									if(subBlock.getWeightBlock(0, 2).getText().equals("w"))
										this.fish.setWin(true);
									
									// you �꽭�똿
									if(subBlock.getWeightBlock(0, 2).getText().equals("y"))
										this.fish.setYou(true);
								}
								// toy �꽭�똿 															
								else if(this.toy.getText().equals(subBlock.getText().toUpperCase())) {
									// win �꽭�똿
									if(subBlock.getWeightBlock(0, 2).getText().equals("w"))
										this.toy.setWin(true);
									
									// you �꽭�똿
									if(subBlock.getWeightBlock(0, 2).getText().equals("y"))
										this.toy.setYou(true);
								} 
							}
					}

					}


				}
			}
		}

	}

	// (5) Unset All Object
	public void unsetAllObject(){

		// dodo
		dodo.setYou(false);
		dodo.setWin(false);

		// fish
		fish.setYou(false);
		fish.setWin(false);
	
		// toy
		if(stage2Panel != null) {
			toy.setYou(false);								
			toy.setWin(false);
		}
	
	}

	// (6) Get Weight Block
	public Block getWeightBlock(int weightX, int weightY) {
		return stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX];
	}


	// (7) Set dodo, fish
	public void setObjects(JPanel stagePanel) {
		// JPanel �꽕�젙
		if(stagePanel instanceof Stage1Panel) {
			this.stage1Panel = (Stage1Panel) stagePanel;
			this.dodo = Stage1Panel.dodo;
			this.fish = Stage1Panel.fish;
		} else if(stagePanel instanceof Stage2Panel) {
			this.stage2Panel = (Stage2Panel) stagePanel;
			this.dodo = Stage2Panel.dodo;
			this.fish = Stage2Panel.fish;
			this.toy = Stage2Panel.toy;
		} else if(stagePanel instanceof Stage3Panel) {
			this.stage3Panel = (Stage3Panel) stagePanel;
			this.dodo = Stage3Panel.dodo;
			this.fish = Stage3Panel.fish;
			this.toy = Stage3Panel.toy;
		}
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
	// 湲��옄 �냽�꽦 �꽕�젙
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

	// weightX, weightY�쓽 釉붾줉�뿉 ���빐 泥댄겕
	public boolean isWeightSubject(int weightX, int weightY) {
		if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof WordBlock) {
			return ((WordBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX]).isSubject();
		}
		return false;
	}

	public boolean isWeightVerb(int weightX, int weightY) {
		if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof WordBlock) {
			return ((WordBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX]).isVerb();
		}
		return false;
	}

	public boolean isWeightComplement(int weightX, int weightY) {
		if (stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX] instanceof WordBlock) {
			return ((WordBlock) stageBlockArr.array[this.getArrY() + weightY][this.getArrX() + weightX]).isComplement();
		}
		return false;
	}

	public boolean checkNextFNW(int weightX, int weightY) {
		// �떎�쓬 釉붾줉�씠 �봽�젅�엫 �븞�뿉 �엳�뒗吏� 泥댄겕
		if (!this.checkNextInFrame(weightX, weightY))
			return false;

		// �떎�쓬 釉붾줉�씠 議댁옱�븯�뒗吏� 泥댄겕
		if (this.checkNextIsNull(weightX, weightY)) {
			return false;
		}
		// �떎�쓬 釉붾줉�씠 WordBlock�씤吏� 泥댄겕
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

	public void setYou(boolean flag) {
		this.isYou = flag;

		for (YouKeyListener1 ykl : manageListener.YouKeyListener1List) {
			manageListener.contentpane.removeKeyListener(ykl);
		}

		if(flag) {
	
			YouKeyListener1 ykl = new YouKeyListener1(this);
	
			// �궎 由ъ뒪�꼫瑜� �떎�젣 �떎�뒗 �룞�옉
			manageListener.contentpane.addKeyListener(ykl);
	
			// �궎 由ъ뒪�꼫 愿�由� ���긽�뿉 �뱾�뼱媛꾨떎
			manageListener.addYouKeyListener1(ykl);
		}
	}

	public void setWin(boolean flag) {
		this.isWin = flag;
	}
	
	public boolean isWin() {
		return this.isWin;
	}
	
	public boolean isYou() {
		return this.isYou;
	}
	
	/*public boolean isDefeat() {
		for(int i=0; i<water.length < i++) {
			if (this.getlocation == water[i].getlocation) return true;
			else return false;
		}
	}*/
	
	public void setisYou(boolean b) {
		this.isYou = b;
	}

}