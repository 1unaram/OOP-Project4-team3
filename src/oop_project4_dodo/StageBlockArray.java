package oop_project4_dodo;

public class StageBlockArray {

	/* Member Variables */
	Block[][] array = new Block[ConstClass.ARRAY_Y][ConstClass.ARRAY_X]; // y , x

	/* Method */
	// Initialize Block Position
	public void initPosition(Block block, int y, int x, String name) {
		array[y][x] = block;
		block.setText(name);
		block.setPos(y, x);
	}

	// Print Block Array for Debugging
	public void printArray() {
		for (Block[] b1 : array) {
			for (Block b2 : b1) {
				System.out.print(b2 == null ? "- " : b2.getText() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// Set New Position of Block
	public void setNewPosition(Block b, int oldY, int oldX, int newY, int newX) {
		array[oldY][oldX] = null;
		array[newY][newX] = b;
	}
}
