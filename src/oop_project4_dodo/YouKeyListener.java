package oop_project4_dodo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class YouKeyListener extends KeyAdapter {
	
	ObjBlock you;
	
	YouKeyListener(ObjBlock you) {
		this.you = you;
	}
	
    public void keyPressed(KeyEvent e) {
    	
        int keyCode = e.getKeyCode();
        
        int currentX = you.getArrX();
        int currentY = you.getArrY();
        int weightX = 0;
        int weightY = 0;
        
        int direction = -1;
        
        switch (keyCode) {

        case KeyEvent.VK_UP:
        	weightY = -1;
        	direction = ConstClass.UP;
            break;
        case KeyEvent.VK_DOWN:
	        weightY = 1;    
	        direction = ConstClass.DOWN;
            break;
        case KeyEvent.VK_LEFT:
        	weightX = -1;
        	direction = ConstClass.LEFT;
            break;
        case KeyEvent.VK_RIGHT:
        	weightX = 1;
        	direction = ConstClass.RIGHT;
        	break;
        }
        
        // 오른쪽에 있는 obj 움직이기
    	you.pushBlock(you.stageBlockArr.array[currentY + weightY][currentX + weightX], direction);
    	
    	// You가 움직이기
    	if(you.checkMovable(direction)) {
    		
    		// 블록 배열을 업데이트
    		you.stageBlockArr.setNewPosition(you, currentY, currentX, currentY + weightY, currentX + weightX);
    		
    		// 오브젝트의 멤버 변수 변경
    		you.setPos(you.getArrY() + weightY, you.getArrX() + weightX);
    		
    		// 오브젝트의 위치 다시 그리기
    		you.setLocation(you.getX() + 60 * weightX, you.getY() + 60 * weightY);
    	}
        
    }
 
}
