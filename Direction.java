package antgame;

public class Direction {
	DirectionType direction;

	public Direction(DirectionType direction) {
		this.direction = direction;
	}

	public Position adjacent_cell(Position pos, DirectionType direction) {
		int x = pos.getX();
		int y = pos.getY();
		

		if (x % 2 == 0) { // for even x position values
			switch (direction) {
			case ZERO:
				return new Position(x+1, y);
			case ONE:
				return new Position(x, y+1);
			case TWO:
				return new Position(x-1, y+1);
			case THREE:
				return new Position(x-1, y);
			case FOUR:
				return new Position(x-1, y-1);
			case FIVE:
				return new Position(x, y-1);
			}
		} else {	//for odd x position values
			switch (direction) {
			case ZERO:
				return new Position(x+1, y);
			case ONE:
				return new Position(x+1, y+1);
			case TWO:
				return new Position(x, y+1);
			case THREE:
				return new Position(x-1, y);
			case FOUR:
				return new Position(x, y-1);
			case FIVE:
				return new Position(x+1, y-1);
			}

		}
		throw new IllegalArgumentException("The DirectionType has to be between ZERO and FIVE");

	}

	public DirectionType getDirection() {
		return direction;
	}

}
