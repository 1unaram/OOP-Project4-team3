package oop_project4_dodo;

public class StageBlockArray {

	Block[][] array = new Block[ConstClass.ARRAY_Y][ConstClass.ARRAY_X]; // y , x

	public void initPosition(Block b, int y, int x, String name) {
		array[y][x] = b;
		b.setText(name);
		b.setPos(y, x);
	}

	public void printArray() {
		for (Block[] b1 : array) {
			for (Block b2 : b1) {
				System.out.print(b2 == null ? "- " : b2.getText() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void setNewPosition(Block b, int oldY, int oldX, int newY, int newX) {
		array[oldY][oldX] = null;
		array[newY][newX] = b;
	}

}