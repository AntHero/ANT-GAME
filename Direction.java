package antgame;

public class Direction {
	int direction;

	public Direction(int direction) {
		this.direction = direction;
	}

	public Cell adjacent_cell(Position pos, Direction direction) {

		if (pos.getX() % 2 != 0) {
			switch (direction) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
		} else {
			switch (direction) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			}

		}
		

	}
		public int getDirection(){
			return direction;
		}

}
